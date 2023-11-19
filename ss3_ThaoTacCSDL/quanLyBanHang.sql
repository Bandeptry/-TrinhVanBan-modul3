drop database quanLyBanHang;
create database quanLyBanHang;
use quanLyBanHang;

create table Customer(
	cID int primary key auto_increment,
    cName varchar(50),
    cAge tinyint
);

create table `order`(
	oID int primary key auto_increment,
    cID int,
    oDate datetime,
    oTotalPrice int,
    foreign key (cID) references Customer(cID)
);

create table Product(
	pID int primary key auto_increment,
    pName varchar(50),
    pPrice int
);

create table OrderDetail(
	odd int primary key,
	oID int,
    pID int,
    odQTY int,
    foreign key (pID) references Product(pID),
    foreign key (oID) references `Order`(oID)
);

insert into Customer
values 	(1, 'Minh Quan', 10),
		(2, 'Ngoc Oanh', 20),
		(3, 'Hong Ha', 50);

insert into `order`
values(1,1,'2006-3-21',null),
(2,1,'2006-3-23',null),
(3,1,'2006-3-16',null);
        
insert into product
values 	(1, 'May Giat', 3000),
		(2, 'Tu Lanh', 5000),
		(3, 'Dieu Hoa', 7000),
        (4, 'Quat', 1000),
		(5, 'Bep Dien', 2000);
        
insert into OrderDetail
values 	(1, 1, 1, 3),
		(2, 1, 3, 7),
		(3, 1, 4, 2),
        (4, 2, 1, 1),
		(5, 3, 1, 8),
        (6, 2, 5, 4),
		(7, 2, 3, 3);
        
-- 1.Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
-- 2.Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
-- 3.Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
-- 4.Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
		
-- 1.Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order

select *
from `order`;
-- 2.Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c.*, p.*
from customer c
inner join `order` o on c.cID = o.cID join OrderDetail od on o.oID = od.oID join product p on od.pID = p.pID;
-- 3.Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select *
from customer c
left join `order` o on c.cID = o.cID
where o.cID is null;
 -- 4.Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
--  (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
--  Giá bán của từng loại được tính = odQTY*pPrice)
select o.oID, p.pName,o.odate, sum(od.odQTY*pPrice) as 'Gia san pham'
from `order` o
join OrderDetail od on o.oID = od.oID
join product p on od.pID = p.pID
group by o.oid;


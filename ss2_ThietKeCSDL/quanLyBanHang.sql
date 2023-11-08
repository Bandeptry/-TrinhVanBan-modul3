CREATE DATABASE csdlQuanLyBanhang;
use csdlQuanLyBanhang;
create table customer(
	cID int primary key auto_increment,
    cName varchar(50) not null,
    cAge int not null check(cAge between 0 and 10)
);

create table oder(
	oID int primary key auto_increment,
    cID int,
    oDate varchar(50),
    oTotailPrice varchar(50),
    foreign key(oID) references customer(cID)
);

create table product(
	pID int primary key auto_increment,
    pName varchar(50),
    pPrice varchar(50) not null check (pPrice >0),
    foreign key(pID) references oder(oID)
); 

create table oderDetail(
	odID int PRIMARY KEY,
	oID int,
    pID int,
    soLuong int,
    foreign key (oID) references oder(oID),
    foreign key (pID) references product(pID)
);


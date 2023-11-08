drop database csdlQuanLySV;
create database csdlQuanLySV;
use csdlQuanLySV;
create table class(
	classID int primary key,
    className varchar(50),
    startDate date,
    startus int
);

create table student(
	studentID int primary key auto_increment,
    studentName varchar(50),
    address varchar(50),
    phone varchar(50),
    `status` int,
    classID int,
    foreign key (classID) references class(classID)
);

create table `subject`(
	subID int primary key auto_increment,
    subName varchar(50),
    credit int,
    `status` int
);

create table mark(
	markID int primary key,
    subID int,
	studentID int,
	mark int,
	examTimes int,
    foreign key (studentID) REFERENCES student(studentID),
    foreign key (subID) REFERENCES `subject`(subID)
);
-- Thêm lần lượt các bản ghi vào trong bảng Class
insert into class
value(1, 'A1', '2008-12-20', 1);
insert into class
value(2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);
-- Thêm dữ liệu vào trong bảng Student bằng các câu lệnh insert into
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);
-- Thêm dữ liệu nhanh vào trong bảng Subject:
insert into  `subject`
value (1, 'CF', 5, 1),
	(2, 'C', 6, 1),
	(3, 'HDJ', 5, 1),
	(4, 'RDBMS', 10, 1);
-- Thêm dữ liệu vào trong bảng Mark bằng câu lệnh insert into 
INSERT INTO Markmark (markID, SubId, StudentId, Mark, ExamTimes)
VALUES (1,1, 1, 8, 1),
       (2,2, 2, 10, 2),
       (3,3, 1, 12, 1);
-- 1.Hiển thị danh sách tất cả các học viên
-- 2.Hiển thị danh sách các học viên đang theo học.
-- 3 Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
-- 4 Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
-- 5 Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
-- 6 Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
-- 7 Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.


-- 1.Hiển thị danh sách tất cả các học viên
select *
from Student;

-- 2.Hiển thị danh sách các học viên đang theo học.//class + student
 -- s.id , s.name , c.classname
 select s.studentID, s.studentname, c.className
 from student s
 inner join class c on s.classID = c.classID 
 group by s.studentID;
-- 3 Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’

select *
from student
where studentname like 'H%'; 
-- 4 Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.

-- select *
-- from class
-- where startDate like '%12%';

select *
from class
where month(startDate)  = 12;

-- 5 Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select *
from `subject`
where credit between 3 and 5;

-- 6 Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.

update student
SET classID = '2' WHERE (studentID = '1');
-- UPDATE `csdlquanlysv`.`student` 
-- SET `classID` = '2' 
-- WHERE (`studentID` = '1');
-- 7 Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select s.studentName, sb.subname, m.mark
from student s
join mark m on s.studentID = m.studentID
join `subject` sb on m.subID = sb.subID
order by m.Mark desc, s.studentName asc


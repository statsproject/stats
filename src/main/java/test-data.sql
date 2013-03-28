insert into student_table values (1,'001','Sam','Lom','1992-1-1','sl001@mail.edu',null);
insert into student_table values (2,'002','Tom','Lin','1992-1-1','tl002@mail.edu',null);
insert into student_table values (3,'003','Jim','Ist','1992-3-3','ji003@mail.edu',null);
insert into student_table values (4,'004','Sam','Lom','1992-4-4','sl004@mail.edu',null);
insert into student_table values (5,'005','Tom','Kin','1992-5-5','tk005@mail.edu',null);
insert into student_table values (6,'006','Tim','Bar','1992-6-6','tb006@mail.edu',null);
insert into student_table values (7,'007','Ken','Tar','1992-7-7','kt007@mail.edu',null);
insert into student_table values (8,'008','Kim','Lee','1992-8-8','kl008@mail.edu',null);
insert into student_table values (9,'009','Don','Pst','1992-9-9','dp009@mail.edu',null);
insert into student_table values (10,'010','Liz','Lau','1993-10-10','ll010@mail.edu',null);
insert into student_table values (11,'011','Kat','Jin','1993-11-11','kj011@mail.edu',null);
insert into student_table values (12,'012','Mia','Est','1993-12-12','me012@mail.edu',null);
insert into student_table values (13,'013','Lia','Kom','1993-1-1','lk013@mail.edu',null);
insert into student_table values (14,'014','Mil','Leo','1993-9-9','ml014@mail.edu',null);
insert into student_table values (15,'015','Leo','Mil','1993-10-10','lm015@mail.edu',null);
insert into student_table values (16,'016','Lim','Rom','1993-11-11','lr016@mail.edu',null);

insert into teacher_table values (1,'1001','Sebastian','Goldshtein','log1','pas1','sg1001@mail.edu',null);
insert into teacher_table values (2,'1002','Cornelius','Aurelius','log2','pas2','ca1002@mail.edu',null);
insert into teacher_table values (3,'1003','Vladimir','Kozlovski','log3','pas3','vk1003@mail.edu',null);

insert into category_table values(1,'Derivatives');
insert into category_table values(2,'Integrals');
insert into category_table values(3,'Functions');
insert into category_table values(4,'Graphs');

insert into class_table values(1,'Class 1',1);
insert into class_table values(2,'Class 2',2);
insert into class_table values(3,'Class 3',3);
insert into class_table values(4,'Class 4',1);

insert into student_class_table values(1,1);
insert into student_class_table values(2,1);
insert into student_class_table values(3,1);
insert into student_class_table values(4,1);
insert into student_class_table values(5,2);
insert into student_class_table values(6,2);
insert into student_class_table values(7,2);
insert into student_class_table values(8,2);
insert into student_class_table values(9,3);
insert into student_class_table values(10,3);
insert into student_class_table values(11,3);
insert into student_class_table values(12,3);
insert into student_class_table values(13,4);
insert into student_class_table values(14,4);
insert into student_class_table values(15,4);
insert into student_class_table values(16,4);

insert into assignment_table values(1,'assn 1 for class 1','Intro to derivatives',1,1);
insert into assignment_table values(2,'assn 1 for class 2','Intro to derivatives',1,2);
insert into assignment_table values(3,'assn 1 for class 3','Intro to derivatives',1,3);
insert into assignment_table values(4,'assn 1 for class 4','Intro to derivatives',1,4);

insert into assignment_table values(5,'assn 2 for class 1','Intro to integration',2,1);
insert into assignment_table values(6,'assn 2 for class 2','Intro to integration',2,2);
insert into assignment_table values(7,'assn 2 for class 3','Intro to integration',2,3);
insert into assignment_table values(8,'assn 2 for class 4','Intro to integration',2,4);

insert into assignment_table values(9,'assn 3 for class 1','Intro to functions',3,1);
insert into assignment_table values(10,'assn 3 for class 2','Intro to functions',3,2);
insert into assignment_table values(11,'assn 3 for class 3','Intro to functions',3,3);
insert into assignment_table values(12,'assn 3 for class 4','Intro to functions',3,4);

insert into assignment_table values(13,'assn 4 for class 1','Intro to graphs',4,1);
insert into assignment_table values(14,'assn 4 for class 2','Intro to graphs',4,2);
insert into assignment_table values(15,'assn 4 for class 3','Intro to graphs',4,3);
insert into assignment_table values(16,'assn 4 for class 4','Intro to graphs',4,4);

insert into assignment_table values(17,'assn 5 for class 1','Complex graphs',4,1);
insert into assignment_table values(18,'assn 5 for class 2','Complex graphs',4,2);
insert into assignment_table values(19,'assn 5 for class 3','Complex graphs',4,3);


insert into grade_table values(1,5.0,1,1);
insert into grade_table values(2,10.0,1,5);
insert into grade_table values(3,5.0,1,9);
insert into grade_table values(4,10.0,1,13);

insert into grade_table values(5,6.0,2,1);
insert into grade_table values(6,2.0,2,5);
insert into grade_table values(7,10.0,2,9);
insert into grade_table values(8,3.0,2,13);

insert into grade_table values(9,8.0,3,1);
insert into grade_table values(10,8.0,3,5);
insert into grade_table values(11,7.0,3,9);
insert into grade_table values(12,7.0,3,13);

insert into grade_table values(13,6.0,4,1);
insert into grade_table values(14,5.0,4,5);
insert into grade_table values(15,7.0,4,9);
insert into grade_table values(16,5.0,4,13);

insert into grade_table values(17,3.0,5,2);
insert into grade_table values(18,5.0,5,6);
insert into grade_table values(19,4.0,5,10);
insert into grade_table values(20,7.0,5,14);

insert into grade_table values(21,9.0,6,2);
insert into grade_table values(22,8.0,6,6);
insert into grade_table values(23,7.0,6,10);
insert into grade_table values(24,6.0,6,14);

insert into grade_table values(25,2.0,7,2);
insert into grade_table values(26,3.0,7,6);
insert into grade_table values(27,4.0,7,10);
insert into grade_table values(28,7.0,7,14);

insert into grade_table values(29,3.5,8,2);
insert into grade_table values(30,5.5,8,6);
insert into grade_table values(31,4.5,8,10);
insert into grade_table values(32,7.5,8,14);

insert into grade_table values(33,6.0,9,3);
insert into grade_table values(34,5.0,9,7);
insert into grade_table values(35,4.0,9,11);
insert into grade_table values(36,9.0,9,15);

insert into grade_table values(37,9.0,10,3);
insert into grade_table values(38,9.0,10,7);
insert into grade_table values(39,9.0,10,11);
insert into grade_table values(40,9.0,10,15);

insert into grade_table values(41,1.0,11,3);
insert into grade_table values(42,0.0,11,7);
insert into grade_table values(43,0.0,11,11);
insert into grade_table values(44,7.0,11,15);

insert into grade_table values(45,3.5,12,3);
insert into grade_table values(46,5.5,12,7);
insert into grade_table values(47,4.3,12,11);
insert into grade_table values(48,7.3,12,15);

insert into grade_table values(49,6.0,13,4);
insert into grade_table values(50,5.0,13,8);
insert into grade_table values(51,4.0,13,12);
insert into grade_table values(52,9.0,13,16);

insert into grade_table values(53,9.1,14,4);
insert into grade_table values(54,9.2,14,8);
insert into grade_table values(55,9.2,14,12);
insert into grade_table values(56,9.1,14,16);

insert into grade_table values(57,10.0,15,4);
insert into grade_table values(58,10.0,15,8);
insert into grade_table values(59,10.0,15,12);
insert into grade_table values(60,7.0,15,16);

insert into grade_table values(61,8.5,16,4);
insert into grade_table values(62,8.5,16,8);
insert into grade_table values(63,8.3,16,12);
insert into grade_table values(64,8.3,16,16);

insert into grade_table values(65,5,1,17);
insert into grade_table values(66,3,2,17);
insert into grade_table values(67,1,3,17);
insert into grade_table values(68,4,4,17);

insert into grade_table values(69,5.9,5,18);
insert into grade_table values(70,3.1,6,18);
insert into grade_table values(80,1.9,7,18);
insert into grade_table values(81,4.9,8,18);

insert into grade_table values(82,6,9,19);
insert into grade_table values(83,1,10,19);
insert into grade_table values(84,9,11,19);
insert into grade_table values(85,9,12,19);

CREATE TABLE assignment_table 
    ( 
     assignment_id NUMBER  auto_increment NOT NULL , 
     assignment_name VARCHAR2 (50 CHAR)  NOT NULL , 
     assignment_description VARCHAR2 (300 CHAR)  NOT NULL , 
     category_id NUMBER  NOT NULL , 
     class_id NUMBER  NOT NULL 
    ) 
;



ALTER TABLE assignment_table 
    ADD CONSTRAINT "assignment_table PK" PRIMARY KEY ( assignment_id ) ;



CREATE TABLE category_table 
    ( 
     category_id NUMBER  auto_increment NOT NULL , 
     category_name VARCHAR2 (50 CHAR)  NOT NULL 
    ) 
;



ALTER TABLE category_table 
    ADD CONSTRAINT "category_table PK" PRIMARY KEY ( category_id ) ;



CREATE TABLE class_table 
    ( 
     class_id NUMBER  NOT NULL , 
     class_name VARCHAR2 (50 CHAR)  NOT NULL , 
     teacher_id NUMBER 
    ) 
;



ALTER TABLE class_table 
    ADD CONSTRAINT "class_table PK" PRIMARY KEY ( class_id ) ;



CREATE TABLE grade_table 
    ( 
     grade_id NUMBER  auto_increment NOT NULL , 
     grade NUMBER , 
     student_id NUMBER  NOT NULL , 
     assignment_id NUMBER  NOT NULL 
    ) 
;



ALTER TABLE grade_table 
    ADD CONSTRAINT "grade_table PK" PRIMARY KEY ( grade_id ) ;



CREATE TABLE student_class_table 
    ( 
     student_id NUMBER  NOT NULL , 
     class_id NUMBER  NOT NULL 
    ) 
;



ALTER TABLE student_class_table 
    ADD CONSTRAINT "student_class_table PK" PRIMARY KEY ( student_id, class_id ) ;



CREATE TABLE student_table 
    ( 
     student_id NUMBER auto_increment NOT NULL , 
     student_school_id VARCHAR2 (20 CHAR)  NOT NULL ,
     student_first_name VARCHAR2 (30 CHAR)  NOT NULL , 
     student_last_name VARCHAR2 (30 CHAR)  NOT NULL , 
     dob DATE  NOT NULL , 
     email VARCHAR2 (60 CHAR)  NOT NULL , 
     student_clever_id NUMBER 
    ) 
;



ALTER TABLE student_table 
    ADD CONSTRAINT "student_table PK" PRIMARY KEY ( student_id ) ;



CREATE TABLE teacher_table 
    ( 
     teacher_id NUMBER  auto_increment NOT NULL ,
     teacher_school_id VARCHAR2 (20 CHAR)  NOT NULL ,
     teacher_first_name VARCHAR2 (30 CHAR)  NOT NULL , 
     teacher_last_name VARCHAR2 (30 CHAR)  NOT NULL , 
     login VARCHAR2 (50 CHAR)  NOT NULL ,
     passwd VARCHAR2 (50 CHAR)  NOT NULL ,
     email VARCHAR2 (60 CHAR)  NOT NULL ,
     teacher_clever_id NUMBER 
    ) 
;



ALTER TABLE teacher_table 
    ADD CONSTRAINT "teacher_table PK" PRIMARY KEY ( teacher_id ) ;




ALTER TABLE student_class_table 
    ADD CONSTRAINT Relation_1 FOREIGN KEY 
    ( 
     student_id
    ) 
    REFERENCES student_table 
    ( 
     student_id
    ) 
;


ALTER TABLE student_class_table 
    ADD CONSTRAINT Relation_2 FOREIGN KEY 
    ( 
     class_id
    ) 
    REFERENCES class_table 
    ( 
     class_id
    ) 
;


ALTER TABLE class_table 
    ADD CONSTRAINT Relation_3 FOREIGN KEY 
    ( 
     teacher_id
    ) 
    REFERENCES teacher_table 
    ( 
     teacher_id
    ) 
;


ALTER TABLE assignment_table 
    ADD CONSTRAINT Relation_4 FOREIGN KEY 
    ( 
     category_id
    ) 
    REFERENCES category_table 
    ( 
     category_id
    ) 
;


ALTER TABLE assignment_table 
    ADD CONSTRAINT Relation_6 FOREIGN KEY 
    ( 
     class_id
    ) 
    REFERENCES class_table 
    ( 
     class_id
    ) 
;


ALTER TABLE grade_table 
    ADD CONSTRAINT Relation_7 FOREIGN KEY 
    ( 
     student_id
    ) 
    REFERENCES student_table 
    ( 
     student_id
    ) 
;


ALTER TABLE grade_table 
    ADD CONSTRAINT Relation_9 FOREIGN KEY 
    ( 
     assignment_id
    ) 
    REFERENCES assignment_table 
    ( 
     assignment_id
    ) 
;

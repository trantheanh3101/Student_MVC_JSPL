create table students
(
    id       int auto_increment
        primary key,
    name     varchar(120) not null,
    address  varchar(220) not null,
    point    float        null,
    id_class int          null,
    constraint students_classroom_id_class_fk
        foreign key (id_class) references classroom (id_class)
);

INSERT INTO student.students (id, name, address, point, id_class) VALUES (1, 'The Anh', 'Thanh hoa', 9, 1);
INSERT INTO student.students (id, name, address, point, id_class) VALUES (2, 'Minh Tu', 'Ha Noi', 8.7, 2);
INSERT INTO student.students (id, name, address, point, id_class) VALUES (3, 'Quoc Bao', 'Da Nang', 8.2, 2);
INSERT INTO student.students (id, name, address, point, id_class) VALUES (4, 'Lan Huong', 'Hai Phong', 9.2, 1);
INSERT INTO student.students (id, name, address, point, id_class) VALUES (14, 'trần thế anh', 'Mỹ Đình- Hà Nội', 9, 1);
INSERT INTO student.students (id, name, address, point, id_class) VALUES (15, 'Alan Tran', 'Nam', 9, 1);
INSERT INTO student.students (id, name, address, point, id_class) VALUES (16, 'trần ngọc đức', 'Mỹ Đình- Hà Nội', 8.7, 1);
INSERT INTO student.students (id, name, address, point, id_class) VALUES (17, 'xuân hùng', 'thanh hoa', 8.7, 3);

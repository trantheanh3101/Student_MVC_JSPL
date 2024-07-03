create table classroom
(
    id_class int auto_increment
        primary key,
    name     varchar(50) null
);

INSERT INTO student.classroom (id_class, name) VALUES (1, 'C03H1');
INSERT INTO student.classroom (id_class, name) VALUES (2, 'c04h1');
INSERT INTO student.classroom (id_class, name) VALUES (3, 'c05h1');

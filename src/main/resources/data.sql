insert into teacher(teacher_name, phone) values
    ('DR Hazlina Hamdan','03-89477435');
insert into teacher(teacher_name, phone) values
    ('DR Izuan Hafeez','03-84577126');
insert into teacher(teacher_name, phone) values
    ('DR Razali Yaakob','03-89990765');


insert into course(course_name, course_credit, department) values ('Computer Security',3, 'Computer System');
insert into course(course_name, course_credit, department) values ('Artificial Intelligence',3, 'Computer System');
insert into course(course_name, course_credit, department) values ('Mobile Application',2, 'Software Engineering');

update course set teacher_id = 1
              where course_id = 1;
update course set teacher_id = 2
              where course_id = 2;
update course set teacher_id = 3
              where course_id = 3;
update course set teacher_id = 4
              where course_id = 4;
update course set teacher_id = 5
              where course_id = 5;

insert into student (student_name, email) values ('Allieysa', 'allieysa1@gmail');
insert into student (student_name, email) values ('Fatima', 'fatima@gmail');
insert into student (student_name, email) values ('Syakila', 'syakila02@gmail');
insert into student (student_name, email) values ('Jannah', 'jannahH@gmail');
insert into student (student_name, email) values ('Qistina', 'qistinaX@gmail');


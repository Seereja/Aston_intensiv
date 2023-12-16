
INSERT INTO users (id, name, surname, email, phone, age)
VALUES (3, 'Name3', 'Surname3', 'email3@example.com', 1234567892, 7),
       (4, 'Name4', 'Surname4', 'email4@example.com', 1234567893, 8),
       (5, 'Name5', 'Surname5', 'email5@example.com', 1234567894, 9),
       (6, 'Name6', 'Surname6', 'email6@example.com', 1234567895, 10),
       (7, 'Name7', 'Surname7', 'email7@example.com', 1234567896, 8),
       (8, 'Name8', 'Surname8', 'email8@example.com', 1234567897, 10),
       (9, 'Name9', 'Surname9', 'email9@example.com', 1234567898, 33),
       (10, 'Name10', 'Surname10', 'email10@example.com', 1234567899, 34),
       (11, 'Name11', 'Surname11', 'email11@example.com', 1234567810, 35),
       (12, 'Name12', 'Surname12', 'email12@example.com', 1234567811, 36),
       (13, 'Name13', 'Surname13', 'email13@example.com', 1234567812, 37),
       (14, 'Name14', 'Surname14', 'email14@example.com', 1234567813, 38),
       (15, 'Name15', 'Surname15', 'email15@example.com', 1234567814, 39);

INSERT INTO children (id, categoryinsports)
VALUES (10, 'Senior'),
       (3, 'Junior'),
       (4, 'Senior'),
       (5, 'Junior'),
       (6, 'Senior'),
       (7, 'Junior'),
       (8, 'Senior');

INSERT INTO teachers (id, category, section_id)
VALUES (9,'Junior', 1),
       (11,'Senior', 2),
       (12,'Junior', 3),
       (13,'Senior', 3);

insert into sections(id,section_name )
values (1, 'FB'),
       (2, 'BB'),
       (3, 'GB'),
       (4, 'CH');
insert into sections(id, section_name)
values (5, 'GB'),
       (6, 'VB'),
       (7, 'CCH'),
       (8, 'TT');

insert into children_section(child_id, section_id)
values (3, 1),
       (4, 2),
       (5, 1),
       (6, 2),
       (7, 3),
       (8, 3);
-- insert into roles (id, name)
-- VALUES (1, 'тренер'),
--        (2, 'ребенок');

-- insert into users_roles(user_id, role_id)
-- VALUES (1,2),
--        (2,2),
--        (3,2),
--        (4,2),
--        (5,2),
--        (6,2),
--        (7,2),
--        (8,2),
--        (9,1),
--        (10,1),
--        (11,1),
--        (12,1);



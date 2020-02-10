INSERT INTO country (id, name) VALUES (1, 'Belarus');
-- INSERT INTO country (id, name) VALUES (2, 'Ukraine');
-- INSERT INTO country (id, name) VALUES (3, 'Russia');
-- INSERT INTO country (id, name) VALUES (4, 'USA');
-- INSERT INTO country (id, name) VALUES (5, 'Italy');

INSERT INTO company (id, name, country_id, address) VALUES (6, 'iTechArt', 1, 'Leninskaya 9');

INSERT INTO department (id, name, company_id) VALUES (7, 'Java', 6);
INSERT INTO department (id, name, company_id) VALUES (8, 'JS', 6);

INSERT INTO employee (id, first_name, last_name, email, department_id) VALUES (9, 'Evgeniya', 'Kustreeva', 'test@mail.com', 7);
INSERT INTO employee (id, first_name, last_name, email, department_id) VALUES (10, 'Ivan', 'Ivanov', 'ivan@mail.com', 7);
INSERT INTO employee (id, first_name, last_name, email, department_id) VALUES (11, 'Masha', 'Pupkina', 'ivan@mail.com', 8);
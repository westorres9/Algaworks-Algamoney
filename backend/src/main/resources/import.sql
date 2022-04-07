INSERT INTO tb_category (name, created_At) VALUES ('Lazer', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Supermercado', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Alimentação', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Fármacia', NOW());
INSERT INTO tb_category (name, created_At) VALUES ('Outros', NOW());

INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Wester Torres', true, 'Uberlandia', 'front', 'Morumbi', '271', 'Minas Gerais', 'Rua Arca', '38407-270');
INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Dayane Rosa', true, 'Uberlandia', 'front', 'Morumbi', '271', 'Minas Gerais', 'Rua Arca', '38407-270');
INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Ronaldo Santos', true, 'Uberlandia', 'front', 'Morumbi', '819', 'Minas Gerais', 'Rua Guapeva', '38407-318');
INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Neuza Rosa', true, 'Uberlandia', 'front', 'Morumbi', '819', 'Minas Gerais', 'Rua Guapeva', '38407-318');


INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Salário mensal', '2017-06-10', null, 6500.00, 'Distribuição de lucros', 'INCOME', 1, 1);
INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Bahamas', '2017-02-10', '2017-02-10', 100.32, null, 'EXPENSE', 2, 2);
INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Top Club', '2017-06-10', null, 120, null, 'INCOME', 3, 3);
INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'Geração', 'INCOME', 3, 4);
INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('DMAE', '2017-06-10', null, 200.30, null, 'EXPENSE', 3, 4);
INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Extra', '2017-03-10', '2017-03-10', 1010.32, null, 'INCOME', 4, 3);
INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Bahamas', '2017-06-10', null, 500, null, 'INCOME', 1, 4);
INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Top Club', '2017-03-10', '2017-03-10', 400.32, null, 'EXPENSE', 4, 2);
INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Despachante', '2017-06-10', null, 123.64, 'Multas', 'EXPENSE', 3, 1);
INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Pneus', '2017-04-10', '2017-04-10', 665.33, null, 'INCOME', 5, 3);
INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Café', '2017-06-10', null, 8.32, null, 'EXPENSE', 1, 4);
INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Eletrônicos', '2017-04-10', '2017-04-10', 2100.32, null, 'EXPENSE', 5, 1);
INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Instrumentos', '2017-06-10', null, 1040.32, null, 'EXPENSE', 4, 3);
INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Café', '2017-04-10', '2017-04-10', 4.32, null, 'EXPENSE', 4, 2);
INSERT INTO tb_releases (description, due_date, payment_date, value, note, type, category_id, person_id) VALUES ('Lanche', '2017-06-10', null, 10.20, null, 'EXPENSE', 4, 1);




INSERT INTO tb_category (name) VALUES ('Lazer');
INSERT INTO tb_category (name) VALUES ('Supermercado');
INSERT INTO tb_category (name) VALUES ('Alimentação');
INSERT INTO tb_category (name) VALUES ('Fármacia');
INSERT INTO tb_category (name) VALUES ('Outros');


INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '123456');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '123456');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Wester Torres', true, 'Uberlandia', 'residencia', 'Morumbi', '271', 'Minas Gerais', 'Rua Arca', '38407-270');
INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Dayane Rosa', true, 'Uberlandia',  'residencia', 'Morumbi', '271', 'Minas Gerais', 'Rua Arca', '38407-270');
INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Ronaldo Santos', true, 'Uberlandia',  'residencia', 'Morumbi', '819', 'Minas Gerais', 'Rua Guapeva', '38407-318');
INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Neuza Rosa', true, 'Uberlandia',  'residencia', 'Morumbi', '819', 'Minas Gerais', 'Rua Guapeva', '38407-318');
INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Isabela Martins', true , 'Manaus','Apto 10','Centro','1366','Amazonas', 'Rua da Terra','99400-12');
INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Leonardo Oliveira', true , 'Uberlândia','Casa Fundo','Segismundo Pereira','199', 'Minas Gerais', 'Rua do Músico','38400-00');
INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Carlos Santana', true , 'Belo Horizonte','Casa 2', 'Centro','433', 'Minas Gerais', 'Rua da Manga', '31400-12');
INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Henrique Medeiros', true , 'Rio de Janeiro', 'Apto 201','Centro', '1120','Rio de Janeiro', 'Rua do Sapo', '12400-12');
INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Pedro Barbosa', true , 'Rio Grande do Sul', 'Casa fundo', 'Tubalina', '322', 'Rio Grande do Sul', 'Rua da Lagoa','77400-12');
INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Josué Mariano', true , 'Porto Alegre', 'residencia', 'Jardins', '321','Rio Grande do Sul','Av Rio Branco', '56400-12');
INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Ricardo Pereira', true , 'Salvador',  'Apto 302', 'Aparecida', '123','Bahia', 'Rua do Motorista','38400-12');
INSERT INTO tb_person (name, active, city, complement, district, number, state, street, zip_code) VALUES ('Maria Rita', true , 'Ribeirão Preto', 'Apto 101', 'Colina', '110','São Paulo','Rua do Sabiá','11400-12');





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





INSERT INTO tb_user (email, name, password, created_At) VALUES ( 'maria@gmail.com', 'Maria Brown', '$2a$10$Jzvp07GPTSEfEmF3K8/QL.SpZLKtycvhs35Xc27fOW3J3UqbXHpHK', NOW());
INSERT INTO tb_user (email, name, password, created_At) VALUES ( 'alex@gmail.com', 'Alex Green', '$2a$10$Jzvp07GPTSEfEmF3K8/QL.SpZLKtycvhs35Xc27fOW3J3UqbXHpHK',  NOW());

INSERT INTO tb_category (name, created_At, user_id) VALUES ('Food', NOW(), 1);
INSERT INTO tb_category (name, created_At, user_id) VALUES ('House', NOW(), 1);
INSERT INTO tb_category (name, created_At, user_id) VALUES ('Installments', NOW(), 1);

INSERT INTO tb_category (name, created_At, user_id) VALUES ('Liesure', NOW(), 2);
INSERT INTO tb_category (name, created_At, user_id) VALUES ('Groceries', NOW(), 2);
INSERT INTO tb_category (name, created_At, user_id) VALUES ('Gym Supplements', NOW(), 2);

INSERT INTO tb_expense (amount, date, user_id, category_id) VALUES (200.0, TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z', 1, 1 );
INSERT INTO tb_expense (amount, date, user_id, category_id) VALUES (50.0, TIMESTAMP WITH TIME ZONE '2022-07-20T13:00:00Z', 1, 2 );
INSERT INTO tb_expense (amount, date, user_id, category_id) VALUES (450.0, TIMESTAMP WITH TIME ZONE '2022-07-05T13:00:00Z', 1, 3 );
INSERT INTO tb_expense (amount, date, user_id, category_id) VALUES (200.0, TIMESTAMP WITH TIME ZONE '2022-07-20T13:00:00Z', 2, 4 );
INSERT INTO tb_expense (amount, date, user_id, category_id) VALUES (60.0, TIMESTAMP WITH TIME ZONE '2022-04-20T13:00:00Z', 2, 5 );
INSERT INTO tb_expense (amount, date, user_id, category_id) VALUES (1200.0, TIMESTAMP WITH TIME ZONE '2022-05-20T13:00:00Z', 2, 6 );

INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
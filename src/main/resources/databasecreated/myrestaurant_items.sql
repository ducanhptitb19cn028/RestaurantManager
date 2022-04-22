create table items
(
    name        varchar(100)   not null,
    price       decimal(50, 2) not null,
    quantity    int            not null,
    import_date date           not null
);

INSERT INTO myrestaurant.items (name, price, quantity, import_date) VALUES ('Bàn', 120000.00, 12, '2022-04-06');
INSERT INTO myrestaurant.items (name, price, quantity, import_date) VALUES ('Ghế', 35000.00, 60, '2022-04-06');
INSERT INTO myrestaurant.items (name, price, quantity, import_date) VALUES ('Bát lớn', 10000.00, 100, '2022-04-07');
INSERT INTO myrestaurant.items (name, price, quantity, import_date) VALUES ('Quạt trần', 1000000.00, 16, '2022-04-15');
INSERT INTO myrestaurant.items (name, price, quantity, import_date) VALUES ('Đôi đũa', 1000.00, 100, '2022-04-15');
INSERT INTO myrestaurant.items (name, price, quantity, import_date) VALUES ('Chổi lớn', 35000.00, 10, '2022-04-15');
INSERT INTO myrestaurant.items (name, price, quantity, import_date) VALUES ('Giấy ăn', 40000.00, 400, '2022-04-18');

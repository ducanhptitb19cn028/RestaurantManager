create table items
(
    name        varchar(100)   not null,
    price       decimal(50, 2) not null,
    quantity    int            not null,
    import_date date           not null,
    imported_by varchar(50)    not null,
    constraint items_users_username_fk
        foreign key (imported_by) references users (username)
);

INSERT INTO myrestaurant.items (name, price, quantity, import_date, imported_by) VALUES ('Bát lớn', 12000.00, 100, '2022-05-04', 'ducanhboss');
INSERT INTO myrestaurant.items (name, price, quantity, import_date, imported_by) VALUES ('Gói xúc xích', 50000.00, 140, '2022-05-04', 'ducanhboss');
INSERT INTO myrestaurant.items (name, price, quantity, import_date, imported_by) VALUES ('Quạt trần', 560000.00, 22, '2022-05-04', 'ducanhboss');
INSERT INTO myrestaurant.items (name, price, quantity, import_date, imported_by) VALUES ('Đĩa lòng sâu to', 22000.00, 100, '2022-05-04', 'ducanhboss');

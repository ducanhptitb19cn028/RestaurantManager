create table tblorder
(
    orderid  int auto_increment
        primary key,
    quantity int            not null,
    oprice   decimal(10, 2) not null,
    orderday date           not null,
    staff    varchar(50)    not null,
    constraint tblorder_users_username_fk
        foreign key (staff) references tblusers (username)
)
    auto_increment = 13;

INSERT INTO myrestaurant.tblorder (orderid, quantity, oprice, orderday, staff) VALUES (1, 17, 952000.00, '2022-05-03', 'ducanhboss');
INSERT INTO myrestaurant.tblorder (orderid, quantity, oprice, orderday, staff) VALUES (2, 17, 952000.00, '2022-05-03', 'ducanhboss');
INSERT INTO myrestaurant.tblorder (orderid, quantity, oprice, orderday, staff) VALUES (3, 12, 474000.00, '2022-05-03', 'ducanhboss');
INSERT INTO myrestaurant.tblorder (orderid, quantity, oprice, orderday, staff) VALUES (4, 20, 912000.00, '2022-05-04', 'vananh0310');
INSERT INTO myrestaurant.tblorder (orderid, quantity, oprice, orderday, staff) VALUES (5, 32, 1584000.00, '2022-05-04', 'vananh0310');
INSERT INTO myrestaurant.tblorder (orderid, quantity, oprice, orderday, staff) VALUES (6, 10, 539000.00, '2022-05-04', 'paaaaadmin');
INSERT INTO myrestaurant.tblorder (orderid, quantity, oprice, orderday, staff) VALUES (7, 21, 1078000.00, '2022-05-04', 'paaaaadmin');
INSERT INTO myrestaurant.tblorder (orderid, quantity, oprice, orderday, staff) VALUES (8, 22, 946000.00, '2022-05-04', 'kdbmc2861991');
INSERT INTO myrestaurant.tblorder (orderid, quantity, oprice, orderday, staff) VALUES (9, 4, 210000.00, '2022-05-05', 'ducanhboss');
INSERT INTO myrestaurant.tblorder (orderid, quantity, oprice, orderday, staff) VALUES (10, 4, 158000.00, '2022-05-05', 'ducanhboss');
INSERT INTO myrestaurant.tblorder (orderid, quantity, oprice, orderday, staff) VALUES (11, 4, 158000.00, '2022-05-05', 'ducanhboss');
INSERT INTO myrestaurant.tblorder (orderid, quantity, oprice, orderday, staff) VALUES (12, 4, 210000.00, '2022-05-07', 'ducanhboss');

create table tblcartitem
(
    id        int auto_increment
        primary key,
    cname     varchar(50)    not null,
    price     decimal(10, 2) not null,
    cquantity int            not null,
    constraint cart_cname_uindex
        unique (cname),
    constraint cart_menu_no_fk
        foreign key (id) references tblmenu (no)
)
    auto_increment = 8;

INSERT INTO myrestaurant.tblcartitem (id, cname, price, cquantity) VALUES (1, 'Pizza', 56000.00, 150);
INSERT INTO myrestaurant.tblcartitem (id, cname, price, cquantity) VALUES (2, 'Hotdog', 49000.00, 83);
INSERT INTO myrestaurant.tblcartitem (id, cname, price, cquantity) VALUES (3, 'Lemon tea', 30000.00, 134);
INSERT INTO myrestaurant.tblcartitem (id, cname, price, cquantity) VALUES (4, 'Pancake', 45000.00, 118);
INSERT INTO myrestaurant.tblcartitem (id, cname, price, cquantity) VALUES (5, 'Socola milk tea', 30000.00, 54);
INSERT INTO myrestaurant.tblcartitem (id, cname, price, cquantity) VALUES (6, 'Matcha milk tea', 35000.00, 39);
INSERT INTO myrestaurant.tblcartitem (id, cname, price, cquantity) VALUES (7, 'Matcha cake', 49000.00, 45);

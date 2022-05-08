create table cartitem
(
    id        int auto_increment
        primary key,
    cname     varchar(50)    not null,
    price     decimal(10, 2) not null,
    cquantity int            not null,
    constraint cart_cname_uindex
        unique (cname),
    constraint cart_menu_no_fk
        foreign key (id) references menu (no)
)
    auto_increment = 4;

INSERT INTO myrestaurant.cartitem (id, cname, price, cquantity) VALUES (1, 'Pizza', 56000.00, 152);
INSERT INTO myrestaurant.cartitem (id, cname, price, cquantity) VALUES (2, 'Hotdog', 49000.00, 87);
INSERT INTO myrestaurant.cartitem (id, cname, price, cquantity) VALUES (3, 'Lemon tea', 30000.00, 134);
INSERT INTO myrestaurant.cartitem (id, cname, price, cquantity) VALUES (4, 'Pancake', 45000.00, 118);
INSERT INTO myrestaurant.cartitem (id, cname, price, cquantity) VALUES (5, 'Socola milk tea', 30000.00, 54);

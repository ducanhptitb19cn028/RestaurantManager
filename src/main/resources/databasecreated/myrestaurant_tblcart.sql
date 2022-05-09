create table tblcart
(
    cname varchar(50)    not null,
    price decimal(10, 2) not null,
    num   int            not null,
    constraint cart_cartitem_cname_fk
        foreign key (cname) references tblcartitem (cname)
);


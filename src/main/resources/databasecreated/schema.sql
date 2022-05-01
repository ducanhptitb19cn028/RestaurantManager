create table if not exists cart
(
    cname varchar(50)   not null,
    price double(10, 2) not null,
    num   int           not null
);

create table if not exists items
(
    name        varchar(100)   not null,
    price       decimal(50, 2) not null,
    quantity    int            not null,
    import_date date           not null
);

create table if not exists labour
(
    labour_id    int auto_increment
        primary key,
    name         varchar(50)    not null,
    date_ofBirth varchar(10)    not null,
    email        varchar(50)    not null,
    phone        varchar(50)    not null,
    address      varchar(100)   not null,
    position     varchar(50)    not null,
    salary       decimal(50, 2) not null
);

create table if not exists menu
(
    no    int auto_increment
        primary key,
    mname varchar(50)    not null,
    image longblob       null,
    price decimal(10, 2) not null,
    kind  varchar(50)    not null,
    constraint menu_mname_uindex
        unique (mname)
)

create table if not exists cartitem
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
);

create table if not exists users
(
    no       int auto_increment
        primary key,
    name     varchar(20)  not null,
    email    varchar(25)  not null,
    phone    varchar(25)  not null,
    username varchar(50)  not null,
    password varchar(32)  not null,
    position varchar(100) not null,
    constraint email
        unique (email),
    constraint username
        unique (username)
);

create table if not exists tblorder
(
    orderid  int auto_increment
        primary key,
    quantity int            not null,
    oprice   decimal(10, 2) not null,
    orderday date           not null,
    staff    varchar(50)    not null,
    constraint tblorder_users_username_fk
        foreign key (staff) references users (username)
);



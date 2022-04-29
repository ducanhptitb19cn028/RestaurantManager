create table menu
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
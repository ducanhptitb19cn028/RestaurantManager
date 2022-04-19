create table labour
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
)
    auto_increment = 2;



create table menu
(
    no    int auto_increment
        primary key,
    food  varchar(50)    not null,
    image blob           not null,
    price decimal(10, 2) not null,
    unit  varchar(50)    not null
);



create table menuuu
(
    no    int auto_increment
        primary key,
    food  varchar(50)    not null,
    image longblob         not null,
    price decimal(10, 2) not null,
    unit  varchar(50)    not null
);



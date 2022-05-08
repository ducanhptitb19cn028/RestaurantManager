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
    salary       decimal(50, 2) not null,
    added_by     varchar(50)    not null,
    constraint labour_users_username_fk
        foreign key (added_by) references users (username)
);

INSERT INTO myrestaurant.labour (labour_id, name, date_ofBirth, email, phone, address, position, salary, added_by) VALUES (1, 'Duc Anh', '03/12/2001', 'ducanh.3122001@gmail.com', '0984620952', 'Thanh Mai, Thanh Oai, Ha Noi', 'Boss', 450000000.00, 'ducanhboss');

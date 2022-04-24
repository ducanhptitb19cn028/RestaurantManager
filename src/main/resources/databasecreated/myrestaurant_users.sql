create table users
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
)
    auto_increment = 3;

INSERT INTO myrestaurant.users (no, name, email, phone, username, password, position) VALUES (1, 'Nguyễn Ngọc Đức Anh', 'ducanh.3122001@gmail.com', '0978816300', 'ducanhnt01', '3122001', '');
INSERT INTO myrestaurant.users (no, name, email, phone, username, password, position) VALUES (2, 'Duc Anh', 'ducanhnt02@gmail.com', '0978816300', 'ducanhboss', 'ducanh3122001', 'Chủ nhà hàng');

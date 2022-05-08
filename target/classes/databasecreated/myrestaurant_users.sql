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
    auto_increment = 5;

INSERT INTO myrestaurant.users (no, name, email, phone, username, password, position) VALUES (1, 'Duc Anh', 'ducanh.3122001@gmail.com', '0969302213', 'ducanhboss', 'Ducanh@3122001', 'Boss');
INSERT INTO myrestaurant.users (no, name, email, phone, username, password, position) VALUES (2, 'Phuc Anh', 'pa0312@gmail.com', '0975112920', 'paaaaadmin', '3122001', 'Admin');
INSERT INTO myrestaurant.users (no, name, email, phone, username, password, position) VALUES (3, 'Van Anh', 'ltva02@gmail.com', '0978888881', 'vananh0310', 'Vananh@0310', 'Receptionist');
INSERT INTO myrestaurant.users (no, name, email, phone, username, password, position) VALUES (4, 'Kevin De Bruyne', 'kdb@gmail.com', '0988556799', 'kdbmc2861991', 'Kevin@286', 'Staff');

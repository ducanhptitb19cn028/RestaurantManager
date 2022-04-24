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
    auto_increment = 3;

INSERT INTO myrestaurant.labour (labour_id, name, date_ofBirth, email, phone, address, position, salary) VALUES (1, 'Phạm Ngọc Hùng', '09/08/1999', 'hungpn01@gmail.com', '0988997889', 'Kiến Hưng, Hà Đông, Hà Nộ', 'Quản lý', 21000000.00);
INSERT INTO myrestaurant.labour (labour_id, name, date_ofBirth, email, phone, address, position, salary) VALUES (2, 'Văn Sĩ Hùng', '02/03/1989', 'hungvs@gmail.com', '0989887998', 'Chưa rõ', 'Nhân viên tiếp thị', 8000000.00);

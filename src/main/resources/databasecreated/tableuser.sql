create table users(no int(10) primary key auto_increment not null,
name varchar(20) not null,
email varchar(25) not null,
phone varchar(25) not null,
username varchar(50) not null,
password varchar(32) not null,
unique (email) ,
unique (username)
)
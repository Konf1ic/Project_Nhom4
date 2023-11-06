create
database ecommerces;

use
ecommerces;

create table ecommerces
(
    id           int auto_increment primary key,
    username     varchar(255) not null unique,
    password     varchar(255) not null,
    email        varchar(70)  not null unique,
    name         varchar(50) unique,
    age          int check (age > 18 and age < 60),
    phone_number varchar(11),
    address      varchar(255),
    wage         int,
    position     varchar(50)  not null
);

ALTER TABLE ecommerces
    ADD CONSTRAINT Luong CHECK (wage > 0 && wage<100000000)

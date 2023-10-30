create database ecommerces;

use ecommerces;

create table ecommerce(
id int primary key not null,
username varchar(255) not null,
password int not null,
name varchar(255) not null,
age int not null,
phone_number varchar(11) not null,
address varchar(255) not null,
wage int not null
 );

ALTER TABLE ecommerce ADD CONSTRAINT Tuoi CHECK (age>18 && age<60);
ALTER TABLE ecommerce ADD CONSTRAINT Luong CHECK (wage>0 && wage<100000000);

create database ecommerces;

use ecommerces;

create table ecommerces(
id int auto_increment primary key,
username varchar(255) not null unique,
password varchar(255) not null,
name varchar(255) not null,
age int check (age > 18 and age < 60),
phone_number varchar(20) not null,
address varchar(255) not null,
wage decimal(10, 2) check (wage > 0 AND salary < 100000000)
position varchar(50) not null
 );
 
 -- Them tk
INSERT INTO ecommerces (username, password, email, name, age, phone_number, address, wage) 
VALUES ('newUsername', '123456@Abc', 'newEmail', 'newName', 30, 'newPhoneNumber', 'newAddress', 50000.00);

-- Tim theo name hoac user
SELECT * FROM ecommerces WHERE username LIKE '%searchTerm%' OR name LIKE '%searchTerm%';


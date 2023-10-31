create database accounts;

use accounts;

create table accounts(
id int auto_increment primary key,
username varchar(255) not null unique,
password varchar(255) not null,
name varchar(255) not null,
age int check (age > 18 and age < 60),
phoneNumber varchar(20) not null,
address varchar(255) not null,
salary decimal(10, 2) check (salary > 0 AND salary < 100000000)
 );
 
 -- Them tk
INSERT INTO accounts (username, password, email, name, age, phoneNumber, address, salary) 
VALUES ('newUsername', '123456@Abc', 'newEmail', 'newName', 30, 'newPhoneNumber', 'newAddress', 50000.00);

-- Tim theo name hoac user
SELECT * FROM accounts WHERE username LIKE '%searchTerm%' OR name LIKE '%searchTerm%';


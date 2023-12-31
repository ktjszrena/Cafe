Guide on how to setup SQL Database

Download MySQL Community Server
https://dev.mysql.com/downloads/mysql/

At the bin folder, open a cmd with ADMIN rights and run
mysqld --initialize --console
A temp password would be generated and copy it 

To start the server, use the following command
mysqld --console
To stop, use ctrl-c

To start a client, start another cmd and use the following command in the same bin
mysql -u root -p
Use the password generated before

Once you are in, change the password using the this sql (change xxxx to your desired password)
alter user 'root'@'localhost' identified by 'xxxx';
To check your password, use
select Host, User, authentication_string from mysql.user;

To create a new user
create user 'Admin'@'localhost' identified by 'pass';
grant all on *.* to 'Admin'@'localhost';

Creating the databases
Use the following command to create the database
create database if not exists staff;
show databases;
use staff;
show tables;
create table userprofile (role varchar(50), description varchar(100), permission varchar(200));
describe userprofile;
create table useraccount (name varchar(30), id int, password varchar(30), dob varchar(15), address varchar(100), profile varchar(50), scope varchar(50));
describe useraccount;

To insert values into the tables
insert into userprofile values ('System Admin', 'Manage all user accounts', 'sysadm');
insert into userprofile values ('Cafe Manager', 'Handles bids for slots', 'manager');
insert into userprofile values ('Cafe Owner', 'Manage work slots', 'owner');
insert into userprofile values ('Cafe Staff', 'Bids for work slots', 'staff');
insert into useraccount values ('John Doe', 1, 'johnpass', '28 Dec 1999', 'John Street', 'Cafe Staff', 'Chef');

Suspend Acc table
create table suspendacc (id int);
describe suspendacc;

Suspend Profile table
create table suspendpro (role varchar(50));
describe suspendpro;

Work Slots table
create table workslots (role varchar(50), slots int, date date);
describe workslots;

Staff Available Table
create table staffavail (role varchar(50), id int, days varchar(30));
describe staffavail;

Staff Shift Table
create table staffshift (date date, role varchar(50), id int, approve int);
describe staffshift;

Part and Full Time table
create table pftable (date date, pt int, ft int);
describe pftable;

To import the tables
mysql -u username -p new_database < data-dump.sql

/* CREATE DATABASE trainingdb;*/
/*use trainingdb;*/

/*create table Employee
 (EmpID int, EmpName varchar(20), salary float)*/
 
 /*describe Employee;*/
 
 /*insert into Employee values (101, 'King', 12456.78);
 insert into Employee values (102, 'King2', 32456.78);
 insert into Employee values (103, 'King3', 42456.78);
 insert into Employee values (104, 'King4', 52456.78);*/
 
select * from Employee;

/*select  user();
show variables where variable_name='port';*/

delete from Employee where Employee.EmpId = 107;


ALTER TABLE Employee
ADD CONSTRAINT PK_Employee PRIMARY KEY (EmpId);


SHOW INDEX FROM Employee;



CREATE DATABASE storedb;
use storedb;
 
create table Product (productID int, name varchar(20), category varchar(20), price float);
 
ALTER TABLE Product
ADD CONSTRAINT PK_Product PRIMARY KEY (productId);
 
insert into Product values (101, 'Product 1', 'Category 1' , 12456.78);
insert into Product values (102, 'Product 2', 'Category 1' , 22456.78);
insert into Product values (103, 'Product 3', 'Category 1' , 32456.78);
insert into Product values (104, 'Product 4', 'Category 2' , 42456.78);
insert into Product values (105, 'Product 5', 'Category 2' , 52456.78);
insert into Product values (105, 'Product 6', 'Category 2' , 62456.78);
 
select * from Product;
 
delete  from Product;

show databases; 

use trainingdb;

create table departments
    (deptid int primary key auto_incremdepartmentsent,
    deptname varchar(200),
    deptlocation varchar(200));
    
insert into departments(deptname, deptlocation) values('Sales', 'Mumbai');
insert into departments(deptname, deptlocation) values('Testing', 'Delhi');
insert into departments(deptname, deptlocation) values('Development', 'Mumbai');
insert into departments(deptname, deptlocation) values('Admininstration', 'Hyderabad');

select * from departments;

 
 
 
 
 
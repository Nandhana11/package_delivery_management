create database delivery_management_db;

USE delivery_management_db;
SELECT * FROM package;
create table delivery_management_db.package(
package_id int  AUTO_INCREMENT PRIMARY KEY,
description varchar(100),
weight int,
destination varchar(100),
status varchar(100),
delivery_date date);

use delivery_management_db;
show columns from package;
create table delivery_management_db.route(
route_id int,
start_location varchar(100),
end_location varchar(100),
destination varchar(100),
distance float,
estimated_time time );

use delivery_management_db;
show columns from route;
create table delivery_management_db.personnel(
personnel_id int  AUTO_INCREMENT PRIMARY KEY,
name varchar(100),
email varchar(100),
phone_number varchar(100),
vehicle_id int);
use delivery_management_db;
show columns from personnel;
create table delivery_management_db.vehicle(
vehicle_id int  AUTO_INCREMENT PRIMARY KEY,
vehicle_model varchar(100));
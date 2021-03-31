create schema /*!32312 if not exists*/`cinemamanagement`/*40100 default character set latin1 */;

use cinemamanagement;

create table employeeinfo(
	id int not null primary key auto_increment,
    fullname nvarchar(30) not null,
    dateofbirth nvarchar(10) not null,
    address nvarchar(50) not null,
    position nvarchar(30) not null
);

create table userlogin(
	id int not null primary key auto_increment,
    email varchar(50) not null,
    password varchar(30) not null
);

create table movies(
	idmovie int not null primary key auto_increment,
    title varchar(30) not null,
    genre varchar(30) not null,
    releasedate varchar(30) not null,
    runningtime int not null
);

insert into employeeinfo(`fullname`, `dateofbirth`, `address`, `position`) values
('Nguyen Tuan Tu', '03/08/1995', 'TPHCM', 'manager'),
('Tran Hoang Khanh', '26/09/1999', 'TPHCM', 'staff'),
('Nguyen Tuong Van', '19/12/2000', 'Binh Duong', 'staff'),
('Huynh Huu Nhan', '30/12/2000', 'TPHCM', 'staff');

insert into userlogin(email, password) values
('tunguyen@gmail.com','123456'),
('khanhtran@gmail.com','abcdef'),
('vannguyen@gmail.com','letmein1234'),
('nhanhuynh@gmail.com','thisismypassword!');

insert into movies(`title`, `genre`, `releasedate`, `runningtime`) values
('Godzilla vs. Kong', 'Action', 'Mar 26 2021', 113),
('The Father', 'Comedy', 'Mar 12 2021', 128),
('Ooops', 'Animation', 'Mar 26, 2021', 85);



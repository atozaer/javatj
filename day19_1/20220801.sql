select * from user_tables;

drop table product;

create table product(
pid int primary key,
pname varchar(20) not null,
price int,
cnt int default 0
);

select pid,pname,price,cnt from product

insert into product(pid,pname,price) values(1,'운동화',59000);
insert into product(pid,pname,price) values(2,'후드티',52000);
insert into product(pid,pname,price) values(3,'맨투맨',45000);
insert into product(pid,pname,price) values(4,'청바지',32000);
insert into product(pid,pname,price) values(5,'가방',70000);


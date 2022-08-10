/* Member table */
drop table member;

select * from member;

Create table member(
	id VARCHAR(8) PRIMARY KEY,
	passwd	VARCHAR(4),
	name	VARCHAR(15),
	addr	VARCHAR(200),
	tel		VARCHAR(13),
	birth	NUMBER(8),
	point	INT default 0,
	money	INT default 0
);

insert into member(id,passwd,name,addr,tel,birth) values('admin','a','무명1','더조은','01000700070','20220805');
insert into member(id,passwd,name,addr,tel,birth,point,money) values('aaa','aaa','무명2','서울특별시구로구','01082828282','19900101',100,100000);
insert into member(id,passwd,name,addr,tel,birth) values('bbb','bbb','무명3','경기도성남시','01059595959','19850505');
insert into member(id,passwd,name,addr,tel,birth) values('ccc','ccc','무명4','서울특별시중구','01012345678','20000505');


/* Product table */
drop table product;

select * from product;

Create table product(
	pnum	int primary key,
	pname	varchar(100),
	pstock	int,
	price	int,
	pinfo	varchar(200)
);

insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'우먼스 스포츠웨어 퓨추라 365 크로스 바디백(블랙)', 10, 21000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'헤리티지86 퓨추라 워시드 캡(블랙)', 10, 21000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'레볼루션6 넥스트 네이처(블랙)', 10, 48500);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'헤리티지86 퓨추라 워시드 캡', 10, 21000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'우먼스 스포츠웨어 퓨추라 365 크로스 바디백', 10, 19000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'테크 힙팩(화이트)', 10, 38250);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'테크 힙팩(블랙)', 10, 28000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'레볼루션6 넥스트 네이처 우먼스', 10, 48500);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'에어맥스 SC(화이트)', 10, 69000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'레볼루션6 넥스트 네이처', 10, 48400);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'에어맥스 SC 우먼스', 10, 69000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'탄준', 10, 71100);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'다운시프터 12', 10, 71100);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'코트 레거시 넥스트 네이처', 10, 71100);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'에어맥스 SC', 10, 80100);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'클래식 백팩', 10, 35100);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'와플 데뷰', 10, 69000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'와플 데뷰 우먼스', 10, 69000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'에어맥스 AP 우먼스', 10, 91000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'헤리티지 크로스 바디 백 스몰', 10, 20900);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'비스타 샌들 우먼스', 10, 44000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'헤리티지 크로스 바디 백 스몰(블랙)', 10, 19000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'에어맥스 SC (PSV)', 10, 54000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'플렉스 러너2 (TDV)', 10, 36900);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'플렉스 플러스 (TD)', 10, 39000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'플렉스 러너2 (PSV)', 10, 44000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'엘리멘탈 AOP 백팩', 10, 44100);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'오네온타 샌들', 10, 53000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'에어맥스 SC (TDV)', 10, 47000);
insert into product(pnum,pname,pstock,price) values((select nvl(max(pnum),0)+1 from product),'코트 레거시 (PSV)', 10, 39000);








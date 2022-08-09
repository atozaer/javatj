use tj01;

select * from board;
select * from member;
drop table member;
drop table board;
drop table product;

create table board
(
    board_no   bigint auto_increment
        primary key,
    content    varchar(255)                       null comment '상세설명',
    read_count int      default 0                 not null comment '조회수',
    reg_date   datetime default CURRENT_TIMESTAMP null comment '등록일',
    title      varchar(255)                       null comment '제목',
    writer     varchar(255)                       null comment '작성자명'
);

create table member
(
    member_no   int auto_increment
        primary key,
    member_id   varchar(50)                        null comment '회원아이디',
    password    varchar(50)                        null comment '비밀번호',
    tel         varchar(13)                        null comment '연락처',
    reg_date    datetime default CURRENT_TIMESTAMP not null,
    member_name varchar(50)                        null comment '회원명',
    member_point int default 0 							comment '적립금'
)
    comment '회원관리';

create table product
(
    product_no   int auto_increment
        primary key,
    product_name varchar(100)  null comment '상품명',
    price        int default 0 null comment '판매가',
    stock        int default 0 not null comment '재고량'
);

insert into member(member_id,password,tel,member_name) values ('jjj','111','1234-5678','조용운');
select * from member;

drop table member;
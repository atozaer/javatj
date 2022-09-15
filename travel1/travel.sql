create table member(
   mid varchar(30) primary key, -- 아이디
   mpw varchar(30) not null, -- 비밀번호
   mname varchar(30) not null, -- 이름
   mbirth varchar(30), -- 생년월일
   mphone varchar(20) not null, -- 핸드폰
   mgender varchar(10), -- 성별
   mmail varchar(30), -- 이메일
   mregdate date default sysdate, -- 가입일
   mlastaccessdate date, -- 최근접속일
   mphoto varchar(50) -- 사진,썸네일
);
insert into member values('admin','1234','관리자','2000-06-15','010-1234-5678','male','admin@naver.com',sysdate,sysdate,'');
insert into member values('yoon','1234','윤종혁','2021-12-21','010-1111-2222','male','hladagers@naver.com',sysdate,sysdate,'');
--관리자
--일반사용자
--모두 실존 핸드폰,이메일이 아님
--사진은 ''(공백)으로 처리함.NULL로 출력됨

create table newsboard(
   nnum int primary key, -- 공지번호
   ntitle varchar(100) not null, -- 제목
   ncontent varchar(2000), -- 내용
   ndate date default sysdate, -- 작성일
   nphoto varchar(50) -- 이미지파일(경로)
);
insert into newsboard(nnum,ntitle,ncontent) values(1001,'첫번째 공지','첫번째 공지사항입니다.');
insert into newsboard(nnum,ntitle,ncontent) values(1002,'두번째 공지','두번째 공지사항입니다.');
insert into newsboard(nnum,ntitle,ncontent) values(1003,'[필독] 공지사항','[훈련생 만족도조사 실시]

훈련생 여러분, 안녕하세요!
훈련이 과반 이상 진행됨에 따라 2차 만족도조사를 실시하고자 합니다!
아래 응답기간과 참여방법 안내드리니 훈련생분들은 아래 링크 참고하여 조사에 빠짐없이 응답 바랍니다!

▶참여방법
   http://itgn.kedutms.com/');
-- 공지사항은 1001부터 시작
-- 이미지파일은 NULL로 출력됨

create table reviewboard(
   rnum int primary key, -- 글 번호
   rtitle varchar(100) not null, -- 글 제목
   mid varchar(30) not null, -- 아이디
   rcontent varchar(2000), -- 글 내용
   rdate date default sysdate, -- 작성일
   rfile varchar(50), -- 첨부파일
   rview int default 0, -- 조회수
   rcnt int default 0, --댓글수
   rthumbsup float default 0.0, -- 추천수(->별점★)
   raddress varchar(100) not null --주소
);
insert into reviewboard(rnum,rtitle,mid,rcontent,raddress) values(2001,'리뷰 등록 테스트','admin','리뷰등록테스트중입니다! :D','주소값');
-- 리뷰는 2001부터 시작
-- 첨부파일은 NULL로 출력됨

create table comments(
   cnum int primary key, --댓글 번호
   rnum int not null, --게시글 번호(외래키)
   mid varchar(30) not null, --아이디(외래키)
   cdate date default sysdate, --댓글작성일
   ccontent varchar(200), --댓글 내용
   cthumbsup float default 0--좋아요 수
);
insert into comments(cnum,rnum,mid,ccontent) values(3001,2001,'admin','댓글 등록 테스트');
-- 댓글은 3001부터 시작

create table askboard(
   anum int primary key, --문의 게시판 글 번호
   mid varchar(30) not null, --아이디(외래키)
   atitle varchar(50), --글 제목
   acontent varchar(2000), --글 내용
   adate date default sysdate, --글 작성 날짜
   afile varchar(100),--첨부파일
   aview int default 0--조회수
);
insert into askboard(anum,mid,atitle,acontent) values(11,'admin','문의 게시판 테스트','문의 게시판 글 등록 테스트입니다! :D');
-- 문의 게시판은 11부터 시작
-- 첨부파일은 NULL로 출력됨

create table askcomment(
   acnum int primary key,--문의답변번호
   anum int not null,--글번호(외래키)
   mid varchar(30) not null,--아이디(외래키)
   acdate date default sysdate,--작성날짜
   accontent varchar(100)--글내용
);
insert into askcomment(acnum,anum,mid,accontent) values(101,11,'admin','문의답변 테스트입니다! :D');
-- 문의답변은 101부터 시작

create table filelist(
	fn varchar(200),
	frn varchar(200)
);

drop table member;
drop table newsboard;
drop table reviewboard;
drop table comments;
drop table askboard;
drop table askcomment;
drop table filelist;

select * from member;
select * from newsboard;
select * from reviewboard;
select * from comments;
select * from askboard;
select * from askcomment;
select * from filelist;
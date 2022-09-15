create table member(
   mid varchar(30) primary key, -- ���̵�
   mpw varchar(30) not null, -- ��й�ȣ
   mname varchar(30) not null, -- �̸�
   mbirth varchar(30), -- �������
   mphone varchar(20) not null, -- �ڵ���
   mgender varchar(10), -- ����
   mmail varchar(30), -- �̸���
   mregdate date default sysdate, -- ������
   mlastaccessdate date, -- �ֱ�������
   mphoto varchar(50) -- ����,�����
);
insert into member values('admin','1234','������','2000-06-15','010-1234-5678','male','admin@naver.com',sysdate,sysdate,'');
insert into member values('yoon','1234','������','2021-12-21','010-1111-2222','male','hladagers@naver.com',sysdate,sysdate,'');
--������
--�Ϲݻ����
--��� ���� �ڵ���,�̸����� �ƴ�
--������ ''(����)���� ó����.NULL�� ��µ�

create table newsboard(
   nnum int primary key, -- ������ȣ
   ntitle varchar(100) not null, -- ����
   ncontent varchar(2000), -- ����
   ndate date default sysdate, -- �ۼ���
   nphoto varchar(50) -- �̹�������(���)
);
insert into newsboard(nnum,ntitle,ncontent) values(1001,'ù��° ����','ù��° ���������Դϴ�.');
insert into newsboard(nnum,ntitle,ncontent) values(1002,'�ι�° ����','�ι�° ���������Դϴ�.');
insert into newsboard(nnum,ntitle,ncontent) values(1003,'[�ʵ�] ��������','[�Ʒû� ���������� �ǽ�]

�Ʒû� ������, �ȳ��ϼ���!
�Ʒ��� ���� �̻� ����ʿ� ���� 2�� ���������縦 �ǽ��ϰ��� �մϴ�!
�Ʒ� ����Ⱓ�� ������� �ȳ��帮�� �Ʒû��е��� �Ʒ� ��ũ �����Ͽ� ���翡 �������� ���� �ٶ��ϴ�!

���������
   http://itgn.kedutms.com/');
-- ���������� 1001���� ����
-- �̹��������� NULL�� ��µ�

create table reviewboard(
   rnum int primary key, -- �� ��ȣ
   rtitle varchar(100) not null, -- �� ����
   mid varchar(30) not null, -- ���̵�
   rcontent varchar(2000), -- �� ����
   rdate date default sysdate, -- �ۼ���
   rfile varchar(50), -- ÷������
   rview int default 0, -- ��ȸ��
   rcnt int default 0, --��ۼ�
   rthumbsup float default 0.0, -- ��õ��(->������)
   raddress varchar(100) not null --�ּ�
);
insert into reviewboard(rnum,rtitle,mid,rcontent,raddress) values(2001,'���� ��� �׽�Ʈ','admin','�������׽�Ʈ���Դϴ�! :D','�ּҰ�');
-- ����� 2001���� ����
-- ÷�������� NULL�� ��µ�

create table comments(
   cnum int primary key, --��� ��ȣ
   rnum int not null, --�Խñ� ��ȣ(�ܷ�Ű)
   mid varchar(30) not null, --���̵�(�ܷ�Ű)
   cdate date default sysdate, --����ۼ���
   ccontent varchar(200), --��� ����
   cthumbsup float default 0--���ƿ� ��
);
insert into comments(cnum,rnum,mid,ccontent) values(3001,2001,'admin','��� ��� �׽�Ʈ');
-- ����� 3001���� ����

create table askboard(
   anum int primary key, --���� �Խ��� �� ��ȣ
   mid varchar(30) not null, --���̵�(�ܷ�Ű)
   atitle varchar(50), --�� ����
   acontent varchar(2000), --�� ����
   adate date default sysdate, --�� �ۼ� ��¥
   afile varchar(100),--÷������
   aview int default 0--��ȸ��
);
insert into askboard(anum,mid,atitle,acontent) values(11,'admin','���� �Խ��� �׽�Ʈ','���� �Խ��� �� ��� �׽�Ʈ�Դϴ�! :D');
-- ���� �Խ����� 11���� ����
-- ÷�������� NULL�� ��µ�

create table askcomment(
   acnum int primary key,--���Ǵ亯��ȣ
   anum int not null,--�۹�ȣ(�ܷ�Ű)
   mid varchar(30) not null,--���̵�(�ܷ�Ű)
   acdate date default sysdate,--�ۼ���¥
   accontent varchar(100)--�۳���
);
insert into askcomment(acnum,anum,mid,accontent) values(101,11,'admin','���Ǵ亯 �׽�Ʈ�Դϴ�! :D');
-- ���Ǵ亯�� 101���� ����

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
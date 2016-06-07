贴吧
-----
*jre: 1.7.0_65
*IDE: eclipse
*Server: tomcat8.0
*DB: Oracle
*Index url: http://localhost:8080/tieba
```sql
create sequence bysj_account_seq start with 1000;
create sequence bysj_tieba_seq start with 1000;
create table bysj_account(
	id number(10) primary key,
	loginname varchar2(30) unique not null,
	password varchar2(30) not null,
	username varchar2(30) not null,
	email varchar2(50),
	gender char(1) check (gender in(0,1))
);
create table bysj_tieba(
	id number(10) primary key,
	name varchar2(30) unique not null,
	creatorid number(10) not null,
	classify varchar2(30) not null,
	descr varchar2(300),
	createtime timestamp not null
);
create table bysj_attentionFriends(
	selfID number(10) not null,
	friendsID number(10) not null
);
create table bysj_attentiontiebas(
	selfID number(10) not null,
	tiebaID number(10) not null
);
commit;

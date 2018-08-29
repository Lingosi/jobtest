
create table t_taskitem
(
       id number(22) primary key not null,
       name varchar2(64),
	     commandid number(22) not null,
	     description varchar2(64),
       fieldvalue varchar2(128),
       createdon date default sysdate not null,
       createdby varchar2(32),
       lastmodifiedon date default sysdate not null,
       lastmodifiedby varchar2(32)
)

insert into t_taskitem(id,name,commandid,description,fieldvalue,createdby,lastmodifiedby)
values(1,'测试任务',1,'第一个测试','paytype:1#paydate:2018-04-20#','server','server');

create table t_taskcommand
(
       id number(22) primary key not null,
       name varchar2(64),
	     jobclass varchar2(128),
       createdon date default sysdate not null,
       createdby varchar2(32),
       lastmodifiedon date default sysdate not null,
       lastmodifiedby varchar2(32)
)

insert into t_taskcommand(id,name,jobclass,createdby,lastmodifiedby) values(1,'测试任务命令','com.zyh.springcloud.jobtest.config.TestJob','server','server');

select t.*,t.rowid from t_taskcommand t where id = 1;

--drop table t_taskparamdef;
create table t_taskparamdef
(
       id number(22) primary key not null,
       commandid number(22) not null,
       displayname varchar2(64),
       fieldtype char(1) not null,
       fieldname varchar2(64),
	     allownull char(1) default '0' not null,
       orderno number(2),
       createdon date default sysdate not null,
       createdby varchar2(32),
       lastmodifiedon date default sysdate not null,
       lastmodifiedby varchar2(32)
)

insert into t_taskparamdef(id,commandid,displayname,fieldtype,fieldname,allownull,orderno,createdby,lastmodifiedby)
values(1,1,'交易类型','1','paytype','0',1,'server','server');
insert into t_taskparamdef(id,commandid,displayname,fieldtype,fieldname,allownull,orderno,createdby,lastmodifiedby)
values(2,1,'付款日期','2','paydate','0',2,'server','server');

create table t_scheduler
(
       id number(22) primary key not null,
       itemid number(22) not null,
       name varchar2(64),
       corn varchar2(128),
       createdon date default sysdate not null,
       createdby varchar2(32),
       lastmodifiedon date default sysdate not null,
       lastmodifiedby varchar2(32)
)

insert into t_scheduler(id,itemid,name,corn,createdby,lastmodifiedby) values(1,1,'测试计划','0 0/1 * * * ?','server','server');


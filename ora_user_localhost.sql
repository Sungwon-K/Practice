create table userTable(
    id varchar2(20) primary key,
    pw varchar2(20) not null,
    name varchar2(50) not null,
    email varchar2(50) not null,
    address varchar2(100),
    phone varchar(20)
);
insert into userTable(id,pw,name,email,address,phone)
values('cbt','1234','��','www@www','����','010-2222-87777');

insert into userTable(id,pw,name,email,address,phone)
values('cbt1','1234','�հ�','www@www',null,null);

insert into userTable(id,pw,name,email)
values('cbt2','1234','�������','www@www');

select * from userTable;

insert into userTable values('hkd','1234','ȫ�浿','hkd@hkd.com','����','010-1111-2222');

insert into userTable values('efd','5678','ȫ�海','hkd@hkd.com','���','010-1111-3333');


create table goodsTable(
    gCode char(8) not null,
    gName varchar(50) not null,
    price number not null,
    constraint pk_goodsTable primary key(gCode)
);

insert into goodsTable values('20200403','������',2000);
insert into goodsTable values('20200404','�����',2000);


create table orderTable(
    oNo char(12) primary key,
    id varchar2(20) not null,
    gCode char(8) not null,
    oDate date not null,
    constraint fk_orderTable foreign key(id)
    references userTable(id) on delete cascade
);



insert into orderTable values('202004030001','www','20200403',sysdate);

select * from orderTable;
select * from userTable;



create table ex2_9(
    num1 number constraint check1 check(num1 between 1 and 9),
    
    gender varchar2(10) constraint check2 check(gender in('MALE','FEMAL'))
);

alter table ex2_9 rename column num1 to num;

desc ex2_9;

insert into ex2_9 values(10,'MALE');
insert into ex2_9 values(5,'MALE');

create table ex2_9_copy as select * from ex2_9;

select * from ex2_9_copy;


select * from userTable;
select * from orderTable;


delete from userTable where id='hkd';


create table boardTable(
    no number primary key,
    title varchar2(1000) not null
);



create SEQUENCE seq_boardTable;

insert into boardTable values(seq_boardTable.nextval,'sql�̶�?');

select * from boardTable;


select *
from employees
where salary>20000;

select emp_name,salary
from employees
order by salary desc;

select emp_name, department_id,salary
from employees
order by department_id asc, salary desc;

create table employeesCopy
as
select * from employees;

select * from employeesCopy;

create table employeesCopy2
as
select * from employees where salary>10000;

select * from employeescopy2;

insert into employeescopy2
select * from employees where salary>=7000 and salary<=10000;

--data���� ������ ����
create table employeesCopy3
as
select * from employees where 1!=1;

select * from employeesCopy3;

commit;

update userTable set
name = '�հ�' , address = '����'
where id = 'wg';

delete from userTable
where id='wg';

select * from userTable;


select * from employees
where department_id!=50;

select emp_name || ', E-mail :' || email as name -- alias
from employees;


select employee_id, salary,
    case when salary <= 5000 then 'c���'
        when salary >5000 and salary <= 15000 then 'B���'
        else 'A���'
    end as salary_grade
from employees;


select prod_id, channel_id,decode(channel_id, 3, 'Direct',
                                              9, 'Direct',
                                              5, 'InDeirect',
                                              4, 'InDeirect',
                                              'others'
) as decodes
from sales
where rownum<10;

select prod_id, channel_id,
    case channel_id when 3 then 'Direct'
                   when 9 then 'Direct'
                   when 5 then 'InDirect'
                   when 4 then 'InDirect'
                   else 'others'
    end as decodes
from sales

where rownum<10;

CREATE TABLE student(
    id varchar(10) primary key,
    name varchar(20) not null,
    department varchar(30),
    address varchar(50)
);

insert  into student values('20160001','ȫ�浿','��ǻ�Ͱ��а�','����� ��������');
insert  into student values('20162233','�̼���','��Ƽ�̵���а�','�λ�� ����');
insert  into student values('20161177','�հ�','��Ƽ�̵���а�','������ ��ô��');

select id,name,department from student;

select * from student where department = '��ǻ�Ͱ��а�';

select * from student where address = '����� ��������';

select * from student order by id;

select * from student order by name asc;

select * from student order by department,id;

CREATE TABLE student_MultiMedia
as
select * from student where department = '��Ƽ�̵���а�';
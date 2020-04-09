select * from employees where department_id=100;

create index indx_employees_department_id on employees(department_id);


--composit index
create index idx_employees2 on employees(department_id, emp_name);

drop index indx_employees_department_id;

--------------------------------------------
create table t_order(
    no number,
    ord_code varchar2(10),
    ord_date date
);

create or replace trigger tr_order
before
    insert on t_order -- t-order���� insert�� �߻��ϱ� ���� �����
begin
    -- Ư���ð� 18:40 ~ 18:50���� insert�� �ǵ���.
    if(to_char(sysdate, 'HH24:MI') not between '18:40' and '18:50') then
        raise_application_error(-20100,'���ð��� �ƴմϴ�');
    end if;
end;

commit;

insert into t_order values(1,'001',sysdate);

select * from t_order;

drop trigger tr_order;

set serveroutput on;

create or replace trigger tr2
after delete on t_order
begin
    dbms_output.put_line('Ʈ���� tr2�� �����մϴ�');
    -- raise_application_error(-20555,'�����߻�');
end;

delete from t_order where no = '002';



-- :now, :old ����ϱ�
create or replace trigger tr3
after insert or delete or update on t_order
for each row -- : new, :old ����ϱ� ���ؼ� �ʿ�(������� �۾� - ����� Ʈ����)
begin
    dbms_output.put_line(:new.no ||','|| :new.ord_code ||',' || :new.ord_date);
    dbms_output.put_line(:old.no ||','|| :old.ord_code ||',' || :old.ord_date);
end;

create or replace trigger tr3
after insert or delete or update on t_order
for each row--��,�õ� ����ϱ����ؼ� �ʿ�
begin
    dbms_output.put_line(:new.no ||','|| :new.ord_code ||','|| :new.ord_date);
    end;



insert into t_order values(8,'008',sysdate);
delete from t_order where no = 8;
update t_order set ord_code='009' where no =7;

select * from t_order;


declare
    vi_num number:=0;
begin

    vi_num := 10/0;
    dbms_output.put_line('success!');
    
exception when others then
    dbms_output.put_line('������ �߻��߽��ϴ�'); --���� ���⿡ roll back�� ����
end;

declare
    vs_emp_name employees.emp_name%type;
    
    cursor cur_emp_dep( cp_department_id employees.department_id%type)
    is
    select emp_name
    from employees
    where department_id = cp_department_id;
    
begin
    open cur_emp_dep (90);
    
    loop
    
        fetch cur_emp_dep into vs_emp_name;
        
        exit when cur_emp_dep%notfound;
        
        dbms_output.put_line(vs_emp_name);
        
    end loop;
    
    close cur_emp_dep;
end;

create or replace trigger product_in_tr
after insert on product_in
for each row -- : new, :old ����ϱ� ���ؼ� �ʿ�(������� �۾� - ����� Ʈ����)
begin
    update product_stock 
    set product_stock.pro_stock = (product_stock.pro_stock + :new.in_amount)
    where product_stock.pno = :new.pno;
end;


create or replace trigger product_out_tr
after insert on product_out
for each row -- : new, :old ����ϱ� ���ؼ� �ʿ�(������� �۾� - ����� Ʈ����)
begin
    update product_stock 
    set product_stock.pro_stock = (product_stock.pro_stock - :new.out_amount)
    where product_stock.pno = :new.pno;
end;


/**
 * Table Name  : SYS_AUTH_GROUP
 * Description : Menu Authority Info
 */
drop table sys_auth_group cascade constraints;
drop sequence sys_auth_group_s;
purge recyclebin;

create table sys_auth_group (
    group_id                        varchar2(30)                                        not null,   -- Authority group UID (PK)
    group_name                      varchar2(50)                                        not null,   -- Authority group name
    description                     varchar2(1000),                                                 -- Description
    is_active                       varchar2(1),                                                    -- Is active ?
    insert_user_id                  varchar2(30),                                                   -- Insert User UID
    insert_date                     date                        default sysdate,                    -- Insert Date
    update_user_id                  varchar2(30),                                                   -- Update User UID
    update_date                     date,                                                           -- Update Date

    constraint pk_sys_auth_group primary key(group_id),
    constraint uk_sys_auth_group unique(group_name)
    using index tablespace alpaca_idx storage(initial 50k next 50k pctincrease 0)
)
pctfree 20 pctused 80 tablespace alpaca_data storage(initial 100k next 100k maxextents 2000 pctincrease 0);

create sequence sys_auth_group_s minvalue 1 maxvalue 999999999999999999999999999 increment by 1 start with 10 nocache noorder nocycle;

comment on table  sys_auth_group                 is 'Menu Authority Info';
comment on column sys_auth_group.group_id        is 'Authority group UID (PK)';
comment on column sys_auth_group.group_name      is 'Authority group name';
comment on column sys_auth_group.description     is 'Description';
comment on column sys_auth_group.is_active       is 'Is active?';
comment on column sys_auth_group.insert_user_id  is 'Insert User UID';
comment on column sys_auth_group.insert_date     is 'Insert Date';
comment on column sys_auth_group.update_user_id  is 'Update User UID';
comment on column sys_auth_group.update_date     is 'Update Date';


/**
 * Table Name  : SYS_AUTH_GROUP
 * Data        : Menu Authority Info
 */
delete sys_auth_group;

insert into sys_auth_group values('0', 'System Admin',         'System Administrator',          'Y',    '0',    sysdate,    null,     null);
insert into sys_auth_group values('1', 'General Admin',        'General Administrator',         'Y',    '0',    sysdate,    null,     null);
insert into sys_auth_group values('2', 'Department Manager',   'Department Manager',            'Y',    '0',    sysdate,    null,     null);
insert into sys_auth_group values('3', 'General User',         'General User',                  'Y',    '0',    sysdate,    null,     null);
insert into sys_auth_group values('Z', 'Not Selected',         'Not Selected',                  'Y',    '0',    sysdate,    null,     null);

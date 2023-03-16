/**
 * Table Name  : SYS_EMAIL_FILE
 * Description : Email attachment
 */
drop table sys_email_file cascade constraints;
purge recyclebin;

create table sys_email_file (
    email_file_id                   varchar2(30)                                 not null,      -- PK
    email_sender_id                 varchar2(30)                                 not null,      -- FK - Email sender id
    file_path                       varchar2(300),                                              -- File path
    file_name                       varchar2(300),                                              -- File name
    insert_user_id                  varchar2(30),                                               -- Insert User UID
    insert_date                     date                default sysdate,                        -- Insert Date
    update_user_id                  varchar2(30),                                               -- Update User UID
    update_date                     date,                                                       -- Update Date

    constraint fk_362481771395200 foreign key(email_sender_id) references sys_email_sender(email_sender_id),
    constraint pk_sys_email_file primary key(email_file_id)
    using index tablespace alpaca_idx storage(initial 50k next 50k pctincrease 0)
)
pctfree 20 pctused 80 tablespace alpaca_data storage(initial 100k next 100k maxextents 2000 pctincrease 0);

comment on table  sys_email_file                                                 is 'Email attachment';
comment on column sys_email_file.email_file_id                                   is 'PK';
comment on column sys_email_file.email_sender_id                                 is 'FK - Email sender id';
comment on column sys_email_file.file_path                                       is 'File path';
comment on column sys_email_file.file_name                                       is 'File name';
comment on column sys_email_file.insert_user_id                                  is 'Insert User UID';
comment on column sys_email_file.insert_date                                     is 'Insert Date';
comment on column sys_email_file.update_user_id                                  is 'Update User UID';
comment on column sys_email_file.update_date                                     is 'Update Date';


/**
 * Table Name  : SYS_EMAIL_FILE
 * Data        : 
 */

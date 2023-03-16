/**
 * Table Name  : SYS_EMAIL_SENDER
 * Description : Email sender
 */
drop table sys_email_sender cascade constraints;
purge recyclebin;

create table sys_email_sender (
    email_sender_id                 varchar2(30)                                         not null,      -- PK
    action_name                     varchar2(500)                                        not null,      -- Email action name
    action_src                      varchar2(100)                                        not null,      -- Source actioned from
    action_date                     date                                                 not null,      -- Date actioned
    subject                         varchar2(1000)                                       not null,      -- Email subject
    contents                        clob                        default empty_clob(),                   -- Email contents
    from_email                      varchar2(100)                                        not null,      -- Sender email
    from_name                       varchar2(100),                                                      -- Sender name
    to_email                        varchar2(100)                                        not null,      -- Recipient email
    to_name                         varchar2(100),                                                      -- Recipient name
    cc_email                        varchar2(100),                                                      -- CC email
    bcc_email                       varchar2(100),                                                      -- BCC email
    template_path                   varchar2(300),                                                      -- Template path
    template_name                   varchar2(300),                                                      -- Template name
    status                          varchar2(30)                                         not null,      -- Status (sys_common_code.email_sender_status)
    insert_user_id                  varchar2(30),                                                       -- Insert User UID
    insert_date                     date                        default sysdate,                        -- Insert Date
    update_user_id                  varchar2(30),                                                       -- Update User UID
    update_date                     date,                                                               -- Update Date

    constraint pk_sys_email_sender primary key(email_sender_id)
    using index tablespace alpaca_idx storage(initial 50k next 50k pctincrease 0)
)
pctfree 20 pctused 80 tablespace alpaca_data storage(initial 100k next 100k maxextents 2000 pctincrease 0);

comment on table  sys_email_sender                                               is 'Email sender';
comment on column sys_email_sender.email_sender_id                               is 'PK';
comment on column sys_email_sender.action_name                                   is 'Email action name';
comment on column sys_email_sender.action_src                                    is 'Source actioned from';
comment on column sys_email_sender.action_date                                   is 'Date actioned';
comment on column sys_email_sender.subject                                       is 'Email subject';
comment on column sys_email_sender.contents                                      is 'Email contents';
comment on column sys_email_sender.from_email                                    is 'Sender email';
comment on column sys_email_sender.from_name                                     is 'Sender name';
comment on column sys_email_sender.to_email                                      is 'Recipient email';
comment on column sys_email_sender.to_name                                       is 'Recipient name';
comment on column sys_email_sender.cc_email                                      is 'CC email';
comment on column sys_email_sender.bcc_email                                     is 'BCC email';
comment on column sys_email_sender.template_path                                 is 'Template path';
comment on column sys_email_sender.template_name                                 is 'Template name';
comment on column sys_email_sender.status                                        is 'Status (sys_common_code.email_sender_status)';
comment on column sys_email_sender.insert_user_id                                is 'Insert User UID';
comment on column sys_email_sender.insert_date                                   is 'Insert Date';
comment on column sys_email_sender.update_user_id                                is 'Update User UID';
comment on column sys_email_sender.update_date                                   is 'Update Date';


/**
 * Table Name  : SYS_EMAIL_SENDER
 * Data        : 
 */

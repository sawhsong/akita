/**
 * Table Name  : SYS_FAVORITE_MENU
 * Description : Favorite menu by user
 */
drop table sys_favorite_menu cascade constraints;
purge recyclebin;

create table sys_favorite_menu (
    user_id                         varchar2(30)                                 not null,      -- User UID (PK()
    menu_id                         varchar2(30)                                 not null,      -- Menu UID (PK)
    insert_user_id                  varchar2(30),                                               -- Insert User UID
    insert_date                     date                default sysdate,                        -- Insert Date
    update_user_id                  varchar2(30),                                               -- Update User UID
    update_date                     date,                                                       -- Update Date

    constraint pk_sys_favorite_menu primary key(user_id, menu_id)
    using index tablespace alpaca_idx storage(initial 50k next 50k pctincrease 0)
)
pctfree 20 pctused 80 tablespace alpaca_data storage(initial 100k next 100k maxextents 2000 pctincrease 0);

comment on table  sys_favorite_menu                                              is 'Favorite menu by user';
comment on column sys_favorite_menu.user_id                                      is 'User UID (PK()';
comment on column sys_favorite_menu.menu_id                                      is 'Menu UID (PK)';
comment on column sys_favorite_menu.insert_user_id                               is 'Insert User UID';
comment on column sys_favorite_menu.insert_date                                  is 'Insert Date';
comment on column sys_favorite_menu.update_user_id                               is 'Update User UID';
comment on column sys_favorite_menu.update_date                                  is 'Update Date';


/**
 * Table Name  : SYS_FAVORITE_MENU
 * Data        : 
 */

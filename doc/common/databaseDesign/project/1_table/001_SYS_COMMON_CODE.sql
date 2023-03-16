/**
 * Table Name  : SYS_COMMON_CODE
 * Description : Common Lookup Code
 */
drop table sys_common_code cascade constraints;
purge recyclebin;

create table sys_common_code (
    code_type                       varchar2(50)                                        not null,   -- Code type (PK) - PERCI codes have 50(need to be amended to 30 later), ideal length is 30
    common_code                     varchar2(60)                                        not null,   -- Common code (PK) - PERCI codes have 60(need to be amended to 30 later), ideal length is 30
    code_meaning                    varchar2(1000)                                      not null,   -- Code Meaning
    description_ko                  varchar2(2000),                                                 -- Code Description (Korean) - PERCI codes have 2000(need to be amended to 1000 later), ideal length is 1000
    description_en                  varchar2(2000),                                                 -- Code Description (English) - PERCI codes have 2000(need to be amended to 1000 later), ideal length is 1000
    program_constants               varchar2(100)                                       not null,   -- Constants value for the common code to be used in program source code
    sort_order                      varchar2(3),                                                    -- Sort Order
    is_active                       varchar2(1)                 default 'Y',                        -- Is active?
    is_default                      varchar2(1)                 default 'N',                        -- Is default code item? (default code item should not be deleted)
    insert_user_id                  varchar2(50),                                                   -- Insert User UID
    insert_date                     date                        default sysdate,                    -- Insert Date
    update_user_id                  varchar2(50),                                                   -- Update User UID
    update_date                     date,                                                           -- Update Date

    constraint pk_sys_common_code primary key(code_type, common_code),
    constraint uk_sys_common_code unique(program_constants)
    using index tablespace alpaca_idx storage(initial 50k next 50k pctincrease 0)
)
pctfree 20 pctused 80 tablespace alpaca_data storage(initial 100k next 100k maxextents 2000 pctincrease 0);

comment on table  sys_common_code                   is 'Common Lookup Code';

comment on column sys_common_code.code_type         is 'Code type (PK) - PERCI codes have 50(need to be amended to 30 later), ideal length is 30';
comment on column sys_common_code.common_code       is 'Common code (PK) - PERCI codes have 60(need to be amended to 30 later), ideal length is 30';
comment on column sys_common_code.code_meaning      is 'Code Meaning';
comment on column sys_common_code.description_ko    is 'Code Description (Korean) - PERCI codes have 2000(need to be amended to 1000 later), ideal length is 1000';
comment on column sys_common_code.description_en    is 'Code Description (English) - PERCI codes have 2000(need to be amended to 1000 later), ideal length is 1000';
comment on column sys_common_code.program_constants is 'Constants value for the common code to be used in program source code';
comment on column sys_common_code.sort_order        is 'Sort order';
comment on column sys_common_code.is_active         is 'Is active?';
comment on column sys_common_code.is_default        is 'Is default code item? (default code item should not be deleted)';
comment on column sys_common_code.insert_user_id    is 'Insert User UID';
comment on column sys_common_code.insert_date       is 'Insert Date';
comment on column sys_common_code.update_user_id    is 'Update User UID';
comment on column sys_common_code.update_date       is 'Update Date';


/**
 * Table Name  : SYS_COMMON_CODE
 * Data        : 
 */
delete sys_common_code;

insert into sys_common_code values('SIMPLE_YN', '0000000000', 'Simple YN', 'Simple YN', 'Simple YN', 'SIMPLE_YN_0000000000', '000', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('SIMPLE_YN', 'Y',          'Yes',       'Yes',       'Yes',       'SIMPLE_YN_Y',          '001', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('SIMPLE_YN', 'N',          'No',        'No',        'No',        'SIMPLE_YN_N',          '002', 'Y', 'Y', '0', sysdate, null, null);

insert into sys_common_code values('USE_YN', '0000000000', 'Is Used',    'Is Used',    'Use or Not', 'USE_YN_0000000000', '000',   'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USE_YN', 'Y',          'Use',        'Use',        'Use',        'USE_YN_Y',          '001',   'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USE_YN', 'N',          'Not in Use', 'Not in Use', 'Not Use',    'USE_YN_N',          '002',   'Y', 'Y', '0', sysdate, null, null);

insert into sys_common_code values('IS_ACTIVE', '0000000000', 'Is Active',    'Is Active', 'Is Active', 'IS_ACTIVE_0000000000', '000',   'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('IS_ACTIVE', 'Y',          'Active',       'Active',    'Active',    'IS_ACTIVE_Y',          '001',   'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('IS_ACTIVE', 'N',          'Inactive',     'Inactive',  'Inactive',  'IS_ACTIVE_N',          '002',   'Y', 'Y', '0', sysdate, null, null);

insert into sys_common_code values('LANGUAGE_TYPE', '0000000000', 'Language Type', 'Language Type', 'Language Type', 'LANGUAGE_TYPE_0000000000', '000', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('LANGUAGE_TYPE', 'EN',         'English',       'English',       'English',       'LANGUAGE_TYPE_EN',         '001', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('LANGUAGE_TYPE', 'KO',         'Korean',        'Korean',        'Korean',        'LANGUAGE_TYPE_KO',         '002', 'Y', 'Y', '0', sysdate, null, null);

insert into sys_common_code values('BOARD_TYPE', '0000000000', 'Board Type',      'Board Type',     'Board Type',       'BOARD_TYPE_0000000000', '000', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('BOARD_TYPE', 'FREE',       'Free Board',      'Free Board',     'Free Board',       'BOARD_TYPE_FREE',       '001', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('BOARD_TYPE', 'NOTICE',     'Notice Board',    'Notice Board',   'Notice Board',     'BOARD_TYPE_NOTICE',     '002', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('BOARD_TYPE', 'REPOSITORY', 'Data Repository', 'Data Repository', 'Data Repository', 'BOARD_TYPE_REPOSITORY', '003', 'Y', 'Y', '0', sysdate, null, null);

insert into sys_common_code values('BOARD_SEARCH_TYPE', '0000000000', 'Board Search Criteria', '게시판검색형태', 'Board Search Criteria', 'BOARD_SEARCH_TYPE_0000000000', '000', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('BOARD_SEARCH_TYPE', 'SUBJECT',    'Subject',               '제목',            'Subject',               'BOARD_SEARCH_TYPE_SUBJECT',    '001', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('BOARD_SEARCH_TYPE', 'CONTENTS',   'Contents',              '내용',            'Contents',              'BOARD_SEARCH_TYPE_CONTENTS',   '002', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('BOARD_SEARCH_TYPE', 'WRITER',     'Writer',                '작성자',          'Writer',                'BOARD_SEARCH_TYPE_WRITER',     '003', 'Y', 'Y', '0', sysdate, null, null);

insert into sys_common_code values('USER_THEME_TYPE', '0000000000', 'User Theme Type', '사용자스킨구분',      'User Theme Type', 'USER_THEME_TYPE_0000000000', '000', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_THEME_TYPE', 'THEME000',   'Bootstrap',       'Bootstrap',       'Bootstrap',       'USER_THEME_TYPE_000',        '001', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_THEME_TYPE', 'THEME001',   'Smoothness',      'Smoothness',      'Smoothness',      'USER_THEME_TYPE_001',        '002', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_THEME_TYPE', 'THEME002',   'Redmond',         'Redmond',         'Redmond',         'USER_THEME_TYPE_002',        '003', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_THEME_TYPE', 'THEME003',   'Lightness',       'Lightness',       'Lightness',       'USER_THEME_TYPE_003',        '004', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_THEME_TYPE', 'THEME004',   'Start',           'Start',           'Start',           'USER_THEME_TYPE_004',        '005', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_THEME_TYPE', 'THEME005',   'Sunny',           'Sunny',           'Sunny',           'USER_THEME_TYPE_005',        '006', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_THEME_TYPE', 'THEME006',   'Pepper Grinder',  'Pepper Grinder',  'Pepper Grinder',  'USER_THEME_TYPE_007',        '007', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_THEME_TYPE', 'THEME007',   'Cupertino',       'Cupertino',       'Cupertino',       'USER_THEME_TYPE_008',        '008', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_THEME_TYPE', 'THEME008',   'Cupertino',       'South Street',    'South Street',    'USER_THEME_TYPE_009',        '009', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_THEME_TYPE', 'THEME009',   'Humanity',        'Humanity',        'Humanity',        'USER_THEME_TYPE_010',        '010', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_THEME_TYPE', 'THEME999',   'Random',          'Random',          'Random',          'USER_THEME_TYPE_999',        '999', 'Y', 'Y', '0', sysdate, null, null);

insert into sys_common_code values('USER_TYPE', '0000000000', 'User Type',     'User Type',     'User Type',     'USER_TYPE_0000000000', '000', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_TYPE', 'INTERNAL',   'Internal User', 'Internal User', 'Internal User', 'USER_TYPE_INTERNAL',   '001', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_TYPE', 'EXTERNAL',   'External User', 'External User', 'External User', 'USER_TYPE_EXTERNAL',   '002', 'Y', 'Y', '0', sysdate, null, null);

insert into sys_common_code values('USER_STATUS','0000000000', 'User type', 'User type', 'User type', 'USER_STATUS_0000000000', '000', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_STATUS','RR',         'Requested', 'Requested', 'Requested', 'USER_STATUS_RR',         '001', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_STATUS','NU',         'Normal',    'Normal',    'Normal',    'USER_STATUS_NU',         '002', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_STATUS','BU',         'Banned',    'Banned',    'Banned',    'USER_STATUS_BU',         '003', 'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('USER_STATUS','WU',         'Withdrawn', 'Withdrawn', 'Withdrawn', 'USER_STATUS_WU',         '004', 'Y', 'Y', '0', sysdate, null, null);

insert into sys_common_code values('MENU_LEVEL','0000000000', 'Menu Level', 'Menu Level', 'Menu Level', 'MENU_LEVEL_0000000000',  '000',   'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('MENU_LEVEL','1',          'Level 1',    'Level 1',    'Level 1',    'MENU_LEVEL_1',           '001',   'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('MENU_LEVEL','2',          'Level 2',    'Level 2',    'Level 2',    'MENU_LEVEL_2',           '002',   'Y', 'Y', '0', sysdate, null, null);
insert into sys_common_code values('MENU_LEVEL','3',          'Level 3',    'Level 3',    'Level 3',    'MENU_LEVEL_3',           '003',   'Y', 'Y', '0', sysdate, null, null);

-- Individual code from PERCI
delete sys_common_code
 where code_type = 'PERSON_TYPES'
;
insert into sys_common_code
select lookup_type as code_type,
       '0000000000' as common_code,
       initcap(replace(lookup_type, '_', ' ')) as code_meaning,
       initcap(replace(lookup_type, '_', ' ')) as description_ko,
       initcap(replace(lookup_type, '_', ' ')) as description_en,
       lookup_type||'_'||'0000000000' as program_constants,
       '000' as sort_order,
       'Y' as is_active,
       'N' as is_default,
       '0' as insert_user_id,
       sysdate as insert_date,
       null as update_user_id,
       null as update_date
  from sys_common_lookups@perci_live
 where enabled_flag = 'Y'
   and lookup_type in ('PERSON_TYPES')
union
select lookup_type as code_type,
       lookup_code as common_code,
       meaning as description_ko,
       description as description_ko,
       description as description_en,
       lookup_type||'_'||lookup_code as program_constants,
       lpad(to_char(display_order), 3, '0') as sort_order,
       'Y' as is_active,
       'N' as is_default,
       '0' as insert_user_id,
       sysdate as insert_date,
       null as update_user_id,
       null as update_date
  from sys_common_lookups@perci_live
 where enabled_flag = 'Y'
   and lookup_type in ('PERSON_TYPES')
 order by code_type,
       sort_order,
       common_code
;


-- Hours, Minutes Code
insert into sys_common_code
select 'HOUR_CODE' as code_type,
       '0000000000' as common_code,
       'Hour Code' as code_meaning,
       'Hour Code' as description_ko,
       'Hour Code' as description_en,
       'HOUR_CODE'||'_'||'0000000000' as program_constants,
       '000' as sort_order,
       'Y' as is_active,
       'N' as is_default,
       '0' as insert_user_id,
       sysdate as insert_date,
       null as update_user_id,
       null as update_date
  from dual
union
select 'HOUR_CODE' as code_type,
       sys_hour as common_code,
       sys_hour as code_meaning,
       sys_hour as description_ko,
       sys_hour as description_en,
       'HOUR_CODE'||'_'||sys_hour as program_constants,
       lpad(rownum, 3, '0') as sort_order,
       'Y' as is_active,
       'N' as is_default,
       '0' as insert_user_id,
       sysdate as insert_date,
       null as update_user_id,
       null as update_date
  from (select to_char(trunc(sysdate) + (level-1)/24, 'HH24') as sys_hour
          from dual
        connect by level <= 24
       )
order by sort_order
;

insert into sys_common_code
select 'MINUTE_CODE' as code_type,
       '0000000000' as common_code,
       'Minute Code' as code_meaning,
       'Minute Code' as description_ko,
       'Minute Code' as description_en,
       'MINUTE_CODE'||'_'||'0000000000' as program_constants,
       '000' as sort_order,
       'Y' as is_active,
       'N' as is_default,
       '0' as insert_user_id,
       sysdate as insert_date,
       null as update_user_id,
       null as update_date
  from dual
union
select 'MINUTE_CODE' as code_type,
       sys_min as common_code,
       sys_min as code_meaning,
       sys_min as description_ko,
       sys_min as description_en,
       'MINUTE_CODE'||'_'||sys_min as program_constants,
       lpad(rownum, 3, '0') as sort_order,
       'Y' as is_active,
       'N' as is_default,
       '0' as insert_user_id,
       sysdate as insert_date,
       null as update_user_id,
       null as update_date
  from (select lpad(level-1, 2, '0') as sys_min
          from dual
        connect by level <= 60
       )
 where sys_min like '%0' or sys_min like '%5'
 order by sort_order
;

-- From PERCI
/*
 * Check dup
select lookup_type, lookup_code, count(*)
  from sys_common_lookups
 group by lookup_type, lookup_code
having count(*) > 1
;
 */
insert into sys_common_code
select lookup_type as code_type,
       '0000000000' as common_code,
       initcap(replace(lookup_type, '_', ' ')) as code_meaning,
       initcap(replace(lookup_type, '_', ' ')) as description_ko,
       initcap(replace(lookup_type, '_', ' ')) as description_en,
       lookup_type||'_'||'0000000000' as program_constants,
       '000' as sort_order,
       'Y' as is_active,
       'N' as is_default,
       '0' as insert_user_id,
       sysdate as insert_date,
       null as update_user_id,
       null as update_date
  from sys_common_lookups@perci_live
 where enabled_flag = 'Y'
   and lookup_type not in ('ORG_RELATIONSHIP', 'EXTENSION_CHANGES', 'CUSTOMER_EMAIL_LIST') -- Duplicated codes
union
select lookup_type as code_type,
       lookup_code as common_code,
       meaning as code_meaning,
       meaning as description_ko,
       meaning as description_en,
       lookup_type||'_'||lookup_code as program_constants,
       lpad(to_char(display_order), 3, '0') as sort_order,
       'Y' as is_active,
       'N' as is_default,
       '0' as insert_user_id,
       sysdate as insert_date,
       null as update_user_id,
       null as update_date
  from sys_common_lookups@perci_live
 where enabled_flag = 'Y'
   and lookup_type not in ('ORG_RELATIONSHIP', 'EXTENSION_CHANGES', 'CUSTOMER_EMAIL_LIST') -- Duplicated codes
 order by code_type,
       sort_order,
       common_code
;

/*
 * Dup
 */
insert into sys_common_code
select lookup_type as code_type,
       '0000000000' as common_code,
       initcap(replace(lookup_type, '_', ' ')) as code_meaning,
       initcap(replace(lookup_type, '_', ' ')) as description_ko,
       initcap(replace(lookup_type, '_', ' ')) as description_en,
       lookup_type||'_'||'0000000000' as program_constants,
       '000' as sort_order,
       'Y' as is_active,
       'N' as is_default,
       '0' as insert_user_id,
       sysdate as insert_date,
       null as update_user_id,
       null as update_date
  from sys_common_lookups@perci_live
 where enabled_flag = 'Y'
   and lookup_type in ('CUSTOMER_EMAIL_LIST') -- Duplicated codes
   and meaning not in ('pdaniel@entitysolutionsgroup.com')
union
select lookup_type as code_type,
       lookup_code as common_code,
       meaning as description_ko,
       meaning as description_ko,
       meaning as description_en,
       lookup_type||'_'||lookup_code as program_constants,
       lpad(to_char(display_order), 3, '0') as sort_order,
       'Y' as is_active,
       'N' as is_default,
       '0' as insert_user_id,
       sysdate as insert_date,
       null as update_user_id,
       null as update_date
  from sys_common_lookups@perci_live
 where enabled_flag = 'Y'
   and lookup_type in ('CUSTOMER_EMAIL_LIST') -- Duplicated codes
   and meaning not in ('pdaniel@entitysolutionsgroup.com')
 order by code_type,
       sort_order,
       common_code
;

insert into sys_common_code
select lookup_type as code_type,
       '0000000000' as common_code,
       initcap(replace(lookup_type, '_', ' ')) as code_meaning,
       initcap(replace(lookup_type, '_', ' ')) as description_ko,
       initcap(replace(lookup_type, '_', ' ')) as description_en,
       lookup_type||'_'||'0000000000' as program_constants,
       '000' as sort_order,
       'Y' as is_active,
       'N' as is_default,
       '0' as insert_user_id,
       sysdate as insert_date,
       null as update_user_id,
       null as update_date
  from sys_common_lookups@perci_live
 where enabled_flag = 'Y'
   and lookup_type in ('EXTENSION_CHANGES') -- Duplicated codes
union
select lookup_type as code_type,
       lookup_code as common_code,
       meaning as description_ko,
       meaning as description_ko,
       meaning as description_en,
       lookup_type||'_'||lookup_code as program_constants,
       lpad(to_char(display_order), 3, '0') as sort_order,
       'Y' as is_active,
       'N' as is_default,
       '0' as insert_user_id,
       sysdate as insert_date,
       null as update_user_id,
       null as update_date
  from sys_common_lookups@perci_live
 where enabled_flag = 'Y'
   and lookup_type in ('EXTENSION_CHANGES') -- Duplicated codes
 order by code_type,
       sort_order,
       common_code
;

insert into sys_common_code
select distinct lookup_type as code_type,
       '0000000000' as common_code,
       initcap(replace(lookup_type, '_', ' ')) as code_meaning,
       initcap(replace(lookup_type, '_', ' ')) as description_ko,
       initcap(replace(lookup_type, '_', ' ')) as description_en,
       lookup_type||'_'||'0000000000' as program_constants,
       '000' as sort_order,
       'Y' as is_active,
       'N' as is_default,
       '0' as insert_user_id,
       sysdate as insert_date,
       null as update_user_id,
       null as update_date
  from sys_common_lookups@perci_live
 where enabled_flag = 'Y'
   and lookup_type in ('ORG_RELATIONSHIP') -- Duplicated codes
   and meaning not in ('EB Customer', 'EMA Prospect')
union
select distinct lookup_type as code_type,
       lookup_code as common_code,
       meaning as description_ko,
       meaning as description_ko,
       meaning as description_en,
       lookup_type||'_'||lookup_code as program_constants,
       lpad(to_char(display_order), 3, '0') as sort_order,
       'Y' as is_active,
       'N' as is_default,
       '0' as insert_user_id,
       sysdate as insert_date,
       null as update_user_id,
       null as update_date
  from sys_common_lookups@perci_live
 where enabled_flag = 'Y'
   and lookup_type in ('ORG_RELATIONSHIP') -- Duplicated codes
   and meaning not in ('EB Customer', 'EMA Prospect')
 order by code_type,
       sort_order,
       common_code
;
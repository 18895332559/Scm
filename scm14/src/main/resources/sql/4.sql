use scm ;
drop table if exists sys_param;

/*==============================================================*/
/* Table: sys_param                                             */
/*==============================================================*/
create table sys_param
(
   sys_param_id         bigint auto_increment,
   sys_param_field      varchar(50),
   sys_param_value      varchar(50),
   sys_param_text       varchar(50),
   primary key (sys_param_id)
);



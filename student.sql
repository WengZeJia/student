drop database if exists ssm;

create database ssm default charset=utf8;

use ssm;

drop table if exists t_exam;

drop table if exists t_grade;

drop table if exists t_grade_exam_middle;

drop table if exists t_mark;

drop table if exists t_school;

drop table if exists t_student_info;

drop table if exists t_subject;

drop table if exists t_sys_privilege;

drop table if exists t_sys_role;

drop table if exists t_sys_role_privilege_middle;

drop table if exists t_sys_teacher_role_middle;

drop table if exists t_sys_url;

drop table if exists t_teacher_grade_middle;

drop table if exists t_teacher_info;

drop table if exists t_year;

/*==============================================================*/
/* Table: t_exam                                                */
/*==============================================================*/
create table t_exam
(
   exam_id              int not null auto_increment,
   exam_name            varchar(50) comment '考试名称',
   subject_id           int,
   teacher_id           int comment '发起考试的教师',
   description          varchar(200),
   createBy             int,
   createTime           date,
   updateBy             int,
   updateTime           date,
   primary key (exam_id)
);

alter table t_exam comment '考试表';

/*==============================================================*/
/* Table: t_grade                                               */
/*==============================================================*/
create table t_grade
(
   grade_id             int not null auto_increment,
   grade_name           varchar(50) not null,
   student_count        int,
   year_id              int,
   school_id            int,
   description          varchar(200),
   createBy             int,
   createTime           date,
   updateBy             int,
   updateTime           date,
   primary key (grade_id)
);

alter table t_grade comment '班级';

/*==============================================================*/
/* Index: Index_grade_name                                      */
/*==============================================================*/
create index Index_grade_name on t_grade
(
   grade_name
);

/*==============================================================*/
/* Table: t_grade_exam_middle                                   */
/*==============================================================*/
create table t_grade_exam_middle
(
   id                   int not null auto_increment,
   grade_id             int,
   exam_id              int,
   createBy             int,
   createTime           date,
   updateBy             int,
   updateTime           date,
   primary key (id)
);

alter table t_grade_exam_middle comment '班级考试中间表';

/*==============================================================*/
/* Index: Index_grade_exam                                      */
/*==============================================================*/
create index Index_grade_exam on t_grade_exam_middle
(
   grade_id,
   exam_id
);

/*==============================================================*/
/* Table: t_mark                                                */
/*==============================================================*/
create table t_mark
(
   mark_id              bigint not null auto_increment,
   student_id           int not null,
   exam_id              int not null,
   exam_name            varchar(50),
   subject_id           int not null,
   subject_name         varchar(50),
   grade_id             int not null,
   grade_name           varchar(50),
   is_absent            tinyint,
   score                double,
   createBy             int,
   createTime           date,
   updateBy             int,
   updateTime           date,
   primary key (mark_id)
);

alter table t_mark comment '成绩表';

/*==============================================================*/
/* Index: Index_student_exam_grade                              */
/*==============================================================*/
create index Index_student_exam_grade on t_mark
(
   student_id,
   exam_id,
   subject_id,
   grade_id
);

/*==============================================================*/
/* Table: t_school                                              */
/*==============================================================*/
create table t_school
(
   school_id            int not null auto_increment,
   school_name          varchar(50) comment '学校名称',
   school_type          varchar(2) comment '学校的类型。gb:公办;sb:私办',
   description          varchar(200) comment '学校简介',
   createBy             int,
   createTime           date,
   updateBy             int,
   updateTime           date,
   primary key (school_id)
);

alter table t_school comment '学校';

/*==============================================================*/
/* Table: t_student_info                                        */
/*==============================================================*/
create table t_student_info
(
   student_info_id      int not null auto_increment,
   number               varchar(20) not null,
   password             varchar(100),
   student_name         varchar(20),
   age                  int,
   gender               varchar(2),
   grade_id             int,
   phone                varchar(30),
   email                varchar(30),
   description          varchar(200),
   createBy             int,
   createTime           date,
   updateBy             int,
   updateTime           date,
   primary key (student_info_id)
);

alter table t_student_info comment '学生信息表';

/*==============================================================*/
/* Index: Index_number                                          */
/*==============================================================*/
create index Index_number on t_student_info
(
   number
);

/*==============================================================*/
/* Table: t_subject                                             */
/*==============================================================*/
create table t_subject
(
   subject_id           int not null auto_increment,
   subject_name         varchar(50) not null,
   description          varchar(200),
   createBy             int,
   createTime           date,
   updateBy             int,
   updateTime           date,
   primary key (subject_id)
);

alter table t_subject comment '科目表';

/*==============================================================*/
/* Index: Index_subject_name                                    */
/*==============================================================*/
create index Index_subject_name on t_subject
(
   subject_name
);

/*==============================================================*/
/* Table: t_sys_privilege                                       */
/*==============================================================*/
create table t_sys_privilege
(
   sys_privilege_id     int not null auto_increment,
   privilege_name       varchar(30),
   privilege_alias      varchar(30),
   description          varchar(100),
   createby             int,
   createtime           date,
   updateby             int,
   updatetime           date,
   primary key (sys_privilege_id)
);

alter table t_sys_privilege comment '系统权限表';

/*==============================================================*/
/* Index: Index_priviliege_alias                                */
/*==============================================================*/
create index Index_priviliege_alias on t_sys_privilege
(
   privilege_alias
);

/*==============================================================*/
/* Table: t_sys_role                                            */
/*==============================================================*/
create table t_sys_role
(
   sys_role_id          int not null auto_increment,
   role_name            varchar(30),
   role_alias           varchar(30),
   description          varchar(100),
   createby             int,
   createtime           date,
   updateby             int,
   updatetime           date,
   primary key (sys_role_id)
);

alter table t_sys_role comment '系统角色表';

/*==============================================================*/
/* Index: sys_role_alias                                        */
/*==============================================================*/
create index sys_role_alias on t_sys_role
(
   role_alias
);

/*==============================================================*/
/* Table: t_sys_role_privilege_middle                           */
/*==============================================================*/
create table t_sys_role_privilege_middle
(
   id                   int not null auto_increment,
   sys_role_id          int,
   sys_privilege_id     int,
   createBy             int,
   createTime           date,
   updateBy             int,
   updateTime           date,
   primary key (id)
);

alter table t_sys_role_privilege_middle comment '角色权限中间表';

/*==============================================================*/
/* Index: Index_role_privilege                                  */
/*==============================================================*/
create index Index_role_privilege on t_sys_role_privilege_middle
(
   sys_role_id,
   sys_privilege_id
);

/*==============================================================*/
/* Table: t_sys_teacher_role_middle                             */
/*==============================================================*/
create table t_sys_teacher_role_middle
(
   id                   int not null auto_increment,
   teacher_info_id      int,
   sys_role_id          int,
   createby             int,
   createtime           date,
   updateby             int,
   updatetime           date,
   primary key (id)
);

alter table t_sys_teacher_role_middle comment '教师角色中间表';

/*==============================================================*/
/* Index: Index_user_role                                       */
/*==============================================================*/
create index Index_user_role on t_sys_teacher_role_middle
(
   sys_role_id,
   teacher_info_id
);

/*==============================================================*/
/* Table: t_sys_url                                             */
/*==============================================================*/
create table t_sys_url
(
   sys_url_id           int not null auto_increment,
   url                  varchar(200),
   sys_privilege_id     int,
   description          varchar(200),
   createby             int,
   createtime           date,
   updateby             int,
   updatetime           date,
   primary key (sys_url_id)
);

alter table t_sys_url comment '请求资源表';

/*==============================================================*/
/* Table: t_teacher_grade_middle                                */
/*==============================================================*/
create table t_teacher_grade_middle
(
   id                   int not null auto_increment,
   teacher_id           int,
   grade_id             int,
   createBy             int,
   createTime           date,
   updateBy             int,
   updateTime           date,
   primary key (id)
);

alter table t_teacher_grade_middle comment '教师班级中间表';

/*==============================================================*/
/* Index: Index_teacher_grade                                   */
/*==============================================================*/
create index Index_teacher_grade on t_teacher_grade_middle
(
   teacher_id,
   grade_id
);

/*==============================================================*/
/* Table: t_teacher_info                                        */
/*==============================================================*/
create table t_teacher_info
(
   teacher_info_id      int not null auto_increment,
   number               varchar(20),
   password             varchar(100),
   teacher_name         varchar(20),
   gender               varchar(2),
   age                  int,
   subject_ids          varchar(30),
   phone                varchar(30),
   email                varchar(30),
   is_account_non_expired tinyint(1),
   is_account_non_locked tinyint(1),
   is_credentials_non_expired tinyint(1),
   is_enabled           tinyint(1),
   description          varchar(200),
   createBy             int,
   createTime           date,
   updateBy             int,
   updateTime           date,
   primary key (teacher_info_id)
);

alter table t_teacher_info comment '教师表';

/*==============================================================*/
/* Table: t_year                                                */
/*==============================================================*/
create table t_year
(
   year_id              int not null auto_increment comment '年级ID',
   year_name            varchar(50) comment '年级名称',
   description          varchar(200) comment '年级简介',
   createBy             int,
   createTime           date,
   updateBy             int,
   updateTime           date,
   primary key (year_id)
);

alter table t_year comment '年级';

alter table t_exam add constraint FK_Reference_5 foreign key (subject_id)
      references t_subject (subject_id) on delete restrict on update restrict;

alter table t_exam add constraint FK_Reference_6 foreign key (teacher_id)
      references t_teacher_info (teacher_info_id) on delete restrict on update restrict;

alter table t_grade add constraint FK_Reference_1 foreign key (school_id)
      references t_school (school_id) on delete restrict on update restrict;

alter table t_grade add constraint FK_Reference_17 foreign key (year_id)
      references t_year (year_id) on delete restrict on update restrict;

alter table t_grade_exam_middle add constraint FK_Reference_7 foreign key (grade_id)
      references t_grade (grade_id) on delete restrict on update restrict;

alter table t_grade_exam_middle add constraint FK_Reference_8 foreign key (exam_id)
      references t_exam (exam_id) on delete restrict on update restrict;

alter table t_mark add constraint FK_Reference_3 foreign key (student_id)
      references t_student_info (student_info_id) on delete restrict on update restrict;

alter table t_mark add constraint FK_Reference_4 foreign key (exam_id)
      references t_exam (exam_id) on delete restrict on update restrict;

alter table t_student_info add constraint FK_Reference_2 foreign key (grade_id)
      references t_grade (grade_id) on delete restrict on update restrict;

alter table t_sys_role_privilege_middle add constraint FK_Reference_14 foreign key (sys_privilege_id)
      references t_sys_privilege (sys_privilege_id) on delete restrict on update restrict;

alter table t_sys_role_privilege_middle add constraint FK_Reference_15 foreign key (sys_role_id)
      references t_sys_role (sys_role_id) on delete restrict on update restrict;

alter table t_sys_teacher_role_middle add constraint FK_Reference_13 foreign key (sys_role_id)
      references t_sys_role (sys_role_id) on delete restrict on update restrict;

alter table t_sys_teacher_role_middle add constraint FK_Reference_16 foreign key (teacher_info_id)
      references t_teacher_info (teacher_info_id) on delete restrict on update restrict;

alter table t_sys_url add constraint FK_Reference_11 foreign key (sys_privilege_id)
      references t_sys_privilege (sys_privilege_id) on delete restrict on update restrict;

alter table t_teacher_grade_middle add constraint FK_Reference_10 foreign key (grade_id)
      references t_grade (grade_id) on delete restrict on update restrict;

alter table t_teacher_grade_middle add constraint FK_Reference_9 foreign key (teacher_id)
      references t_teacher_info (teacher_info_id) on delete restrict on update restrict;


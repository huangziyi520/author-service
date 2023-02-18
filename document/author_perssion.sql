--创建数据库:
create database author_perssion;
--创建表
create table user (
    id int not null primary key comment '主键',
    name varchar(32) not null comment '姓名',
    age smallint not null comment '年龄',
    gender char(1) not null comment '性别',
    phone_number varchar(11) not null comment '手机号',
    status char(1) not null comment '状态，0不可用 1可用',
    version smallint not null comment '版本号',
    gmt_modify Date not null comment '修改时间',
    gmt_create Date not null comment '创建时间'
--    索引类型
)
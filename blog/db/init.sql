-- 1、建库
drop database if exists bite;
create database bite character set utf8mb4;

-- 2、使用该库
use servlet_blog;

-- 3、建表
-- (1)用户表:
create table user(
    id int primary key auto_increment,
    username varchar(20) not null unique,
    password varchar(20) not null,
    nickname varchar(20),
    sex bit,
    birthday date,
    head varchar(50)
);
-- (2)文章表:
create table article(
    id int primary key auto_increment,
    title varchar(20) not null comment '标题',
    content mediumtext not null comment '文章内容',
    create_time timestamp default now() comment '创作时间',/*default now()默认插入当前的时间戳*/
    view_count int default 0 comment '访问量',
    user_id int,
    foreign key(user_id) references user(id)/*user表的id字段为外键*/
);

-- 4、添加数据：
insert into user(username,password) value ('a','1');
insert into user(username,password) value ('b','2');
insert into user(username,password) value ('c','3');

insert into article(title, content,user_id) value ('快速排序','public ...',1);
insert into article(title, content,user_id) value ('冒泡排序','public ...',1);
insert into article(title, content,user_id) value ('选择排序','public ...',1);
insert into article(title, content,user_id) value ('归并排序','public ...',2);
insert into article(title, content,user_id) value ('插入排序','public ...',2);

-- 主外键关联的表，默认创建的主外键约束是restrict严格模式，比如从表有数据关联到主表某一行数据X,那X不能删
-- 真实的设计上是不删除物理，而是在每一张表上设计一个字段，表示是否有效

select id, username, password, nickname, sex, birthday, head from user where user = 'a';
select id, title from article where user_id = 1;

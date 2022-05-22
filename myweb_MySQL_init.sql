create schema if not exists myweb;
use myweb;

drop table replies;
drop table comments;
drop table posts;
drop table users;

-- 用户表
CREATE TABLE users(
uid int PRIMARY KEY auto_increment,	
								-- 用户id，唯一标识符
username VARCHAR(20),			-- 用户名，用于登录
subname VARCHAR(20),			-- 昵称，用于显示
password VARCHAR(20),			-- 登录密码
gender int default 0,			-- 性别
age int default 0,				-- 年龄
telephone varchar(11),			-- 电话
description text default null,	-- 个人描述
regdate DATE,					-- 注册时间
status int default 1			-- 状态标示位
)DEFAULT CHARSET=utf8;

-- 贴子表
CREATE TABLE posts(
pid INT PRIMARY KEY auto_increment,			
							-- 贴子唯一标识id
uid int,					-- 发贴用户id
FOREIGN KEY(uid) REFERENCES users(uid) ON DELETE CASCADE ON UPDATE CASCADE,
username varchar(20), 		-- 发贴用户昵称
post_time TIMESTAMP,		-- 发布时间
update_time TIMESTAMP,		-- 最近修改时间
title VARCHAR(30),			-- 标题
content TEXT,				-- 正文
visit_num int default 0,	-- 被访问数
reply_num int default 0,	-- 评论数
like_num int default 0,		-- 点赞数
status int default 1		-- 状态标示位
)DEFAULT CHARSET=utf8;

-- 评论表
CREATE TABLE comments(
cid INT primary key auto_increment,
							-- 评论唯一标示id
uid int,					-- 评论用户id
FOREIGN KEY(uId) REFERENCES users(uid) ON DELETE CASCADE ON UPDATE CASCADE,
username varchar(20), 		-- 评论用户昵称
pid INT,					-- 所属贴子编号
FOREIGN KEY(pid) REFERENCES posts(pid) ON DELETE CASCADE ON UPDATE CASCADE,
time TIMESTAMP,				-- 评论发布时间
content TEXT,				-- 正文
like_num int default 0,		-- 点赞数
reply_num int default 0,	-- 回复数
status int default 1		-- 状态标示位
)DEFAULT CHARSET=utf8;

-- 回复表
CREATE TABLE replies(
rid INT primary key auto_increment,
							-- 回复唯一标示id
uid int,					-- 评论用户id
FOREIGN KEY(uId) REFERENCES users(uid) ON DELETE CASCADE ON UPDATE CASCADE,
username varchar(20), 		-- 回复用户昵称
pid INT,					-- 所属贴子编号
FOREIGN KEY(pid) REFERENCES posts(pid) ON DELETE CASCADE ON UPDATE CASCADE,
cid INT,					-- 所属评论编号
FOREIGN KEY(cid) REFERENCES comments(cid) ON DELETE CASCADE ON UPDATE CASCADE,
pre_rid INT default 0,		-- 所属回复编号
time TIMESTAMP,				-- 评论发布时间
content TEXT,				-- 正文
like_num int default 0,		-- 点赞数
status int default 1		-- 状态标示位
)DEFAULT CHARSET=utf8;

-- 插入数据
INSERT INTO users(username, subname, password, telephone, age, gender, description, regdate) VALUES
('abc123', '张三', '123abc', '12345678902', 17, 1, 'friend1', 20220501),
('def456', '李四', '456def', '12345678903', 26, 1, 'friend2', 20220502),
('qaz789', '王五', '789qaz', '12345678904', 107, 0, 'friend3', 20220503);

INSERT INTO posts(uid, username, post_time, update_time, title, content, visit_num, reply_num) VALUES
(1, '张三', 20220502100112, 20220502100112, '第一个帖子', '帖子内容abcd', 1, 2),
(3, '王五', 20220502100314, 20220502100419, '第二个帖子', '帖子内容qsxs', 3, 4);

INSERT INTO comments(uid, username, pid, time, content, reply_num) VALUES
(1, '张三', 1, 20220502100213, '评论111', 0),
(2, '李四', 2, 20220502100314, '评论222', 1),
(3, '王五', 1, 20220502101010, '评论111', 999);

insert into replies(uid, username, pid, cid, pre_rid, time, content, like_num) values
(1, '张三', 1, 1, 0, 20220502100213, '回复111', 0),
(1, '张三', 2, 2, 0, 20220502100314, '回复222', 1),
(3, '王五', 1, 3, 0, 20220502101010, '回复111', 999),
(3, '王五', 2, 2, 2, 20220502101010, '回复111', 999);

drop trigger tg1;
delimiter $$
create trigger tg1
after update
on users for each row
begin
	if new.subname != old.subname then begin
			update posts set username = new.subname where uid = old.uid;
			update comments set username = new.subname where uid = old.uid;
			update replies set username = new.subname where uid = old.uid;
		end;
    end if;
end $$
delimiter ;

select * from users;
select * from posts;
select * from comments;
select * from replies;

update users set subname = '王五' where uid = 3;
update users set subname = '王八' where uid = 3;
create table test(
id int primary key auto_increment,
_date date
);
insert into test(_date) value(curdate());
select * from test;
update test set id = 3, _date = curdate()+1 where id = 1;
drop table test;
select current_timestamp();
insert into users(username, subname, password, gender, telephone, regDate) values 
('txl', 'txl', 'tanxinlong', 1, '18971464212', curdate());

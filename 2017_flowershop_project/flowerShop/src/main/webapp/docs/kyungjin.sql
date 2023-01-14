-- 09.27
alter table users add (sessionkey VARCHAR2(50) default 'none' not null);
alter table users add (sessionlimit timestamp);
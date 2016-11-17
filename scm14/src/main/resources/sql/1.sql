DROP DATABASE IF EXISTS mybatis;
CREATE DATABASE mybatis
  CHARACTER SET UTF8;
USE mybatis;

CREATE TABLE dept (
  dept_id      INT PRIMARY KEY AUTO_INCREMENT,
  dept_name    VARCHAR(50),
  dept_address VARCHAR(50)
);


INSERT INTO dept (dept_name, dept_address) VALUES ('研发部一部', '广州');
INSERT INTO dept (dept_name, dept_address) VALUES ('研发部二部', '广州');
INSERT INTO dept (dept_name, dept_address) VALUES ('研发部三部', '深圳');
SELECT *
FROM dept;
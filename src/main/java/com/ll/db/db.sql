DROP DATABASE IF EXISTS hj1;
CREATE DATABASE hj1;
USE hj1;

CREATE TABLE todo (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	content text,
	isDone boolean DEFAULT false
);

SELECT * FROM todo;

INSERT INTO todo (id, content)
values(3, '등록 할 일');
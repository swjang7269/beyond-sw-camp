SHOW DATABASES;

CREATE user 'swcamp'@'%' IDENTIFIED BY 'swcamp';

SELECT * FROM user;

SHOW GRANTS FOR 'swcamp'@'%';

CREATE DATABASE menudb;

GRANT ALL PRIVILEGES ON menudb.* TO 'swcamp'@'%';

SHOW GRANTS FOR 'swcamp'@'%'menudb;
CREATE DATABASE IF NOT EXISTS BaseTp ;
use BaseTp;

DROP TABLE IF EXISTS employe;

CREATE TABLE employe(
	EMP_ID INTEGER auto_increment,
	firstname VARCHAR(64),
	lastname VARCHAR(64),
	PHONE_NUMBER VARCHAR(64),
	email VARCHAR(64),
	LOGIN VARCHAR(32),
	password VARCHAR(64),
	PRIMARY KEY(EMP_ID));

INSERT INTO employe (EMP_ID,firstname,lastname,PHONE_NUMBER,email,LOGIN,password)
VALUES (1,'alain', 'Therieur' , '0102030405' , 'alain.therieur@xyz.com','login1','pwd1');

INSERT INTO employe (EMP_ID,firstname,lastname,PHONE_NUMBER,email,LOGIN,password)
VALUES (2,'axelle', 'Aire' , '0102030405' , 'axelle.aire@m2i.com','login2','pwd2');

SELECT * FROM employe;
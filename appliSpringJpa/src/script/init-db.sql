CREATE DATABASE IF NOT EXISTS BaseTp ;
use BaseTp;

DROP TABLE IF EXISTS employe;
DROP TABLE IF EXISTS compte;

CREATE TABLE employe(
	EMP_ID INTEGER auto_increment,
	firstname VARCHAR(64),
	lastname VARCHAR(64),
	PHONE_NUMBER VARCHAR(64),
	email VARCHAR(64),
	LOGIN VARCHAR(32),
	password VARCHAR(64),
	PRIMARY KEY(EMP_ID));
	
CREATE TABLE compte(
	numero INTEGER auto_increment,
	label VARCHAR(64),
	solde DOUBLE,
	PRIMARY KEY(numero));	

INSERT INTO employe (EMP_ID,firstname,lastname,PHONE_NUMBER,email,LOGIN,password)
VALUES (1,'alain', 'Therieur' , '0102030405' , 'alain.therieur@xyz.com','login1','pwd1');

INSERT INTO employe (EMP_ID,firstname,lastname,PHONE_NUMBER,email,LOGIN,password)
VALUES (2,'axelle', 'Aire' , '0102030405' , 'axelle.aire@m2i.com','login2','pwd2');

INSERT INTO compte (numero,label,solde)
VALUES (1,'compte 1', 50.0);

SELECT * FROM employe;
SELECT * FROM compte;
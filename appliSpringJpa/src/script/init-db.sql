CREATE DATABASE IF NOT EXISTS BaseTp ;
use BaseTp;

DROP TABLE IF EXISTS employe;
DROP TABLE IF EXISTS operation;
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
	
create table operation (
    num_op integer not null auto_increment,
	date_op date, 
	label varchar(255), 
	montant double precision, 
	numero_compte integer, 
	primary key (num_op)) engine=InnoDB;
	
alter table operation add constraint operation_avec_compte_valide 
foreign key (numero_compte) references compte (numero);

INSERT INTO employe (EMP_ID,firstname,lastname,PHONE_NUMBER,email,LOGIN,password)
VALUES (1,'alain', 'Therieur' , '0102030405' , 'alain.therieur@xyz.com','login1','pwd1');

INSERT INTO employe (EMP_ID,firstname,lastname,PHONE_NUMBER,email,LOGIN,password)
VALUES (2,'axelle', 'Aire' , '0102030405' , 'axelle.aire@m2i.com','login2','pwd2');

INSERT INTO compte (numero,label,solde) VALUES (1,'compte 1', 50.0);
INSERT INTO compte (numero,label,solde) VALUES (2,'compte 2', 150.0);

INSERT INTO operation (num_op,label,montant,date_op,numero_compte) VALUES (1,'achat 1 sur compte 1', -4.5 , '2022-02-25',1);
INSERT INTO operation (num_op,label,montant,date_op,numero_compte) VALUES (2,'achat 2 sur compte 1', -3.5 , '2022-03-22' , 1);
INSERT INTO operation (num_op,label,montant,date_op,numero_compte) VALUES (3,'achat 1 sur compte 2', -1.5 , '2022-01-20',2);
INSERT INTO operation (num_op,label,montant,date_op,numero_compte) VALUES (4,'achat 2 sur compte 2', -1.2 , '2022-01-21',2);

SELECT * FROM employe;
SELECT * FROM compte;
SELECT * FROM operation;
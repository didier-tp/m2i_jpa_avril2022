create table compte (numero integer not null auto_increment, label varchar(64), solde double precision, primary key (numero)) engine=InnoDB;
create table employe (emp_id integer not null auto_increment, email varchar(255), firstname varchar(255), lastname varchar(255), login varchar(255), password varchar(255), phone_number varchar(255), primary key (emp_id)) engine=InnoDB;

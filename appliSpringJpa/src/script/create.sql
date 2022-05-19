create table compte (numero integer not null auto_increment, label varchar(64), solde double precision, primary key (numero)) engine=InnoDB;
create table employe (emp_id integer not null auto_increment, email varchar(255), firstname varchar(255), lastname varchar(255), login varchar(255), password varchar(255), phone_number varchar(255), primary key (emp_id)) engine=InnoDB;
create table operation (num_op integer not null auto_increment, date_op date, label varchar(255), montant double precision, numero_compte integer, primary key (num_op)) engine=InnoDB;
alter table operation add constraint FK7uy284juguwgv9wtylgawhoae foreign key (numero_compte) references compte (numero);
create table compte (numero integer not null auto_increment, label varchar(64), solde double precision, primary key (numero)) engine=InnoDB;
create table employe (emp_id integer not null auto_increment, email varchar(255), firstname varchar(255), lastname varchar(255), login varchar(255), password varchar(255), phone_number varchar(255), primary key (emp_id)) engine=InnoDB;
create table operation (num_op integer not null auto_increment, date_op date, label varchar(255), montant double precision, numero_compte integer, primary key (num_op)) engine=InnoDB;
alter table operation add constraint FK7uy284juguwgv9wtylgawhoae foreign key (numero_compte) references compte (numero);

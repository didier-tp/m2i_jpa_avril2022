package com.m2i.tp.appliSpringJpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 CREATE TABLE employe(
	EMP_ID INTEGER auto_increment,
	firstname VARCHAR(64),
	lastname VARCHAR(64),
	PHONE_NUMBER VARCHAR(64),
	email VARCHAR(64),
	LOGIN VARCHAR(32),
	password VARCHAR(64),
	PRIMARY KEY(EMP_ID));
 */

@Entity
@Table(name = "employe")
public class Employe {
	
	@Id
	@Column(name = "EMP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	
	@NotNull(message = "firstname cannot be null")
	private String firstname;
	   
	@NotNull(message = "lastname cannot be null")
	private String lastname;
	   
	@Column(name="PHONE_NUMBER") //attention piège (avec MySql sous linux , il y a différence entre minuscule/majuscule sur nom de colonne , mais pas sous windows)
	private String phoneNumber;
	   
	@Email(message = "email should be valid")
	 private String email;

	 @Column(name="LOGIN",length = 32) //pour VARCHAR(32) si table créée automatiquement
	 private String login;
	   
	 @Size(min = 3, max = 32, message = "password length must be between 3 and 32 characters")
	 private String password;

	
	public Employe() {
		super();
	}
	
	
	public Employe(Integer empId, String firstname, String lastname, String phoneNumber, String email, String login,
			String password) {
		super();
		this.empId = empId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.login = login;
		this.password = password;
	}
	
	

	@Override
	public String toString() {
		return "Employe [empId=" + empId + ", firstname=" + firstname + ", lastname=" + lastname + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", login=" + login + ", password=" + password + "]";
	}


	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

package com.m2i.tp.appliSpringJpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "client")
@NamedQueries({
	   @NamedQuery(name = "Client.findClientsByCompteNumber",
	                       query = "SELECT cli FROM  Client cli inner join cli.comptes cpt WHERE cpt.numero = ?1 "),
	   @NamedQuery(name = "Client.findComptesByClientNumber",
                           query = "SELECT cpt FROM  Client cli inner join cli.comptes cpt WHERE cli.numero = ?1 "),
	   @NamedQuery(name = "Client.findClientWithComptesByClientNumber",
                           query = "SELECT cli FROM  Client cli inner join fetch cli.comptes WHERE cli.numero = ?1 ")
	}) 
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	
	private String firstname;
	   
	private String lastname;
	
	@ManyToMany()
	@JoinTable(name = "client_compte",
		joinColumns = {@JoinColumn(name = "client_id")},
		inverseJoinColumns = {@JoinColumn(name = "compte_id")})
	private List<Compte> comptes;
	
	public void addCompte(Compte cpt) {
		if(this.comptes==null) {
			this.comptes = new ArrayList<Compte>();
		}
		this.comptes.add(cpt);
	}
	

	public Client() {
		super();
	}

	public Client(Integer numero, String firstname, String lastname) {
		super();
		this.numero = numero;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Client [numero=" + numero + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
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

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	   
	
	

}

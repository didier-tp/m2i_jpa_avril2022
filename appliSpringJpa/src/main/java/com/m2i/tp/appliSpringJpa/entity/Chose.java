package com.m2i.tp.appliSpringJpa.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "chose")
@NamedQueries({
	  
	})
public class Chose {
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator( name = "uuid", strategy = "org.hibernate.id.UUIDGenerator"  )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
	
	private String nom;
	
	

	public Chose() {
		super();
	}
	
	

	public Chose(UUID id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}



	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Chose [id=" + id + ", nom=" + nom + "]";
	}
	   
	
	

}

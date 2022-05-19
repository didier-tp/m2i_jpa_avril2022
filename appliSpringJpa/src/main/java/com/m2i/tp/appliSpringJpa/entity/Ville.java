package com.m2i.tp.appliSpringJpa.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="ville")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE )
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Ville implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="label" , length = 64) // label VARCHAR(64)
	private String nom;
	
	private Integer population;
	

	public Ville() {
		super();
	}

	public Ville(Integer id, String nom, Integer population) {
		super();
		this.id = id;
		this.nom = nom;
		this.population = population;
	}

	@Override
	public String toString() {
		return "Ville " /*+ super.toString() */ + "  [id=" + id + ", nom=" + nom + ", population=" + population + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}
	
	

}

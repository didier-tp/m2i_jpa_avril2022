package com.m2i.tp.appliSpringJpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="compte")
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	
	@Column(name="label" , length = 64) // label VARCHAR(64)
	private String label;
	
	private Double solde;
	
	//1-n (fetch = FetchType.EAGER , mappedBy="nom java de la relation inverse")
	@OneToMany(fetch = FetchType.EAGER , mappedBy="compte")
	private List<Operation> operations;
	
	public void addOperation(Operation op) {
		if(this.operations==null) {
			this.operations = new ArrayList<Operation>();
		}
		op.setCompte(this);
		this.operations.add(op);
	}
	
	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}

	public Compte(Integer numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}

	public Compte() {
		super();
	}
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	

}

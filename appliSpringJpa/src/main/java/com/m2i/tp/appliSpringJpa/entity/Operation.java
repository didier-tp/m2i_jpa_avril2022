package com.m2i.tp.appliSpringJpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="operation")
@NamedQueries({
	   @NamedQuery(name = "Operation.findOperationsByCompteNumber",
	               query = "SELECT o FROM  Operation o WHERE o.compte.numero = ?1 ")
	})
public class Operation {
	
	@Id
	@Column(name="num_op")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numOp;
	
    private String label;
    private Double montant;
   
    @Temporal(TemporalType.DATE)
    private Date dateOp; //"2022-05-19"
    
    //n-1 et foreign key "numero_compte"
    @ManyToOne()
    @JoinColumn(name="numero_compte")
    private Compte compte;

    

	@Override
	public String toString() {
		return "Operation [numOp=" + numOp + ", label=" + label + ", montant=" + montant + ", dateOp=" + dateOp
				+ /* ", compte=" + compte + */ "]";
	}



	public Operation() {
		super();
	}



	public Operation(Integer numOp, String label, Double montant, Date dateOp, Compte compte) {
		super();
		this.numOp = numOp;
		this.label = label;
		this.montant = montant;
		this.dateOp = dateOp;
		this.compte = compte;
	}



	public Operation(Integer numOp, String label, Double montant, Date dateOp) {
		super();
		this.numOp = numOp;
		this.label = label;
		this.montant = montant;
		this.dateOp = dateOp;
	}



	public Integer getNumOp() {
		return numOp;
	}



	public void setNumOp(Integer numOp) {
		this.numOp = numOp;
	}



	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public Double getMontant() {
		return montant;
	}



	public void setMontant(Double montant) {
		this.montant = montant;
	}



	public Date getDateOp() {
		return dateOp;
	}



	public void setDateOp(Date dateOp) {
		this.dateOp = dateOp;
	}



	public Compte getCompte() {
		return compte;
	}



	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
    
    
}


/*
Tp à faire :
1 . Completer entity.Operation et éventuellement peuufiner entity.Compte
2.  Coder interface DaoOperation
3.  Coder classe DaoOperationJpa 
4. compter TestDaoCompte pour tester mieux le lien entre compte et operation 
*/



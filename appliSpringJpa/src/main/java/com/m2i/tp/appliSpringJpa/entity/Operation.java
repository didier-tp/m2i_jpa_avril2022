package com.m2i.tp.appliSpringJpa.entity;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Operation {
    private Integer numOp;
    private String label;
    private Double montant;
   
    @Temporal(TemporalType.DATE)
    private Date dateOp; //"2022-05-19"
    
    //n-1 et foreign key "numero_compte"
    private Compte compte;

    
    
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
	
	
    
    
}


/*
Tp à faire :
1 . Completer entity.Operation et éventuellement peuufiner entity.Compte
2.  Coder interface DaoOperation
3.  Coder classe DaoOperationJpa 
4. compter TestDaoCompte pour tester mieux le lien entre compte et operation 
*/



package com.m2i.tp.appliSpringJpa.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.entity.Compte;



@Repository //cas particulier de @Component //pour prise en charge par framework spring
@Transactional //pour commit/rollback automatique
public class DaoCompteJpa extends DaoGenericJpa<Compte,Integer> implements DaoCompte {

	public DaoCompteJpa() {
		super();
		this.entityClass = Compte.class; //chose à initialiser dans le DaoGenericJpa
	}
	
    //....
	
}

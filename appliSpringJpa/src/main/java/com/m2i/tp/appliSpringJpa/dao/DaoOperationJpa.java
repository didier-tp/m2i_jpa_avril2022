package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.entity.Compte;
import com.m2i.tp.appliSpringJpa.entity.Operation;



@Repository //cas particulier de @Component //pour prise en charge par framework spring
@Transactional //pour commit/rollback automatique
public class DaoOperationJpa extends DaoGenericJpa<Operation,Integer> implements DaoOperation {

	public DaoOperationJpa() {
		super();
		this.entityClass = Operation.class; //chose à initialiser dans le DaoGenericJpa
	}

	@Override
	public List<Operation> findOperationsByCompteNumber(Integer numCompte) {
		return entityManager.createNamedQuery("Operation.findOperationsByCompteNumber",Operation.class)
				.setParameter(1,  numCompte)
				.getResultList();
	}
	
    //....
	
}

package com.m2i.tp.appliSpringJpa.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.entity.Operation;



@Repository //cas particulier de @Component //pour prise en charge par framework spring
@Transactional //pour commit/rollback automatique
public class DaoOperationJpa extends DaoGenericJpa<Operation,Integer> implements DaoOperation {

	public DaoOperationJpa() {
		super();
		this.entityClass = Operation.class; //chose à initialiser dans le DaoGenericJpa
	}
	
    //....
	
}

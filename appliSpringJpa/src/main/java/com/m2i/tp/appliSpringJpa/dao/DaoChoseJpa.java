package com.m2i.tp.appliSpringJpa.dao;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.entity.Chose;



@Repository //cas particulier de @Component //pour prise en charge par framework spring
@Transactional //pour commit/rollback automatique
public class DaoChoseJpa extends DaoGenericJpa<Chose,UUID> implements DaoChose {

	public DaoChoseJpa() {
		super();
		this.entityClass = Chose.class; //chose à initialiser dans le DaoGenericJpa
	}


}

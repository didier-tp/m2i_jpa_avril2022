package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.entity.Employe;


/*
* Cette version du DAO sera utilisé par Spring+JPA
* et spring va initialiser automatiquement le entityManager
* grace à l'annotation @PersistenceContext.
*
* Spring va aussi déclencher automatiquement des commit/rollback
* si on place @Transactional sur la classe ou une méthode
* 
* NB: Cette classe utilise Spring sur la partie @Transactional et @PersistenceContext
* mais n'utilise volontairement pas l'extension spring-data-jpa pour ne pas cacher JPA
* 
*/
@Repository //cas particulier de @Component //pour prise en charge par framework spring
@Transactional //pour commit/rollback automatique
public class DaoEmployeJpaAvecSpring extends DaoGenericJpa<Employe,Integer> implements DaoEmploye {

	public DaoEmployeJpaAvecSpring() {
		super();
		this.entityClass = Employe.class;
	}
	
	
}

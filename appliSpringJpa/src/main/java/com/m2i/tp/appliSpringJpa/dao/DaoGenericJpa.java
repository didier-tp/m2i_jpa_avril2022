package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.entity.Compte;


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
public class DaoGenericJpa<T,ID> implements DaoGeneric<T,ID> {
	
	//NB: @PersistenceContext permet d'initialiser l'objet technique
	//entityManager à partir d'une configuration
	// src/main/resources/META-INF/persistence.xml
	// ou bien config spring équivalente dans src/main/resources/application.properties
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected Class<T> entityClass; //ex: Compte.class ou Employe.class (à initialiser au début)
	

	@Override
	public T findById(ID id) {
		return entityManager.find(entityClass, id);//.find() au sens .findByPrimaryKey()
	}

	@Override
	public List<T> findAll() {
		return entityManager.createQuery("SELECT e FROM " + entityClass.getName() +" e",entityClass)
				.getResultList();
	}

	@Override
	public T insert(T e) {
			entityManager.persist(e); //INSERT INTO SQL avec aut_incr
		return e;
	}

	@Override
	public void update(T e) {
			entityManager.merge(e); //UPDATE SQL
	}

	@Override
	public void deleteById(ID id) {
			T entiteAsupprimer = entityManager.find(entityClass, id);
			entityManager.remove(entiteAsupprimer);
			//déclenche automatiquement DELETE FROM Compte WHERE ...=id
	}

}

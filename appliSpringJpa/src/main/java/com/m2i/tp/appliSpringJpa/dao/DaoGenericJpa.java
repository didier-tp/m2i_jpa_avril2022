package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


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
//@Transactional //pour commit/rollback automatique (ici ou au cas par cas sur méthodes)
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
	@Transactional
	public T insert(T e) {
			entityManager.persist(e); //INSERT INTO SQL avec aut_incr
		return e;
	}

	@Override
	@Transactional
	public void update(T e) {
		    //via le @Transactional placé au dessus de la classe du dao
		    //il y a ici un entityManager.getTransaction().begin() automatiquement déclenché
		    //si un service ne l'a pas déjà fait sinon le dao utilise la transaction déjà créée.
			entityManager.merge(e); //UPDATE SQL
			//via le @Transactional placé au dessus de cette classe de dao
		    //il y a ici un entityManager.getTransaction().commit() ou .rollback() automatiquement déclenché
			//si c'est le dao qui a commencé la transaction. 
			//c'est le service métier appelant qui fait de commit ou rollback dans le cas contraire 
	}

	@Override
	@Transactional
	public void deleteById(ID id) {
			T entiteAsupprimer = entityManager.find(entityClass, id);
			entityManager.remove(entiteAsupprimer);
			//déclenche automatiquement DELETE FROM Compte WHERE ...=id
	}

}

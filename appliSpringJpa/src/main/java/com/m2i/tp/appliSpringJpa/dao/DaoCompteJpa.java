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
public class DaoCompteJpa implements DaoCompte {
	
	//NB: @PersistenceContext permet d'initialiser l'objet technique
	//entityManager à partir d'une configuration
	// src/main/resources/META-INF/persistence.xml
	// ou bien config spring équivalente dans src/main/resources/application.properties
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public Compte findById(Integer id) {
		return entityManager.find(Compte.class, id);//.find() au sens .findByPrimaryKey()
	}

	@Override
	public List<Compte> findAll() {
		return entityManager.createQuery("SELECT e FROM Compte e",Compte.class)
				.getResultList();
	}

	@Override
	public Compte insertCompte(Compte c) {
			entityManager.persist(c); //INSERT INTO SQL avec aut_incr
		return c;
	}

	@Override
	public void updateCompte(Compte c) {
			entityManager.merge(c); //UPDATE SQL
	}

	@Override
	public void deleteById(Integer id) {
			Compte compteAsupprimer = entityManager.find(Compte.class, id);
			entityManager.remove(compteAsupprimer);
			//déclenche automatiquement DELETE FROM Compte WHERE numero=id
	}

}

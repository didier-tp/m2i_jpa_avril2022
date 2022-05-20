package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

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

	@Override
	public List<Compte> findBySoldeMaxi(double soldeMaxi) {
		/*return entityManager.createQuery("SELECT c FROM  Compte c WHERE c.solde < :soldeMax ",Compte.class)
				.setParameter("soldeMax", soldeMaxi)
				.getResultList();*/
		/*return entityManager.createQuery("SELECT c FROM  Compte c WHERE c.solde < ?1 ",Compte.class)
				.setParameter(1, soldeMaxi)
				.getResultList();*/
		return entityManager.createNamedQuery("Compte.findBySoldeMaxi",Compte.class)
				.setParameter(1, soldeMaxi)
				.getResultList();
	}
	
    //....
	
}

package com.m2i.tp.appliSpringJpa.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.entity.Commande;
import com.m2i.tp.appliSpringJpa.entity.LigneCommande;
import com.m2i.tp.appliSpringJpa.entity.pk.LigneCommandePk;



@Repository //cas particulier de @Component //pour prise en charge par framework spring
@Transactional //pour commit/rollback automatique
public class DaoCommandeJpa extends DaoGenericJpa<Commande,Integer> implements DaoCommande {

	public DaoCommandeJpa() {
		super();
		this.entityClass = Commande.class; //chose à initialiser dans le DaoGenericJpa
	}

	@Override
	public Commande findByIdWithlines(Integer numCmde) {
		return entityManager.createNamedQuery("Commande.findByIdWithlines",Commande.class)
				.setParameter(1,  numCmde)
				.getSingleResult();
	}

	@Override
	public void deleteLigneCommande(LigneCommandePk pk) {
		entityManager.remove(entityManager.find(LigneCommande.class, pk));
	}


}

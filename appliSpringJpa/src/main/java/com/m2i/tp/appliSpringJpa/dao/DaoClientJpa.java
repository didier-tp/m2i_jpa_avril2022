package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.entity.Client;
import com.m2i.tp.appliSpringJpa.entity.Compte;



@Repository //cas particulier de @Component //pour prise en charge par framework spring
@Transactional //pour commit/rollback automatique
public class DaoClientJpa extends DaoGenericJpa<Client,Integer> implements DaoClient {

	public DaoClientJpa() {
		super();
		this.entityClass = Client.class; //chose à initialiser dans le DaoGenericJpa
	}

	@Override
	public List<Client> findClientsByCompteNumber(Integer numCompte) {
		return entityManager.createNamedQuery("Client.findClientsByCompteNumber",Client.class)
				.setParameter(1,  numCompte)
				.getResultList();
	}

	@Override
	public Client findClientWithComptesByClientNumber(Integer numCli) {
		return entityManager.createNamedQuery("Client.findClientWithComptesByClientNumber",Client.class)
				.setParameter(1,  numCli)
				.getSingleResult();
	}

	
}

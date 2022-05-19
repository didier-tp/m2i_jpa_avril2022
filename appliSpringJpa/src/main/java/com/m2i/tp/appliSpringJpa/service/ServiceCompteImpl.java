package com.m2i.tp.appliSpringJpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.dao.DaoCompte;
import com.m2i.tp.appliSpringJpa.entity.Compte;

@Service //composant Spring de type 'service metier' (business service)
@Transactional
public class ServiceCompteImpl implements ServiceCompte {
	
	@Autowired //auto-liaison (injection de dépendance) gérée par Spring
	private DaoCompte daoCompte;

	@Override
	public void virement(double montant, Integer numCptDeb, Integer numCptCred) throws RuntimeException {
		Compte compteAdebiter = daoCompte.findById(numCptDeb);
		compteAdebiter.setSolde(compteAdebiter.getSolde() - montant);
		daoCompte.update(compteAdebiter);
		
		Compte compteAcrediter = daoCompte.findById(numCptCred);
		compteAcrediter.setSolde(compteAcrediter.getSolde() + montant);
		daoCompte.update(compteAcrediter);
	}

}

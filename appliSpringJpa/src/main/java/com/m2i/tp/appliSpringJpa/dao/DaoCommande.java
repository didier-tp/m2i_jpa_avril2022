package com.m2i.tp.appliSpringJpa.dao;

import com.m2i.tp.appliSpringJpa.entity.Commande;
import com.m2i.tp.appliSpringJpa.entity.pk.LigneCommandePk;

/*
 DAO : Data Access Object (objet de traitement spécialisé dans l'accès aux données en base)
 comporte des méthodes CRUD (Create/Insert , Rechercher , Update , Delete)
 avec throws RuntimeException implicite
 */

public interface DaoCommande extends DaoGeneric<Commande,Integer>{
	//+ méthode de recherche spécifiques 
	Commande findByIdWithlines(Integer numCmde);
	
	void deleteLigneCommande(LigneCommandePk pk);
}



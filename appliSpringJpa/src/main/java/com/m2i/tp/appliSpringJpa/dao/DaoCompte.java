package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import com.m2i.tp.appliSpringJpa.entity.Client;
import com.m2i.tp.appliSpringJpa.entity.Compte;

/*
 DAO : Data Access Object (objet de traitement spécialisé dans l'accès aux données en base)
 comporte des méthodes CRUD (Create/Insert , Rechercher , Update , Delete)
 avec throws RuntimeException implicite
 */

public interface DaoCompte extends DaoGeneric<Compte,Integer>{
	//+ méthode de recherche spécifiques aux comptes
	List<Compte> findBySoldeMaxi(double soldeMaxi);
	Compte findCompteByIdWithOperations(Integer idCompte); //pour eviter lazyException
	List<Compte> findComptesByClientNumber(Integer numClient);
}



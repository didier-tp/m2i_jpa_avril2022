package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import com.m2i.tp.appliSpringJpa.entity.Client;
import com.m2i.tp.appliSpringJpa.entity.Operation;

/*
 DAO : Data Access Object (objet de traitement spécialisé dans l'accès aux données en base)
 comporte des méthodes CRUD (Create/Insert , Rechercher , Update , Delete)
 avec throws RuntimeException implicite
 */

public interface DaoClient extends DaoGeneric<Client,Integer>{
	//+ méthode de recherche spécifiques 
	List<Client> findClientsByCompteNumber(Integer numCompte);
	Client findClientWithComptesByClientNumber(Integer numCli);
}



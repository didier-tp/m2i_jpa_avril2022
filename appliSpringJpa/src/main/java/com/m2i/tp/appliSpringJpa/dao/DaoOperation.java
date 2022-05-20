package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import com.m2i.tp.appliSpringJpa.entity.Operation;

/*
 DAO : Data Access Object (objet de traitement spécialisé dans l'accès aux données en base)
 comporte des méthodes CRUD (Create/Insert , Rechercher , Update , Delete)
 avec throws RuntimeException implicite
 */

public interface DaoOperation extends DaoGeneric<Operation,Integer>{
	//+ méthode de recherche spécifiques aux comptes
	List<Operation> findOperationsByCompteNumber(Integer numCompte);
	//à tester en fin de méthode testCompteAvecOperations sur TestDaoCompte
}



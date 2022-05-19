package com.m2i.tp.appliSpringJpa.dao;

import com.m2i.tp.appliSpringJpa.entity.Operation;

/*
 DAO : Data Access Object (objet de traitement spécialisé dans l'accès aux données en base)
 comporte des méthodes CRUD (Create/Insert , Rechercher , Update , Delete)
 avec throws RuntimeException implicite
 */

public interface DaoOperation extends DaoGeneric<Operation,Integer>{
	//+ méthode de recherche spécifiques aux comptes
}



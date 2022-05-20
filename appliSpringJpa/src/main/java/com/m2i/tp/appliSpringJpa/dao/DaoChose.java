package com.m2i.tp.appliSpringJpa.dao;

import java.util.UUID;

import com.m2i.tp.appliSpringJpa.entity.Chose;

/*
 DAO : Data Access Object (objet de traitement spécialisé dans l'accès aux données en base)
 comporte des méthodes CRUD (Create/Insert , Rechercher , Update , Delete)
 avec throws RuntimeException implicite
 */

public interface DaoChose extends DaoGeneric<Chose,UUID>{
	//+ méthode de recherche spécifiques 
	
}



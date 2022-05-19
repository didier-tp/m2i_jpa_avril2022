package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import com.m2i.tp.appliSpringJpa.entity.Compte;

/*
 DAO : Data Access Object (objet de traitement spécialisé dans l'accès aux données en base)
 comporte des méthodes CRUD (Create/Insert , Rechercher , Update , Delete)
 avec throws RuntimeException implicite
 */

public interface DaoCompte extends DaoGeneric<Compte,Integer>{
	//+ méthode de recherche spécifiques aux comptes
}

/*
V1 (sans astuce)
public interface DaoCompte {
      public Compte findById(Integer id);
      public List<Compte> findAll();
      //....
      public Compte insert(Compte c);
      
      public void update(Compte c); // update / mise à jour des valeurs en base
      
      public void deleteById(Integer id);
      
}
*/

package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import com.m2i.tp.appliSpringJpa.entity.Compte;

/*
 DAO : Data Access Object (objet de traitement spécialisé dans l'accès aux données en base)
 comporte des méthodes CRUD (Create/Insert , Rechercher , Update , Delete)
 avec throws RuntimeException implicite
 */

public interface DaoCompte {
      public Compte findById(Integer id);
      public List<Compte> findAll();
      //....
      public Compte insertCompte(Compte c);
      
      public void updateCompte(Compte c); // update / mise à jour des valeurs en base
      
      public void deleteById(Integer id);
      
}

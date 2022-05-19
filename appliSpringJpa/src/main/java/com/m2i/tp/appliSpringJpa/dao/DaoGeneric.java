package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import com.m2i.tp.appliSpringJpa.entity.Compte;

/*
 DAO : Data Access Object (objet de traitement spécialisé dans l'accès aux données en base)
 comporte des méthodes CRUD (Create/Insert , Rechercher , Update , Delete)
 avec throws RuntimeException implicite
 
 <T,ID> avec T = Employe ou Compte = classe de l'entité persistante
         et ID = Integer ou String = type de clef primaire
         
 NB: dans exetension spring-data , CrudRepository<T,ID> ressemble à DaoGeneric<T,ID>
 */

public interface DaoGeneric<T,ID> {
      public T findById(ID id);
      public List<T> findAll();
      //....
      public T insert(T c);
      public void update(T c); // update / mise à jour des valeurs en base
      public void deleteById(ID id);
}

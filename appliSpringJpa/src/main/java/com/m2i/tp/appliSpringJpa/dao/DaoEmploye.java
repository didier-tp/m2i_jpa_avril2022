package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import com.m2i.tp.appliSpringJpa.entity.Employe;

/*
 DAO : Data Access Object (objet de traitement spécialisé dans l'accès aux données en base)
 comporte des méthodes CRUD (Create/Insert , Rechercher , Update , Delete)
 avec throws RuntimeException implicite
 */
public interface DaoEmploye extends DaoGeneric<Employe,Integer>{
	//...
}

/*
V1 sans astuce:
public interface DaoEmploye {
      public Employe findById(Integer id);
      public List<Employe> findAll();
      //....
      public Employe insert(Employe emp);//en entrée : objet pas encore stocké en base avec idEmp=null
                                                //en retour : objet avec .idEmp auto-incrémenté
      
      public void update(Employe emp); // update / mise à jour des valeurs en base
      
      public void deleteById(Integer id);
      
}
*/

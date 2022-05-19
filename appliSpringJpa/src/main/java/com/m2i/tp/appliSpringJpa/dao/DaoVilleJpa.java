package com.m2i.tp.appliSpringJpa.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.appliSpringJpa.entity.Ville;



@Repository //cas particulier de @Component //pour prise en charge par framework spring
//@Transactional //au cas par cas sur methodes
public class DaoVilleJpa extends DaoGenericJpa<Ville,Integer> implements DaoVille {

	public DaoVilleJpa() {
		super();
		this.entityClass = Ville.class; //chose à initialiser dans le DaoGenericJpa
	}
	
	
}

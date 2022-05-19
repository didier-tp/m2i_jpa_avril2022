package com.m2i.tp.appliSpringJpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.m2i.tp.appliSpringJpa.dao.DaoVille;
import com.m2i.tp.appliSpringJpa.entity.Ville;

@SpringBootTest
class TestDaoVilleAvecCache {
	
	//initialise daoEmploye pour que ça référence un composant pris en charge
	//par Spring et qui est compatible avec l'interface DaoEmploye
	//dans ce projet , seule la classe DaoEmployeJpaAvecSpring correspond à ce critère
	@Autowired //injection de dépendance via Spring
	private DaoVille daoVille;
	
    void preparerQuelquesVilles() {
    	//valeurs stables évoluant rarement
    	daoVille.insert(new Ville(null,"Paris" , 2206488));
    	daoVille.insert(new Ville(null,"Marseille" , 861535));
    	daoVille.insert(new Ville(null,"Lyon" , 513275));
    	daoVille.insert(new Ville(null,"Toulouse" , 471941));
    	daoVille.insert(new Ville(null,"Nantes" , 303382));
	}
	

	@Test
	void testVilleAvecCache() {
		//premier(s) appel(s) (avec remplissage de cache)
		preparerQuelquesVilles();
		recupererQuelquesVilles();
		
		//autres(s) appel(s) (avec utilisation du cache sans nouveaux select en base)
		recupererQuelquesVilles();
		recupererQuelquesVilles(); //ici à la suite
		recupererQuelquesVilles(); //dans vrai projet (appels déclenchés par utilisateurs différents)
		
		/*BUG à elucider : o.h.c.s.support.AbstractReadWriteAccess  : 
		 * Cache put-from-load [region=`AccessType[read-write]` 
		 * (com.m2i.tp.appliSpringJpa.entity.Ville), key=`com.m2i.tp.appliSpringJpa.entity.Ville#2`,
		 *  value=`CacheEntry(com.m2i.tp.appliSpringJpa.entity.Ville)`] failed due to being non-writable
		 */
	}
	
	void recupererQuelquesVilles() {
		System.out.println("villes="+ daoVille.findAll());
	}
	
	
	

}

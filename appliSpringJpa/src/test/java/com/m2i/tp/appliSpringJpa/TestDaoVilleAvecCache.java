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
	
	int  preparerQuelquesVilles() {
    	int firstId = 0;
    	//valeurs stables évoluant rarement
    	firstId = daoVille.insert(new Ville(null,"Paris" , 2206488)).getId();
    	daoVille.insert(new Ville(null,"Marseille" , 861535));
    	daoVille.insert(new Ville(null,"Lyon" , 513275));
    	daoVille.insert(new Ville(null,"Toulouse" , 471941));
    	daoVille.insert(new Ville(null,"Nantes" , 303382));
    	return firstId;
	}
	

	@Test
	void testVilleAvecCache() {
		//premier(s) appel(s) (avec remplissage de cache)
		int firstId = preparerQuelquesVilles();
		recupererQuelquesVilles(firstId);
		
		//autres(s) appel(s) (avec utilisation du cache sans nouveaux select en base)
		recupererQuelquesVilles(firstId);
		recupererQuelquesVilles(firstId); //ici à la suite
		recupererQuelquesVilles(firstId); //dans vrai projet (appels déclenchés par utilisateurs différents)
		
		/*BUG si appel à findAll() car besoin de paramétrer cache sur query
		 * 
		 *  : o.h.c.s.support.AbstractReadWriteAccess  : 
		 * Cache put-from-load [region=`AccessType[read-write]` 
		 * (com.m2i.tp.appliSpringJpa.entity.Ville), key=`com.m2i.tp.appliSpringJpa.entity.Ville#2`,
		 *  value=`CacheEntry(com.m2i.tp.appliSpringJpa.entity.Ville)`] failed due to being non-writable
		 */
	}
	
	void recupererQuelquesVilles(int firstId) {
		System.out.println("ville_1="+ daoVille.findById(firstId));
		System.out.println("ville_2="+ daoVille.findById(firstId+1));
	}
	
	
	

}

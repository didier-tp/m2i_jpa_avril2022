package com.m2i.tp.appliSpringJpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.m2i.tp.appliSpringJpa.dao.DaoEmploye;
import com.m2i.tp.appliSpringJpa.entity.Employe;

@SpringBootTest
class TestDaoEmploye {
	
	//initialise daoEmploye pour que ça référence un composant pris en charge
	//par Spring et qui est compatible avec l'interface DaoEmploye
	//dans ce projet , seule la classe DaoEmployeJpaAvecSpring correspond à ce critère
	@Autowired //injection de dépendance via Spring
	private DaoEmploye daoEmploye;

	@Test
	void testAjoutEtRecuperation() {
		Employe emp1 = new Employe(null, "prenom1", "Nom", "0102030405", "jean.Bon@xyz.com", "login", "pwd");
		Employe empl1StockeEnBase = daoEmploye.insert(emp1);
		System.out.println("empl1StockeEnBase"+empl1StockeEnBase.toString());
	}

}

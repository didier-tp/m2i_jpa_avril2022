package com.m2i.tp.appliSpringJpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.m2i.tp.appliSpringJpa.dao.DaoCompte;
import com.m2i.tp.appliSpringJpa.entity.Compte;

@SpringBootTest
class TestDaoCompte {
	

	@Autowired //injection de dépendance via Spring
	private DaoCompte daoCompte;

	@Test
	void testAjoutEtRecuperation() {
		Compte compteA = new Compte(null, "compteA", 120.0);
		Compte compteAStockeEnBase = daoCompte.insert(compteA);
		System.out.println("compteAStockeEnBase"+compteAStockeEnBase.toString());
	}

}

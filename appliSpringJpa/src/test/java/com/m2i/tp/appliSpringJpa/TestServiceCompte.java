package com.m2i.tp.appliSpringJpa;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.m2i.tp.appliSpringJpa.dao.DaoCompte;
import com.m2i.tp.appliSpringJpa.entity.Compte;
import com.m2i.tp.appliSpringJpa.service.ServiceCompte;

@SpringBootTest
class TestServiceCompte {
	
	
	@Autowired //injection de dépendance via Spring
	private ServiceCompte serviceCompte;

	@Autowired //injection de dépendance via Spring
	private DaoCompte daoCompte;

	@Test
	void testBonVirement() {
		Compte compteB = new Compte(null, "compteB", 120.0);
		Compte compteBStockeEnBase = daoCompte.insert(compteB);
		Integer idCptB = compteBStockeEnBase.getNumero();
		
		Compte compteC = new Compte(null, "compteC", 200.0);
		Compte compteCStockeEnBase = daoCompte.insert(compteC);
		Integer idCptC = compteCStockeEnBase.getNumero();
		
		serviceCompte.virement(10, idCptB, idCptC);
		
		Compte compteBReluApresVirement = daoCompte.findById(idCptB);
		Compte compteCReluApresVirement = daoCompte.findById(idCptC);
		System.out.println("compteBReluApresVirement="+compteBReluApresVirement);
		System.out.println("compteCReluApresVirement="+compteCReluApresVirement);
		//+Assertions
	}

}

package com.m2i.tp.appliSpringJpa;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.m2i.tp.appliSpringJpa.dao.DaoCompte;
import com.m2i.tp.appliSpringJpa.entity.Compte;
import com.m2i.tp.appliSpringJpa.entity.Operation;

@SpringBootTest
class TestDaoCompte {
	

	@Autowired //injection de dépendance via Spring
	private DaoCompte daoCompte;
	
	@Autowired //injection de dépendance via Spring
	private DaoOperation daoOperation;
	
	@Test
	void testCompteAvecOperations() {
		Compte compteX = new Compte(null, "compteX", 120.0);
		Compte compteXStockeEnBase = daoCompte.insert(compteX);
		System.out.println("compteXStockeEnBase"+compteXStockeEnBase.toString());
		Integer idCpt = compteXStockeEnBase.getNumero();
		
		Operation op1 = new Operation(null, "achat zz", -55.0 , new Date() , compteXStockeEnBase );
		Operation op2 = new Operation(null, "achat 2", -75.0 , new Date() , compteXStockeEnBase );
		Operation op3 = new Operation(null, "achat zz", -35.0 , new Date() , compteXStockeEnBase );
		Operation op2StockeeEnBase = daoOperation.insert(op1); //3 fois
		
		Operation op1Relu = daoOperation.findById(op2StockeeEnBase.getNumOp());
		//affiche op1Relu.getCompte().getSolde()
		
		//etape2
		//on charge le compte et on affiche les operations liées aux compte
		
	}

	@Test
	void testCRUD() {
		Compte compteA = new Compte(null, "compteA", 120.0);
		Compte compteAStockeEnBase = daoCompte.insert(compteA);
		System.out.println("compteAStockeEnBase"+compteAStockeEnBase.toString());
		Integer idCpt = compteAStockeEnBase.getNumero();
		
		List<Compte> listComptes =  daoCompte.findAll();
		System.out.println("listComptes="+listComptes);
		Assertions.assertTrue(listComptes.size()>=1);
		
		Compte cptRelu = daoCompte.findById(idCpt);
		System.out.println("cptRelu="+cptRelu);
		Assertions.assertEquals(compteA.getLabel(),cptRelu.getLabel());
		
		cptRelu.setLabel("nouveau label"); cptRelu.setSolde(140.0);
		daoCompte.update(cptRelu);
		
		Compte cptReluApresModif = daoCompte.findById(idCpt);
		System.out.println("cptReluApresModif="+cptReluApresModif);
		Assertions.assertEquals(cptReluApresModif.getSolde(),140.0,0.0001);
		
		
		daoCompte.deleteById(idCpt);
		Compte cptReluApresSuppression = daoCompte.findById(idCpt);
		System.out.println("cptReluApresSuppression="+cptReluApresSuppression);
		Assertions.assertNull(cptReluApresSuppression);
		
	}

}

package com.m2i.tp.appliSpringJpa;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.m2i.tp.appliSpringJpa.dao.DaoCompte;
import com.m2i.tp.appliSpringJpa.dao.DaoOperation;
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
		Compte compteXStockeEnBase = daoCompte.insert(new Compte(null, "compteX", 120.0));
		System.out.println("compteXStockeEnBase"+compteXStockeEnBase.toString());
		Integer idCptX = compteXStockeEnBase.getNumero();
		
		Operation op1xStockeeEnBase = daoOperation.insert(new Operation(null, "achat 1x", -55.0 , new Date() , compteXStockeEnBase )); 
		Operation op2xStockeeEnBase = daoOperation.insert(new Operation(null, "achat 2x", -75.0 , new Date() , compteXStockeEnBase )); 
		Operation op3xStockeeEnBase = daoOperation.insert(new Operation(null, "achat 3x", -35.0 , new Date() , compteXStockeEnBase ));
		
		Compte compteYStockeEnBase = daoCompte.insert(new Compte(null, "compteY", 330.0));
		System.out.println("compteYStockeEnBase"+compteYStockeEnBase.toString());
		Integer idCptY = compteYStockeEnBase.getNumero();
		
		Operation op1yStockeeEnBase = daoOperation.insert(new Operation(null, "achat 1y", -65.0 , new Date() , compteYStockeEnBase )); 
		Operation op2yStockeeEnBase = daoOperation.insert(new Operation(null, "achat 2y", -85.0 , new Date() , compteYStockeEnBase ));
		
		Operation op2xRelu = daoOperation.findById(op2xStockeeEnBase.getNumOp());
		System.out.println("solde du compte attaché à op2xStockeeEnBase : " + op2xRelu.getCompte().getSolde());
		
		Operation op2yRelu = daoOperation.findById(op2yStockeeEnBase.getNumOp());
		System.out.println("solde du compte attaché à op2yStockeeEnBase : " + op2yRelu.getCompte().getSolde());
		
		//etape2
		//on charge le compte et on affiche les operations liées aux compte
		Compte compteXRelu = daoCompte.findById(idCptX);
		System.out.println("operations attachées au compteX: " + compteXRelu.getOperations());
		
		Compte compteYRelu = daoCompte.findById(idCptY);
		System.out.println("operations attachées au compteY: " + compteYRelu.getOperations());
		
		List<Compte> compteAvecPetitsSoldes = daoCompte.findBySoldeMaxi(200.0);
		System.out.println("compteAvecPetitsSoldes="+compteAvecPetitsSoldes);
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

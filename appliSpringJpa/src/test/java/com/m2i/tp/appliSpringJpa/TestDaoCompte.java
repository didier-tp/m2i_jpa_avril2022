package com.m2i.tp.appliSpringJpa;

import java.util.List;

import org.junit.jupiter.api.Assertions;
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

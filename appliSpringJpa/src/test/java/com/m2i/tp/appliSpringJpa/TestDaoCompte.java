package com.m2i.tp.appliSpringJpa;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.m2i.tp.appliSpringJpa.dao.DaoClient;
import com.m2i.tp.appliSpringJpa.dao.DaoCompte;
import com.m2i.tp.appliSpringJpa.dao.DaoOperation;
import com.m2i.tp.appliSpringJpa.entity.Client;
import com.m2i.tp.appliSpringJpa.entity.Compte;
import com.m2i.tp.appliSpringJpa.entity.Operation;

@SpringBootTest
class TestDaoCompte {
	

	@Autowired //injection de dépendance via Spring
	private DaoCompte daoCompte;
	
	@Autowired //injection de dépendance via Spring
	private DaoOperation daoOperation;
	
	@Autowired //injection de dépendance via Spring
	private DaoClient daoClient;
	
	@Test
	void testCompteAvecOperationsV2() {
		Compte compteX = new Compte(null, "compteX", 120.0);

		Operation op1 = new Operation(null, "achat 1x", -55.0 , new Date() ); 
		Operation op2 = new Operation(null, "achat 2x", -75.0 , new Date() ); 
		compteX.addOperation(op1);
		compteX.addOperation(op2);
		Compte compteXsauvegarde = daoCompte.insert(compteX); //ça ne suffit pas pour sauvegarfer en base
		                                                      //le lien avec les operations
		                       //car coté secondaire (là ou myappedBy)
		System.out.println("compteX sauvegardé:"+compteXsauvegarde);
		
		//on sauvegarde les operations (coté principale de la relation bi-directionnelle)
		//pour que le lien entre compte et operation soit bien sauvegardé en base
		op1.setCompte(compteXsauvegarde); //quelquefois déjà fait indirecment via addOperation()
		op1.setCompte(compteXsauvegarde); //quelquefois déjà fait indirecment via addOperation()
		daoOperation.insert(op1); daoOperation.insert(op2);
		
		Compte compteXRelu = daoCompte.findCompteByIdWithOperations(compteXsauvegarde.getNumero());
		System.out.println("operations attachées au compteX: ");
		for(Operation op : compteXRelu.getOperations()) {
			System.out.println("\t"+op.toString());
		}
	}
	
	@Test
	void testCompteAvecEmployeOuClient() {
		/*coder une association @ManyToMany entre Employe et Compte
		                                    ou bien Client et Compte 
		     avec @JoinTable du coté Client ou Employe
		     et mappedBy coté Commpte
		     
		     
		     DaoEmploye à enrichir ou bien DaoClient
		     
		     
		     */
		/*
		  Créer quelques comptes
		 Créer quelques client ou employe,
		rattache , sauvegarde .
		relecture en base
		et afficher tous les comptes d'un client ou employe
		 */
		
		Compte compteC1a = daoCompte.insert(new Compte(null, "compteC1a", 120.0));
		Compte compteC2a = daoCompte.insert(new Compte(null, "compteC2a", 500.0));
		Compte compteC1b = daoCompte.insert(new Compte(null, "compteC1b", 60.0));
		Compte compteC2b = daoCompte.insert(new Compte(null, "compteC2b", 12.0));
		Compte compteCommun = daoCompte.insert(new Compte(null, "compteCommun", 420.0));
		
		Client clientA = new Client(null, "prenomCa", "nomCa");
		Client clientB = new Client(null, "prenomCb", "nomCb");
		clientA.addCompte(compteC1a); clientA.addCompte(compteC2a); clientA.addCompte(compteCommun);
		clientB.addCompte(compteC1b); clientB.addCompte(compteC2b); clientB.addCompte(compteCommun);
		Client clientAEnBase = daoClient.insert(clientA);
		Client clientBEnBase = daoClient.insert(clientB);
		
		System.out.println("comptes rattachées au clientA:" + daoCompte.findComptesByClientNumber(clientAEnBase.getNumero()));
		System.out.println("comptes rattachées au clientB:" + daoCompte.findComptesByClientNumber(clientBEnBase.getNumero()));
		
		System.out.println("clients rattachées au compteC1a:" + daoClient.findClientsByCompteNumber(compteC1a.getNumero()));
		System.out.println("clients rattachées au compteCommun:" + daoClient.findClientsByCompteNumber(compteCommun.getNumero()));
	
	}
	
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
		//Compte compteXRelu = daoCompte.findById(idCptX); //avec lazyException
		Compte compteXRelu = daoCompte.findCompteByIdWithOperations(idCptX);
		System.out.println("compteXRelu: " + compteXRelu);
		//System.out.println("operations attachées au compteX: " + compteXRelu.getOperations());
		System.out.println("operations attachées au compteX (via daoCompte): ");
		for(Operation op : compteXRelu.getOperations()) {
			System.out.println("\t"+op.toString());
		}
		
		Compte compteYRelu = daoCompte.findCompteByIdWithOperations(idCptY);
		System.out.println("operations attachées au compteY: " + compteYRelu.getOperations());
		
		List<Compte> compteAvecPetitsSoldes = daoCompte.findBySoldeMaxi(200.0);
		System.out.println("compteAvecPetitsSoldes="+compteAvecPetitsSoldes);
		
		List<Operation> listeOperationsDuCompteX = daoOperation.findOperationsByCompteNumber(idCptX);
		System.out.println("operations attachées au compteX (via daoOperation): ");
		for(Operation op : listeOperationsDuCompteX) {
			System.out.println("\t"+op.toString());
		}
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

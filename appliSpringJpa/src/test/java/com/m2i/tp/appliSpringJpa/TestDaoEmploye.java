package com.m2i.tp.appliSpringJpa;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
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
	
	private static Validator validator;  //initialized by @BeforeAll
	
	@BeforeAll
	protected static void initValidator(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	protected <T> void validateEntity(T entity) {
		Set<ConstraintViolation<T>> violations = validator.validate(entity);
		for (ConstraintViolation<T> violation : violations) {
		    //log.error("*** validation error: " + violation.getMessage()); 
			System.err.println("*** validation error: " + violation.getMessage()); 
		}
	}
	
	protected <T> void validateEntityThrowingException(T entity) {
		Set<ConstraintViolation<T>> violations = validator.validate(entity);
		StringBuilder sb = new StringBuilder();
		for (ConstraintViolation<T> violation : violations) {
		    //log.error("*** validation error: " + violation.getMessage()); 
			System.err.println("*** validation error: " + violation.getMessage()); 
			sb.append(violation.getMessage()+ " ; ");
		}
		if(violations.size()>0)
			throw new RuntimeException("entity is not valid: " + sb.toString());
	}

	@Test
	void testAjoutEtRecuperation() {
		Employe emp1 = new Employe(null, "prenom1", "Nom", "0102030405", "jean.Bon@xyz.com", "login", "pwd");
		Employe empl1StockeEnBase = daoEmploye.insert(emp1);
		System.out.println("empl1StockeEnBase"+empl1StockeEnBase.toString());
	}
	
	//@Test
	void testValidationAvecHibernateValidation() {
		Employe invalidEmp1 = new Employe(null,null,null,"0102030405","jean.BonSansArobasxyz.com","login","p");
		validateEntity(invalidEmp1);
		//validateEntityThrowingException(invalidEmp1);
		
		Employe emp1 = new Employe(null,"prenom1","Nom","0102030405","jean.Bon@xyz.com","login","pwd");
		validateEntity(emp1);
	}
	
	

}

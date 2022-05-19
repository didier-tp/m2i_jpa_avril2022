package com.m2i.tp.appliSpringJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.m2i.tp.appliSpringJpa.entity.Employe;

/*
* Version "Sans spring" :
* - pas de @PersistenceContext
* - setEntityManager
* - gestion explicite des transactions entityManager.getTransaction()....
*/

public class DaoEmployeJpaSansSpring implements DaoEmploye {
	
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
	}
	

	@Override
	public Employe findById(Integer id) {
		return entityManager.find(Employe.class, id);//.find() au sens .findByPrimaryKey()
	}

	@Override
	public List<Employe> findAll() {
		return entityManager.createQuery("SELECT e FROM Employe e",Employe.class)
				.getResultList();
	}

	@Override
	public Employe insert(Employe emp) {
		try {
			entityManager.getTransaction().begin();
			//en entrée , emp est un nouvel objet employé avec .empId à null (encore inconnu)
			//déclenche automatiquement INSERT INTO Employe(firstname, ....) VALUES(emp.getFirstname() , ....)
			entityManager.persist(emp); //INSERT INTO SQL avec aut_incr
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException("echec insertNew(employe)");
		}
		return emp;//avec .empId auto incrémenté
	}

	@Override
	public void update(Employe emp) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(emp); //UPDATE SQL
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException("echec updateEmploye(employe)");
		}
	}

	@Override
	public void deleteById(Integer id) {
		try {
			entityManager.getTransaction().begin();
			Employe empAsupprimer = entityManager.find(Employe.class, id);
			entityManager.remove(empAsupprimer);
			//déclenche automatiquement DELETE FROM Employe WHERE idEmp=code
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw new RuntimeException("echec deleteById(id)");
		}

	}

}

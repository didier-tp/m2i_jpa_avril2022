package com.m2i.tp.appliSpringJpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.m2i.tp.appliSpringJpa.dao.DaoChose;
import com.m2i.tp.appliSpringJpa.entity.Chose;

@SpringBootTest
class TestDaoChose {
	
	@Autowired
	private DaoChose daoChose;
	
	
	@Test
	void testAvecUUID() {
		System.out.println(daoChose.insert(new Chose(null,"choseXy")));
	}
	
	
	

}

package com.rcaste.nutricontrol;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.rcaste.nutricontrol.repositories.PacienteRepository;

@SpringBootTest
class NutricontrolApplicationTests {

	@Autowired
    private PacienteRepository repository;

    @PersistenceContext
    private EntityManager entityManager;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testConvertDate() {
		
	}

}

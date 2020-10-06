package com.rcaste.nutricontrol;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rcaste.nutricontrol.models.Control;
import com.rcaste.nutricontrol.repositories.ControlRepository;
import com.rcaste.nutricontrol.repositories.PacienteRepository;

@SpringBootTest
class NutricontrolApplicationTests {

	@Autowired
    private PacienteRepository repository;
	
	@Autowired
    private ControlRepository repositoryC;

    @PersistenceContext
    private EntityManager entityManager;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testGetControlesporId() {
		
		List<Control> controles = new ArrayList<Control>();
		controles= repositoryC.findByPacienteId(1);
		
		assertTrue(controles.size()>0);
		
	}

}

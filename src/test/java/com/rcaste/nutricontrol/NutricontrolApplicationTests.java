package com.rcaste.nutricontrol;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rcaste.nutricontrol.models.Control;
import com.rcaste.nutricontrol.models.Paciente;
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
		
		Optional<Paciente> p = Optional.ofNullable(new Paciente());
		p = repository.findById((long) 1);
		List<Control> controles = new ArrayList<Control>();
		controles= repositoryC.findByPacienteOrderByFechaControlDesc(p.get());
		
		assertTrue(controles.size()>0);
		
	}
	
	@Test
	void testFindByNamePac() {
		
		String name = "ona";
		List<Paciente> p = new ArrayList<>();
		p=repository.findByPacienteNombre(name.toUpperCase());
		assertTrue(p.size()>0);
		
	}

}

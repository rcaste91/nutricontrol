package com.rcaste.nutricontrol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcaste.nutricontrol.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	
	

}

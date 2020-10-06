package com.rcaste.nutricontrol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcaste.nutricontrol.models.Control;

public interface ControlRepository extends JpaRepository<Control, Long> {
	
	List<Control> findByPacienteId(int pacienteId);

}

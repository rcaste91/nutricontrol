package com.rcaste.nutricontrol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rcaste.nutricontrol.models.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	
	@Query("select s from Paciente s where UPPER(s.nombre) like %:name%")
	List<Paciente> findByPacienteNombre(@Param("name")String nombre);

}

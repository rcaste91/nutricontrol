package com.rcaste.nutricontrol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rcaste.nutricontrol.models.Control;
import com.rcaste.nutricontrol.models.Paciente;

public interface ControlRepository extends JpaRepository<Control, Long> {
	
	List<Control> findByPacienteOrderByFechaControlDesc(Paciente pac);
	
	@Query(
			value="select min(control_id) from control where paciente_id= :idpac", nativeQuery=true
			)
	Long getMinId(@Param("idpac") int idpac);
	
	List<Control> findByPacienteOrderByIdControlDesc(Paciente pac);
}

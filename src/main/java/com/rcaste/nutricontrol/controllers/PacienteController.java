package com.rcaste.nutricontrol.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rcaste.nutricontrol.models.Paciente;
import com.rcaste.nutricontrol.models.PacienteForm;
import com.rcaste.nutricontrol.repositories.PacienteRepository;

@RestController
@RequestMapping("api/v1/")
public class PacienteController {
	
	@Autowired
    private PacienteRepository repository;
	
    @PersistenceContext
    private EntityManager entityManager;
    
    
    @RequestMapping(value = "pacientes", 
            		method = RequestMethod.GET,
            		produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Paciente> getPacientes() {
    	
        List<Paciente> lista = repository.findAll();
        return lista;
    }
    
    @RequestMapping(value = "pacientes", 
    		method = RequestMethod.POST,
    		produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Paciente createPacientes(@RequestBody PacienteForm pacientesForm) {

    	Date pacienteNac = new Date();
    	
    	try {
    		pacienteNac=new SimpleDateFormat("dd-MM-yyyy").parse(pacientesForm.getFechaNacimiento());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Paciente p = new Paciente();

    	p.setNombre(pacientesForm.getNombre());
    	p.setCorreo(pacientesForm.getCorreo());
    	p.setPlanNutricional(pacientesForm.getPlanNutricional());
    	p.setFechaNacimiento(pacienteNac);
    	return repository.saveAndFlush(p);
    }

    @RequestMapping(value = "pacientes", 
    		method = RequestMethod.PUT,
    		produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Paciente updatePacientes(@RequestBody PacienteForm pacientesForm) {

    	Date pacienteNac = new Date();
    	
    	try {
    		pacienteNac=new SimpleDateFormat("dd-MM-yyyy").parse(pacientesForm.getFechaNacimiento());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	Paciente p = new Paciente();
    	p.setIdPaciente(pacientesForm.getIdPaciente());
    	p.setNombre(pacientesForm.getNombre());
    	p.setCorreo(pacientesForm.getCorreo());
    	p.setPlanNutricional(pacientesForm.getPlanNutricional());
    	p.setFechaNacimiento(pacienteNac);
    	return repository.saveAndFlush(p);
    }

    @RequestMapping(value = "/pacientes/{idPaciente}", 
            method = RequestMethod.DELETE, 
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public void deleteAlumno(@PathVariable("idPaciente") Long pacId) {
  
	 repository.deleteById(pacId);
	 
    }

}

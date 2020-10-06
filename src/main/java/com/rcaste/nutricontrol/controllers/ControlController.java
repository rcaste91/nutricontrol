package com.rcaste.nutricontrol.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rcaste.nutricontrol.models.Control;
import com.rcaste.nutricontrol.repositories.ControlRepository;

@RestController
@RequestMapping("api/v1/")
public class ControlController {
	
	@Autowired
    private ControlRepository repository;
	
    @PersistenceContext
    private EntityManager entityManager;
    
    @RequestMapping(value = "controles/{id}", 
    		method = RequestMethod.GET,
    		produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Control> getControlesPorPaciente(@PathVariable Long id){
    	
    	List<Control> controles = new ArrayList<Control>();
    	controles = repository.findByPacienteId(id.intValue());
    	return controles;
    }

}

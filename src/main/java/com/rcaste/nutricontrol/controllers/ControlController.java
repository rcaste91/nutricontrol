package com.rcaste.nutricontrol.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rcaste.nutricontrol.models.Control;
import com.rcaste.nutricontrol.models.ControlForm;
import com.rcaste.nutricontrol.models.Paciente;
import com.rcaste.nutricontrol.repositories.ControlRepository;
import com.rcaste.nutricontrol.repositories.PacienteRepository;

@RestController
@RequestMapping("api/v1/")
public class ControlController {
	
	@Autowired
    private ControlRepository repository;
	
	@Autowired
    private PacienteRepository pRepository;
	
    @PersistenceContext
    private EntityManager entityManager;
    
    @RequestMapping(value = "controles/{id}", 
    		method = RequestMethod.GET,
    		produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Control> getControlesPorPaciente(@PathVariable Long id){
    	
    	List<Control> controles = new ArrayList<Control>();
    	Optional<Paciente> p = Optional.ofNullable(new Paciente());
    	p= pRepository.findById(id);
    	controles = repository.findByPacienteOrderByFechaControlDesc(p.get());
   
    	
    	return controles;
    }
    
    @RequestMapping(value = "controlp/", 
    		method = RequestMethod.GET,
    		produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Control getPrevControl(@QueryParam("pac") Integer pac, @QueryParam("ctrl") Integer ctrl) {
    	
    	Control c = new Control();
    	Long id =repository.getMinId(pac);
    	
    	if(Long.valueOf(ctrl) == id ) {
    		c.setIdControl((long) -1);
    	}else {
    		c=findLastCtrl(pac,ctrl);
    	}
    	
    	return c;
    }
    
    @RequestMapping(value= "controles", method = RequestMethod.POST)
    @ResponseBody
    public Control createControl(@RequestBody ControlForm control) {
    	
    	Control guardar= setDatos(control);
    	
    	Control newC=repository.saveAndFlush(guardar);
    	
    	return newC;
    }
    
    private Control findLastCtrl(int pac, int ctrl) {
    	
    	Optional<Paciente> p = Optional.ofNullable(new Paciente());
    	p= pRepository.findById(Long.valueOf(pac));
    	List<Control> controles = new ArrayList<Control>();
    	controles = repository.findByPacienteOrderByIdControlDesc(p.get());
    	int i=0;
    	
    	for(Control ct : controles) {
    		
    		if (ct.getIdControl() == Long.valueOf(ctrl) ) {
    			i=controles.indexOf(ct);
    		}
    	}
    	
    	return controles.get(i+1);
    }
    
    public Control setDatos( ControlForm control) {
    	
    	Control save= new Control();
    	save.setAgua(control.getAgua());
    	save.setBrazo(control.getBrazo());
    	save.setCintura(control.getCintura());
    	save.setComentarios(control.getComentarios());
    	save.setDx(control.getDx());
    	save.setEdadMetabolica(control.getEdadMetabolica());
    	save.setEstomago(control.getEstomago());
    	save.setFechaControl(control.getFechaControl());
    	save.setGrasa(control.getGrasa());
    	save.setGrasaVisc(control.getGrasaVisc());
    	save.setImc(control.getImc());
    	save.setMasaMuscular(control.getMasaMuscular());
    	save.setMuslo(control.getMuslo());
    	save.setObservaciones(control.getObservaciones());
    	save.setPecho(control.getPecho());
    	save.setPesoTotal(control.getPesoTotal());
    	save.setVientre(control.getVientre());
    	
    	Optional<Paciente> p = pRepository.findById((long) control.getIdPaciente());
    	save.setPaciente(p.get());
    	
    	return save;
    }
    

}

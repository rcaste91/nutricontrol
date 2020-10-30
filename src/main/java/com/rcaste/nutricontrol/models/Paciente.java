package com.rcaste.nutricontrol.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pacientes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paciente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
	private Long idPaciente;
	
	@Column(name = "paciente_nombre")
	private String nombre;
	
	@Column(name = "paciente_plan_nutricional")
	private String planNutricional;
	
	@Column(name = "paciente_correo")
	private String correo;
	
	@Column(name = "paciente_fecha_nacimiento")
	private Date fechaNacimiento;
	
	@OneToMany(mappedBy = "paciente")
	@JsonIgnore
	private List<Control> controles;
	
	public Paciente() {
		
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPlanNutricional() {
		return planNutricional;
	}

	public void setPlanNutricional(String planNutricional) {
		this.planNutricional = planNutricional;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Control> getControles() {
		return controles;
	}

	public void setControles(List<Control> controles) {
		this.controles = controles;
	}

	
}

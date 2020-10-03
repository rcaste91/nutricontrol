package com.rcaste.nutricontrol.models;

import java.util.Date;

import javax.persistence.Column;

public class PacienteForm {

	private Long idPaciente;
	private String nombre;
	private String planNutricional;
	private String correo;
	private String fechaNacimiento;
	
	public PacienteForm() {
		
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
}

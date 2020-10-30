package com.rcaste.nutricontrol.models;

import java.util.Date;


public class ControlForm {

	private Long idControl;
	
	private int idPaciente;

	private Date fechaControl;

	private float pesoTotal;
	

	private float grasa;
	

	private float agua;
	
	
	private float masaMuscular;
	

	private int edadMetabolica;
	

	private float grasaVisc;
	
	
	private float imc;
	

	private float dx;
	

	private float estomago;
	

	private float cintura;
	
	private float vientre;
	
	private float pecho;
	
	private float muslo;
	
	private float brazo;
	
	private String comentarios;
	
	private String observaciones;
	
	
	public ControlForm() {
		// TODO Auto-generated constructor stub
	}


	public Long getIdControl() {
		return idControl;
	}


	public void setIdControl(Long idControl) {
		this.idControl = idControl;
	}


	public int getIdPaciente() {
		return idPaciente;
	}


	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}


	public Date getFechaControl() {
		return fechaControl;
	}


	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}


	public float getPesoTotal() {
		return pesoTotal;
	}


	public void setPesoTotal(float pesoTotal) {
		this.pesoTotal = pesoTotal;
	}


	public float getGrasa() {
		return grasa;
	}


	public void setGrasa(float grasa) {
		this.grasa = grasa;
	}


	public float getAgua() {
		return agua;
	}


	public void setAgua(float agua) {
		this.agua = agua;
	}


	public float getMasaMuscular() {
		return masaMuscular;
	}


	public void setMasaMuscular(float masaMuscular) {
		this.masaMuscular = masaMuscular;
	}


	public int getEdadMetabolica() {
		return edadMetabolica;
	}


	public void setEdadMetabolica(int edadMetabolica) {
		this.edadMetabolica = edadMetabolica;
	}


	public float getGrasaVisc() {
		return grasaVisc;
	}


	public void setGrasaVisc(float grasaVisc) {
		this.grasaVisc = grasaVisc;
	}


	public float getImc() {
		return imc;
	}


	public void setImc(float imc) {
		this.imc = imc;
	}


	public float getDx() {
		return dx;
	}


	public void setDx(float dx) {
		this.dx = dx;
	}


	public float getEstomago() {
		return estomago;
	}


	public void setEstomago(float estomago) {
		this.estomago = estomago;
	}


	public float getCintura() {
		return cintura;
	}


	public void setCintura(float cintura) {
		this.cintura = cintura;
	}


	public float getVientre() {
		return vientre;
	}


	public void setVientre(float vientre) {
		this.vientre = vientre;
	}


	public float getPecho() {
		return pecho;
	}


	public void setPecho(float pecho) {
		this.pecho = pecho;
	}


	public float getMuslo() {
		return muslo;
	}


	public void setMuslo(float muslo) {
		this.muslo = muslo;
	}


	public float getBrazo() {
		return brazo;
	}


	public void setBrazo(float brazo) {
		this.brazo = brazo;
	}


	public String getComentarios() {
		return comentarios;
	}


	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}


	public String getObservaciones() {
		return observaciones;
	}


	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}

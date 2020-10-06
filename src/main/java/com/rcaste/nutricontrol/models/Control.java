package com.rcaste.nutricontrol.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "control")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Control {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "control_id")
	private Long idControl;
	
	@Column(name = "paciente_id")
	private int pacienteId;
	
	@Column(name = "control_fecha")
	private Date fechaControl;
	
	@Column(name = "control_peso_total")
	private float pesoTotal;
	
	@Column(name = "control_grasa")
	private float grasa;
	
	@Column(name = "control_agua")
	private float agua;
	
	@Column(name = "control_musculos")
	private float masaMuscular;
	
	@Column(name = "control_edad_meta")
	private int edadMetabolica;
	
	@Column(name = "control_grasa_visc")
	private float grasaVisc;
	
	@Column(name = "control_imc")
	private float imc;
	
	@Column(name = "control_dx")
	private float dx;
	
	@Column(name = "control_estomago")
	private float estomago;
	
	@Column(name = "control_cintura")
	private float cintura;
	
	@Column(name = "control_vientre")
	private float vientre;
	
	@Column(name = "control_pecho")
	private float pecho;
	
	@Column(name = "control_muslo")
	private float muslo;
	
	@Column(name = "control_brazo")
	private float brazo;
	
	@Column(name = "control_comentarios")
	private String comentarios;
	
	@Column(name = "control_observaciones")
	private String observaciones;
	
	public Control() {
		
	}

	public Long getIdControl() {
		return idControl;
	}

	public void setIdControl(Long idControl) {
		this.idControl = idControl;
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
	
	public int getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}
	
	

}

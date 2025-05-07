package com.careassistant.services.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SolicitudCita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date fecha;
	private String hora;
	private String estado;

	private String correoPaciente;
	private String correoProfesional;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCorreoPaciente() {
		return correoPaciente;
	}

	public void setCorreoPaciente(String correoPaciente) {
		this.correoPaciente = correoPaciente;
	}

	public String getCorreoProfesional() {
		return correoProfesional;
	}

	public void setCorreoProfesional(String correoProfesional) {
		this.correoProfesional = correoProfesional;
	}

}

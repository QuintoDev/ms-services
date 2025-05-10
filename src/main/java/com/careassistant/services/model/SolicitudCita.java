package com.careassistant.services.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SolicitudCita {

	@Id
	private String id;

	private Date fecha;
	private String hora;
	private String estado;

	private String uuidPaciente;
	private String uuidProfesionalSalud;

	private String especialidad;
	private String ubicacion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getUuidPaciente() {
		return uuidPaciente;
	}

	public void setUuidPaciente(String uuidPaciente) {
		this.uuidPaciente = uuidPaciente;
	}

	public String getUuidProfesionalSalud() {
		return uuidProfesionalSalud;
	}

	public void setUuidProfesionalSalud(String uuidProfesionalSalud) {
		this.uuidProfesionalSalud = uuidProfesionalSalud;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}

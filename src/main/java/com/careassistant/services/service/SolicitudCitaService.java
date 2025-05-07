package com.careassistant.services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.careassistant.services.model.SolicitudCita;
import com.careassistant.services.repository.SolicitudCitaRepository;

@Service
public class SolicitudCitaService {

	private final SolicitudCitaRepository solicitudCitaRepository;

	public SolicitudCitaService(SolicitudCitaRepository solicitudCitaRepository) {
		super();
		this.solicitudCitaRepository = solicitudCitaRepository;
	}

	public SolicitudCita crear(SolicitudCita cita) {
		cita.setEstado("PENDIENTE");
		return solicitudCitaRepository.save(cita);
	}

	public List<SolicitudCita> buscarPorPaciente(String correo) {
		return solicitudCitaRepository.findByCorreoPaciente(correo);
	}

	public void confirmar(Long id) {
		SolicitudCita cita = solicitudCitaRepository.findById(id).orElseThrow();
		cita.setEstado("CONFIRMADA");
		solicitudCitaRepository.save(cita);
	}

	public void cancelar(Long id) {
		SolicitudCita cita = solicitudCitaRepository.findById(id).orElseThrow();
		cita.setEstado("CANCELADA");
		solicitudCitaRepository.save(cita);
	}

}

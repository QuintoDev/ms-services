package com.careassistant.services.service;

import org.springframework.stereotype.Service;

import com.careassistant.services.model.SolicitudCita;
import com.careassistant.services.repository.SolicitudCitaRepository;
import com.careassistant.services.utils.IdGeneratorUtil;

@Service
public class SolicitudCitaService {

	private final SolicitudCitaRepository solicitudCitaRepository;

	public SolicitudCitaService(SolicitudCitaRepository solicitudCitaRepository) {
		super();
		this.solicitudCitaRepository = solicitudCitaRepository;
	}

	public SolicitudCita crear(SolicitudCita cita) {
		String idGenerado = IdGeneratorUtil.generarIdCita(cita.getResumen());

		cita.setId(idGenerado);
		cita.setEstado("PENDIENTE");

		return solicitudCitaRepository.save(cita);
	}

	public void confirmar(String id) {
		SolicitudCita cita = solicitudCitaRepository.findById(id).orElseThrow();
		cita.setEstado("CONFIRMADA");
		solicitudCitaRepository.save(cita);
	}

	public void cancelar(String id) {
		SolicitudCita cita = solicitudCitaRepository.findById(id).orElseThrow();
		cita.setEstado("CANCELADA");
		solicitudCitaRepository.save(cita);
	}

}

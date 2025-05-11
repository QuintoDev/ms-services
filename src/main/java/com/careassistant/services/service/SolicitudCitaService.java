package com.careassistant.services.service;

import org.springframework.stereotype.Service;

import com.careassistant.services.model.SolicitudCita;
import com.careassistant.services.repository.SolicitudCitaRepository;
import com.careassistant.services.security.AES256Encryptor;
import com.careassistant.services.utils.IdGeneratorUtil;

@Service
public class SolicitudCitaService {

	private final SolicitudCitaRepository solicitudCitaRepository;
	private final AES256Encryptor aes;

	public SolicitudCitaService(SolicitudCitaRepository solicitudCitaRepository, AES256Encryptor aes) {
		super();
		this.solicitudCitaRepository = solicitudCitaRepository;
		this.aes = aes;
	}

	public SolicitudCita crear(SolicitudCita cita) throws Exception {
		String idGenerado = IdGeneratorUtil.generarIdCita(cita.getResumen());
		String cifrado = aes.encrypt(cita.getResumen());
		cita.setResumen(cifrado);
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

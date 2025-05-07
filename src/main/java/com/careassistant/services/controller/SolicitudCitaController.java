package com.careassistant.services.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careassistant.services.model.SolicitudCita;
import com.careassistant.services.service.SolicitudCitaService;

@RestController
@RequestMapping("/assigns")
public class SolicitudCitaController {

	private final SolicitudCitaService solicitudCitaService;

	public SolicitudCitaController(SolicitudCitaService solicitudCitaService) {
		super();
		this.solicitudCitaService = solicitudCitaService;
	}

	/**
	 * 
	 * @param cita
	 * @return
	 */
	@PostMapping
	public ResponseEntity<SolicitudCita> crear(@RequestBody SolicitudCita cita) {
		return ResponseEntity.ok(solicitudCitaService.crear(cita));
	}

	@GetMapping("{correo}/patient")
	public ResponseEntity<List<SolicitudCita>> obtenerPorPaciente(@PathVariable String correo) {
		return ResponseEntity.ok(solicitudCitaService.buscarPorPaciente(correo));
	}

	@PutMapping("{id}/confirm")
	public ResponseEntity<Void> confirmar(@PathVariable Long id) {
		solicitudCitaService.confirmar(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("{id}/cancel")
	public ResponseEntity<Void> cancelar(@PathVariable Long id) {
		solicitudCitaService.cancelar(id);
		return ResponseEntity.ok().build();
	}

}

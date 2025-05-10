package com.careassistant.services.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careassistant.services.model.SolicitudCita;
import com.careassistant.services.repository.SolicitudCitaRepository;
import com.careassistant.services.service.SolicitudCitaService;

@RestController
@RequestMapping("/appointments")
public class SolicitudCitaController {

	private final SolicitudCitaService solicitudCitaService;
	private final SolicitudCitaRepository solicitudCitaRepository;

	public SolicitudCitaController(SolicitudCitaService solicitudCitaService,
			SolicitudCitaRepository solicitudCitaRepository) {
		super();
		this.solicitudCitaService = solicitudCitaService;
		this.solicitudCitaRepository = solicitudCitaRepository;
	}

	@PostMapping
	public ResponseEntity<SolicitudCita> crear(@RequestBody SolicitudCita cita) {
		return ResponseEntity.ok(solicitudCitaService.crear(cita));
	}

	@GetMapping("{id}")
	public ResponseEntity<SolicitudCita> obtenerCitaPorId(@PathVariable String id) {
		return solicitudCitaRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping()
	public ResponseEntity<?> obtenerTodasSolicitudes() {
		List<SolicitudCita> citas = solicitudCitaRepository.findAll();
		return ResponseEntity.ok(citas);
	}

	@GetMapping("{uuid}/patient")
	public ResponseEntity<List<SolicitudCita>> obtenerPorPaciente(@PathVariable String uuid) {
		List<SolicitudCita> citas = solicitudCitaRepository.findByUuidPaciente(uuid);
		return ResponseEntity.ok(citas);
	}

	@GetMapping("{uuid}/professional")
	public ResponseEntity<List<SolicitudCita>> obtenerPorProfesional(@PathVariable String uuid) {
		List<SolicitudCita> citas = solicitudCitaRepository.findByUuidProfesionalSalud(uuid);
		return ResponseEntity.ok(citas);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable String id) {
		Optional<SolicitudCita> citas = solicitudCitaRepository.findById(id);
		if (citas.isPresent()) {
			solicitudCitaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("{id}/confirm")
	public ResponseEntity<Void> confirmar(@PathVariable String id) {
		solicitudCitaService.confirmar(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("{id}/cancel")
	public ResponseEntity<Void> cancelar(@PathVariable String id) {
		return ResponseEntity.ok().build();
	}

}

package com.careassistant.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.careassistant.services.model.SolicitudCita;

@Repository
public interface SolicitudCitaRepository extends JpaRepository<SolicitudCita, Long> {

	List<SolicitudCita> findByCorreoPaciente(String correo);

}

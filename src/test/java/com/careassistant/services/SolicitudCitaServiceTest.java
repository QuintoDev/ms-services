package com.careassistant.services;

import com.careassistant.services.model.SolicitudCita;
import com.careassistant.services.repository.SolicitudCitaRepository;
import com.careassistant.services.service.SolicitudCitaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SolicitudCitaServiceTest {

    @Autowired
    private SolicitudCitaService solicitudCitaService;

    @Autowired
    private SolicitudCitaRepository solicitudCitaRepository;

    @Test
    void testCrearCita() throws Exception {
        SolicitudCita cita = new SolicitudCita();
        cita.setFecha(new Date());
        cita.setHora("10:30");
        cita.setUuidPaciente("11111111-aaaa-bbbb-cccc-123456789000");
        cita.setUuidProfesionalSalud("22222222-aaaa-bbbb-cccc-123456789000");
        cita.setResumen("Atención postoperatoria en domicilio");
        cita.setUbicacion("Cra 45 #32-10, Bogotá");

        SolicitudCita creada = solicitudCitaService.crear(cita);

        assertNotNull(creada);
        assertNotNull(creada.getId());
        assertEquals("PENDIENTE", creada.getEstado());

        // Validaciones adicionales
        assertNotEquals("Atención postoperatoria en domicilio", creada.getResumen());
        assertEquals("11111111-aaaa-bbbb-cccc-123456789000", creada.getUuidPaciente());
        assertEquals("22222222-aaaa-bbbb-cccc-123456789000", creada.getUuidProfesionalSalud());

        // Limpieza opcional
        solicitudCitaRepository.deleteById(creada.getId());
    }

    @Test
    void testConfirmarCita() throws Exception {
        // Crear cita base
        SolicitudCita cita = new SolicitudCita();
        cita.setFecha(new Date());
        cita.setHora("11:00");
        cita.setUuidPaciente("11111111-aaaa-bbbb-cccc-123456789111");
        cita.setUuidProfesionalSalud("22222222-aaaa-bbbb-cccc-123456789111");
        cita.setResumen("Visita domiciliaria para control post operatorio");
        cita.setUbicacion("Av. 19 #102-20, Cali");

        SolicitudCita creada = solicitudCitaService.crear(cita);
        String id = creada.getId();

        // Confirmar
        solicitudCitaService.confirmar(id);
        SolicitudCita confirmada = solicitudCitaRepository.findById(id).orElseThrow();

        assertEquals("CONFIRMADA", confirmada.getEstado());

        solicitudCitaRepository.deleteById(id);
    }

    @Test
    void testCancelarCita() throws Exception {
        // Crear cita base
        SolicitudCita cita = new SolicitudCita();
        cita.setFecha(new Date());
        cita.setHora("12:00");
        cita.setUuidPaciente("11111111-aaaa-bbbb-cccc-123456789222");
        cita.setUuidProfesionalSalud("22222222-aaaa-bbbb-cccc-123456789222");
        cita.setResumen("Cita para valoración funcional");
        cita.setUbicacion("Carrera 8 #60-20, Bucaramanga");

        SolicitudCita creada = solicitudCitaService.crear(cita);
        String id = creada.getId();

        // Cancelar
        solicitudCitaService.cancelar(id);
        SolicitudCita cancelada = solicitudCitaRepository.findById(id).orElseThrow();

        assertEquals("CANCELADA", cancelada.getEstado());

        solicitudCitaRepository.deleteById(id);
    }
}

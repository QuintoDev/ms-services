package com.careassistant.services.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class IdGeneratorUtil {

	public static String generarIdCita(String especialidad) {
		try {
			long timestamp = System.currentTimeMillis();
			String raw = "CARE-" + timestamp + "-" + especialidad;

			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = digest.digest(raw.getBytes());

			String encoded = Base64.getUrlEncoder().withoutPadding().encodeToString(hashBytes);
			return "CARE-" + encoded.substring(0, 12).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error generando hash para ID de cita", e);
		}
	}
}

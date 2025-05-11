package com.careassistant.services.security;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class AES256Encryptor {

	@Value("${aes.key}")
	private String base64Key;

	private SecretKey secretKey;

	@PostConstruct
	public void init() {
		byte[] decodedKey = Base64.getDecoder().decode(base64Key);
		this.secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
	}

	public String encrypt(String plainText) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
		return Base64.getEncoder().encodeToString(encrypted);
	}

}

package com.kasun.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kasun.dto.LoginRequest;
import com.kasun.dto.LoginResponse;
import com.kasun.repository.TokenRepo;
import com.kasun.repository.UserRepo;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UserRepo userRepo;

	@Autowired
	TokenRepo tokenRepo;

	@PostMapping("/login")
	public LoginResponse login(LoginRequest req,
			@RequestHeader(name = "Authorization", required = false) String token) {
		System.out.println("inside login ");
		LoginResponse res = new LoginResponse();
		tokenRepo.validateToken(token);

		if (!userRepo.getUserMap().containsKey(req.getUserId())) {
			res.setStatusCode("09");
			res.setError("User Not found.");
		} else {
			if (genHash(req.getPassword()).equalsIgnoreCase(userRepo.getUserMap().get(req.getUserId()))) {
				res.setStatusCode("00");
				res.setError("Logni Successful");
				res.setToken("275c773f42a0b83461bcc00f9c983420e124b34b50b1fae0da872b183127370b");
			} else {
				res.setStatusCode("09");
				res.setError("Password Incorrect.");
			}
		}

		return res;
	}

	public static String genHash(String input) {
		MessageDigest digest;
		String hash = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");

			byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

			hash = bytesToHex(encodedhash);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return hash;

	}

	private static String bytesToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder(2 * hash.length);
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
}

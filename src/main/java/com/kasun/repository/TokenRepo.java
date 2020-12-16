package com.kasun.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class TokenRepo {
	private Map<String, String> appTokenMap = new HashMap<>();

	public TokenRepo() {
		appTokenMap.put("metro", "123456");
		appTokenMap.put("zcash", "111222");
	}

	public boolean validateToken(String token) {

		if (token == null || token.isEmpty()) {
			throw new RuntimeException("Empty Token");
		}

		String appId = token.split("\\|")[0];
		String appToken = token.split("\\|")[1];
		System.out.println(appId + "   " + appToken);

		if (appTokenMap.get(appId).equals(appToken)) {
			return true;
		} else {
			throw new RuntimeException("Invalid Token");
		}

	}

	public String getChannel(String token) {

		if (token == null || token.isEmpty()) {
			throw new RuntimeException("Empty Token");
		}

		String appId = token.split("\\|")[0];

		return appId.toUpperCase();

	}

}

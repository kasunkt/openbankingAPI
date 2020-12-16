package com.kasun.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {

	private Map<String,String> userMap=new HashMap<>();
	
	public Map<String, String> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<String, String> userMap) {
		this.userMap = userMap;
	}

	public UserRepo()
	{
		userMap.put("KASADMIN", "275c773f42a0b83461bcc00f9c983420e124b34b50b1fae0da872b183127370b"); //ib123
		userMap.put("DEMOONE", "275c773f42a0b83461bcc00f9c983420e124b34b50b1fae0da872b183127370b");
		userMap.put("DEMOTWO", "275c773f42a0b83461bcc00f9c983420e124b34b50b1fae0da872b183127370b");
	}	
	
	//3d27d3aefb14b3149de59ccd31fec94ed51ac99a2be7e1556b7b94c39dbf3d1a		//PassworD2.
}

package com.kasun.ath;

import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//https://stackoverflow.com/questions/58499410/how-to-generate-client-id-client-secret-in-spring-boot-and-store-in-database
@RestController
@RequestMapping("/app")
public class AppController {
	//@Autowired
	//JdbcClientDetailsService jdbcClientDetailsService;
	
	@PostMapping("/create")
	public String createApp() 
	{
		String companyId="";
		String resourceIds="";
		String scopes="";
		String grantTypes="";
		String authorities="";
		
		BaseClientDetails clientDetails = new BaseClientDetails(companyId, resourceIds, scopes, grantTypes, authorities);
		clientDetails.setClientSecret("generatedpassword");
		//jdbcClientDetailsService.addClientDetails(clientDetails);
		return "app created";
	}
}

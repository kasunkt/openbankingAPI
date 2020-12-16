package com.kasun.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;
@ApiIgnore
@RestController
@RequestMapping("/login/oauth2/code/google")
public class ServiceController {
	
	@GetMapping("/test")
	public String test()
	{
		 
		System.out.println("/test called " );
		 
		return "test here " ;
	}
	
	@GetMapping("/welcome")
	public String welcome()
	{
		 
		System.out.println("/welcome called " );
		 
		return "welcome here " ;
	}
	
	 
}

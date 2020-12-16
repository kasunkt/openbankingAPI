package com.kasun.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/demo")
public class TestController {
	
	@GetMapping("/hello")
	public String hello() 
	{
		System.out.println("helo");
		return "hello";
	}
	
	@PostMapping("/hello")
	public String puthello() 
	{
		System.out.println("helo");
		return "post hello";
	}

}

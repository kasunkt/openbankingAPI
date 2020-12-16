package com.kasun.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class WebController {

	@GetMapping("/index2")
	public String test() {

		System.out.println("///// called ");

		return "index2";
	}

}

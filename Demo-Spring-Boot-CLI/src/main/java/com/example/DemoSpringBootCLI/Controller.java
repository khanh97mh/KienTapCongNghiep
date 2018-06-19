package com.example.DemoSpringBootCLI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@RequestMapping("/")
	public String hello() {
		return "Tạo Spring Boot project bằng Spring Boot CLI!";
	}
}

package com.tma.tlab.api.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello!";
	}

}

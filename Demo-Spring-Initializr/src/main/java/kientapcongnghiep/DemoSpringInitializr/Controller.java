package kientapcongnghiep.DemoSpringInitializr;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class Controller {
	@RequestMapping("/")
	public String hello() {
		return "Tạo Spring Boot project bằng Spring Initializr Web!";
	}
}

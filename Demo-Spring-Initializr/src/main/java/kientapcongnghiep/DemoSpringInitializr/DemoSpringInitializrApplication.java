package kientapcongnghiep.DemoSpringInitializr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@SpringBootApplication
@Configuration 
@EnableAutoConfiguration 
@Import ({Controller.class})
public class DemoSpringInitializrApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringInitializrApplication.class, args);
	}
}

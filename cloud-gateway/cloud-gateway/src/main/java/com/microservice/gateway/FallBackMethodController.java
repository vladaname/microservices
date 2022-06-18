package com.microservice.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
	
	@GetMapping("/userServiceFallBack")
	public String userServiceFallBackMethod() {
		return "User Service is tajking longer then expected." + 
	"Please try again later";
	}
	
	@GetMapping("/departmentServiceFallBack")
	public String departmentServiceFallBackMethod() {
		return "Department Service is tajking longer then expected." + 
	"Please try again later";
	}
	
	@GetMapping("/teacherServiceFallBack")
	public String teacherServiceFallBackMethod() {
		return "Teacher Service is tajking longer then expected." + 
	"Please try again later";
	}

}

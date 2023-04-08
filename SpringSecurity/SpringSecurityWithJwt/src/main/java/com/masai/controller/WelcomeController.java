package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Employee;
import com.masai.repo.EmployeeRepo;

@RestController
@RequestMapping("/masai")
public class WelcomeController {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome() {

		return new ResponseEntity<String>("Welcome to Masai App without security", HttpStatus.ACCEPTED);
	}

	@GetMapping("/welcomeP")
	public ResponseEntity<String> welcomeP() {

		return new ResponseEntity<String>("Welcome to Masai App with security", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Employee> registerEmplopyee(@RequestBody Employee employee){
		employee.setPassword(encoder.encode(employee.getPassword()));
		employee.setRole("ROLE_"+employee.getRole().toUpperCase());
		
		Employee emp = employeeRepo.save(employee);
		
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@GetMapping("/signIn")
	public ResponseEntity<Employee> signInCon(Authentication auth){
		Employee emp = employeeRepo.findByUserName(auth.getName()).orElseThrow(()->new BadCredentialsException("Invalid Credential"));
		
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}

	// This method can only accessed by admin..
	@GetMapping("/admin")
	public ResponseEntity<String> admin() {

		return new ResponseEntity<String>("Welcome to Masai App for Admin", HttpStatus.ACCEPTED);
	}

}

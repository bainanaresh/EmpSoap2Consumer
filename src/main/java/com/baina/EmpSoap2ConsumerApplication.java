package com.baina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.soap.api.clint.SoapClinet;
import com.javatechie.spring.soap.api.loaneligibility.Employee;
import com.javatechie.spring.soap.api.loaneligibility.EmployeeDetails;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = "com.*")
public class EmpSoap2ConsumerApplication {
	
	@Autowired(required = true)
	private SoapClinet clint;

	public static void main(String[] args) {
		SpringApplication.run(EmpSoap2ConsumerApplication.class, args);
	}
	
	@GetMapping("/aa")
	public String getdet() {
		return "welcome to java";
	}
	
	@PostMapping("/getEmpStatus")
	public EmployeeDetails getDetails(@RequestBody Employee emp) {
		System.out.println(emp.getName());
		return clint.getEmpDetails(emp);
	}

}

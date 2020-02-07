package com.javatechie.spring.soap.api.clint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.javatechie.spring.soap.api.loaneligibility.Employee;
import com.javatechie.spring.soap.api.loaneligibility.EmployeeDetails;

@Service
public class SoapClinet {

	@Autowired(required = true)
	private Jaxb2Marshaller marshaller;

	private WebServiceTemplate template;

	public EmployeeDetails getEmpDetails(Employee request) {
		template = new WebServiceTemplate(marshaller);
		EmployeeDetails details = (EmployeeDetails) template.marshalSendAndReceive("http://localhost:8080/ws",
				request);
		System.out.println(details);
		return details;
	}

}

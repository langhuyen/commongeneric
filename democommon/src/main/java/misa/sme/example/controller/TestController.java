package misa.sme.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import misa.sme.example.model.EmployeeEntity;
import misa.sme.example.repository.EmployeeRepository;

@RestController
public class TestController {

	@Autowired
	EmployeeRepository employRepository;
	
	@RequestMapping("/test")
	public List<EmployeeEntity> getList(){
		return employRepository.findAll();
	}
}

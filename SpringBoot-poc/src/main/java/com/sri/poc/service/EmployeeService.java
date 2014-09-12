package com.sri.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.poc.bean.Employee;
import com.sri.poc.dao.EmployeeRepository;

/**
 * 
 * @author ganesh.vallabhaneni
 *
 */
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public Employee save(Employee employee){
		return employeeRepo. save(employee);
	}
	
	public List<Employee> findAll(){
		return employeeRepo.findAll();
	}
}

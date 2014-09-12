package com.sri.poc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.poc.bean.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

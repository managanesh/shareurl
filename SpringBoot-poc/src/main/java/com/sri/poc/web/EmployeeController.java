package com.sri.poc.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sri.poc.bean.Employee;
import com.sri.poc.service.EmployeeService;



@Controller
@RequestMapping("/emp")
public class EmployeeController {
	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private EmployeeService employeeService;
	
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
	            //The date format to parse or output your dates
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	            //Create a new CustomDateEditor
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	            //Register it as custom editor for the Date type
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(ModelMap model){
				model.addAttribute("employee", new Employee());
				log.info("returning empty form:");
		return "employee";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String register(@ModelAttribute("employee")Employee employee,BindingResult result){
		log.info("employee.name"+employee.getBirthDate());
		employee = employeeService.save(employee);
		return "employee";
	}
	
	@ModelAttribute("employeeList")
	public List<Employee> getAllEmployees(){
		return employeeService.findAll();
	}
	

}

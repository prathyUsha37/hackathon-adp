package com.adp.hackathon.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adp.hackathon.service.EmployeeService;
import com.adp.hackathon.model.Employee;
import com.adp.hackathon.model.Login;
import com.adp.hackathon.model.ResetPassword;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
public class EmployeeController {	
	
	EmployeeService employeeSerive;
	
	
	@Autowired(required=true)
	EmployeeController(EmployeeService employeeSerive){
		this.employeeSerive=employeeSerive;
	}

	
	@RequestMapping(value = "/employee/login", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public Employee login(@RequestBody Login login) {
		System.out.println(login.getId());
		System.out.println(login.getPassword());
		Employee employee= this.employeeSerive.getEmployeeById(Long.parseLong(login.getId()));
   	    if(employee.getPassword().contentEquals(login.getPassword())) {
			return employee;
	    }
		return null;
	}
	
	
	@RequestMapping(value = "employee/reset_password", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public Employee reset_password(@PathVariable("id") Long id,@RequestBody ResetPassword resetPassword) {
		Employee employee= this.employeeSerive.getEmployeeById(Long.parseLong(resetPassword.getId()));
		if(employee.getEmail().contentEquals(resetPassword.getEmail())) {
			employee.setPassword(resetPassword.getPassword());
			this.employeeSerive.updateEmployee(employee);
			return employee;
		}
		return null;
	}
	
	
	@RequestMapping(value = "/employee/create", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeSerive.createEmployee(employee);
	}


	@RequestMapping(value="/employee/remove/{id}", method = RequestMethod.DELETE,
			headers = "Accept=application/json")
	@ResponseBody
    public String removeEmployee(@PathVariable("id") Long id){	
        if(this.employeeSerive.removeEmployee(id)) {
        	return "Employee removed";
        }
        return "Invalid request";
    }
 
	
	
    @RequestMapping(value="/employee/update",method = RequestMethod.PUT,
			headers = "Accept=application/json")
    public String updateEmployee(@RequestBody Employee employee){
    	if(this.employeeSerive.updateEmployee(employee)) {
        	return "Employee updated";
        }
        return "Invalid request";
    }

    
    
    @RequestMapping(value="/employee/all",method = RequestMethod.GET,
			headers = "Accept=application/json")
    @ResponseBody
    public List<Employee> listEmployees(){
    	List<Employee> employees= this.employeeSerive.listEmployees();
        return employees;
    }
	
    
    
    @RequestMapping(value="/employee/{id}",method = RequestMethod.GET,
			headers = "Accept=application/json")
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") Long id){
    	Employee employee= this.employeeSerive.getEmployeeById(id);
        return employee;
    }
	
}


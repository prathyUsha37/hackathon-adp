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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Login{
	private String id;
	private String password;
	Login(){
		
	}
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", password=" + password + "]";
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
class ResetPassword{
	private String id;
	private String email;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ResetPassword [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
}


@RestController
@CrossOrigin
public class EmployeeController {	
	
	EmployeeService employeeSerive;
	
	
	@Autowired(required=true)
	EmployeeController(EmployeeService employeeSerive){
		this.employeeSerive=employeeSerive;
		authPayload.put("username", "admin");
	}
	
	Map<String,String> authPayload = new HashMap<String,String>();

	
	@RequestMapping(value = "/login", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public Employee login(@RequestBody Login login) {
		System.out.println(login.getId());
		System.out.println(login.getPassword());
//		employee.setEmail("91619Prathyusha@gmail.com");
//		employee.setId(1111L);
//	employee.setImage("data:image/jpeg;base64,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");
//	employee.setManagerId(2334L);
//		employee.setName("prathyusha");
//		employee.setType("Employee Admin");
//		employee.setPassword("123cbksdjbvh");
		Employee employee= this.employeeSerive.getEmployeeById(Long.parseLong(login.getId()));
   	if(employee.getPassword().contentEquals(login.getPassword())) {
			return employee;
	}
		return employee;
	}
	
	
	@RequestMapping(value = "/reset_password", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public Employee reset_password(@PathVariable("id") Long id,@RequestBody ResetPassword resetPassword) {
		Employee employee= this.employeeSerive.getEmployeeById(Long.parseLong(resetPassword.getId()));
		if(employee.getEmail().contentEquals(resetPassword.getEmail())) {
			employee.setPassword(resetPassword.getPassword());
			this.employeeSerive.updateEmployee(employee.getId(), employee);
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


	@RequestMapping(value="employee/remove/{id}", method = RequestMethod.DELETE,
			headers = "Accept=application/json")
	@ResponseBody
    public String removeEmployee(@PathVariable("id") Long id){	
        if(this.employeeSerive.removeEmployee(id)) {
        	return "Employee removed";
        }
        return "Invalid request";
    }
 
	
	
    @RequestMapping(value="employee/update/{id}",method = RequestMethod.PUT,
			headers = "Accept=application/json")
    public void updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
    	this.employeeSerive.updateEmployee(id, employee);
    }

    
    
    @RequestMapping(value="employee/all",method = RequestMethod.GET,
			headers = "Accept=application/json")
    @ResponseBody
    public List<Employee> listEmployees(){
    	List<Employee> employees= this.employeeSerive.listEmployees();
        return employees;
    }
	
    
    
    @RequestMapping(value="employee/{id}",method = RequestMethod.GET,
			headers = "Accept=application/json")
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") Long id){
    	Employee employee= this.employeeSerive.getEmployeeById(id);
        return employee;
    }
	
	
}


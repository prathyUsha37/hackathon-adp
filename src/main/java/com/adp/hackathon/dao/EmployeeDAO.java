package com.adp.hackathon.dao;

import java.util.List;
import com.adp.hackathon.model.Employee;


public interface EmployeeDAO {
	public boolean isIdExists(Long id);
	public boolean isEmailExists(String emailId);
	public Employee createEmployee(Employee e);
	public void updateEmployee(Employee e);
	public List<Employee> listEmployees();
	public Employee getEmployeeById(Long id);
	public Employee getEmployeeByEmail(String Email);
	public void removeEmployee(Long id);	
	public String getType(Long id);
}

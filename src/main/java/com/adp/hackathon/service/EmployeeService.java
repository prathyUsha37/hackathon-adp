package com.adp.hackathon.service;
import java.util.List;

import com.adp.hackathon.model.Employee;

public interface EmployeeService{
	public Employee createEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean removeEmployee(Long id);
	public Employee getEmployeeById(Long id);
	public Employee getEmployeeByEmail(String email);	
	public List<Employee> listEmployees();
}

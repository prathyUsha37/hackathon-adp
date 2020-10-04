package com.adp.hackathon.service;
import java.util.List;

import com.adp.hackathon.model.Employee;

public interface EmployeeService{
	public Employee createEmployee(Employee employee);
	public void updateEmployee(Long id, Employee employee);
	public List<Employee> listEmployees();
	public Employee getEmployeeById(Long id);
	public boolean removeEmployee(Long id);
	public Employee getEmployeeByEmail(String email);	
}

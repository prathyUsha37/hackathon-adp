package com.adp.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adp.hackathon.dao.EmployeeDAO;
import com.adp.hackathon.model.Employee;


@Repository
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
			Employee employ=this.employeeDAO.createEmployee(employee);
			return employ;
	}

	@Override
	@Transactional
	public boolean updateEmployee(Employee employee) {
		if(this.employeeDAO.isIdExists(employee.getId())) {
			this.employeeDAO.updateEmployee(employee);
			return true;
		}
		return false;
	}
	

	@Override
	@Transactional
	public boolean removeEmployee(Long id) {
	if(this.employeeDAO.isIdExists(id)) {
		this.employeeDAO.removeEmployee(id);
		return true;
		}
	return false;
	}
	

	@Override
	@Transactional
	public Employee getEmployeeById(Long id) {
		return this.employeeDAO.getEmployeeById(id);
	}

	
	@Override
	public Employee getEmployeeByEmail(String email) {
		return this.employeeDAO.getEmployeeByEmail(email);
	}
	
	@Override
	@Transactional
	public List<Employee> listEmployees() {
		return this.employeeDAO.listEmployees();
	}

}

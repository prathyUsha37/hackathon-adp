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
	public void updateEmployee(Long id,Employee employee) {
		if(this.employeeDAO.isIdExists(id)) {
			this.employeeDAO.updateEmployee(employee);
		}
	}
	

	@Override
	@Transactional
	public List<Employee> listEmployees() {
		return this.employeeDAO.listEmployees();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(Long id) {
		return this.employeeDAO.getEmployeeById(id);
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
	public Employee getEmployeeByEmail(String email) {
		return this.employeeDAO.getEmployeeByEmail(email);
	}

}

package com.ems.service;

import java.util.List;

import com.ems.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
		
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(int id);
	
	void deleteEmployeeById(int id);
}

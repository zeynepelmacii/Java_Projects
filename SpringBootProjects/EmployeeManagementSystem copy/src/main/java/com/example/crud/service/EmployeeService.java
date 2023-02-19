package com.example.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.Employee;
import com.example.crud.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
      List<Employee> employees = new ArrayList<Employee>();
      employeeRepository.findAll().forEach(employee -> employees.add(employee)); //bulduğun her employee listeye ekle
      return employees;
	}
	
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id).get();
	}
	
	public List<Employee> getAllByFirstName(String name) {
		return employeeRepository.findByFirstName(name);
	}
	
	public List<Employee> getAllByLastName(String lastName) {
		return employeeRepository.findByLastName(lastName);
	}

	public Employee addNewEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

	public Employee updateEmployeeById(Employee employeeDetails, long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		employeeRepository.save(employee);
		
		return employee;
	}
}

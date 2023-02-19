package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Employee;
import com.example.crud.service.EmployeeService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	
	//getAllEmployees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	//get employee by id
	@GetMapping("/employees/id/{id}")
	public Employee getEmployeeByID(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}

	//get employees by first name
	@GetMapping(value="/employees/firstname/{firstName}")
	public List<Employee> getAllByFirstName(@PathVariable String firstName) {
		return employeeService.getAllByFirstName(firstName);
	}
	
	//get employees by last name
	@GetMapping(value="/employees/lastname/{lastName}")
	public List<Employee> getAllByLastName(@PathVariable String lastName) {
		return employeeService.getAllByLastName(lastName);
	}
	
	
	//add new employee
	@PostMapping("employees/post")
	public Employee addNewEmployee(@RequestBody Employee employee) {
		return employeeService.addNewEmployee(employee);
	}
	
	@DeleteMapping(value = "/employees/delete/{id}")
	@Transactional
	public void deleteEmployeeByID(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
	}
	
	@PutMapping("/employees/update/{id}")
   public Employee updateEmployeeById(@RequestBody Employee employee, @PathVariable long id) {
		return employeeService.updateEmployeeById(employee, id);
   }	
	
}

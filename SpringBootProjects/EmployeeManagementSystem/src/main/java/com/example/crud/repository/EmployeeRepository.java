package com.example.crud.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.model.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findByFirstName(String firstName);
	List<Employee> findByLastName(String lastName);
	Employee deleteEmployeeById(Long id);
}

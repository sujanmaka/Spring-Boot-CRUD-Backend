package com.sukuldhoka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sukuldhoka.dao.EmployeeRepo;
import com.sukuldhoka.dao.RoleRepo;
import com.sukuldhoka.model.Employee;
import com.sukuldhoka.model.Role;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	public List<Employee> getAllEmployee() {
		return (List<Employee>)	employeeRepo.findAll();
	}
	
	public void addEmployee(Employee employee) {
		employeeRepo.save(employee);
	}
	
	public Optional<Employee> getSingleEmployee(Long id) {
		return employeeRepo.findById(id);
	}
	
	public void updateEmployee(Long id, Employee employee) {
		employeeRepo.save(employee);
	}
	
	public void deleteEmployee(Long id) {
		employeeRepo.deleteById(id);
	}
	
	public Employee findByEmployeeName(String name) {
		return employeeRepo.findByEmpName(name);
	}
	
	public List<Role> getAllRole() {
			return (List<Role>) roleRepo.findAll();
	}
}

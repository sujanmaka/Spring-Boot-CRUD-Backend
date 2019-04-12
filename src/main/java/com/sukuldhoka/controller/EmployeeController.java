package com.sukuldhoka.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sukuldhoka.model.Employee;
import com.sukuldhoka.model.Role;
import com.sukuldhoka.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/employees")
	public List<Employee> getEmployee() {
		return (List<Employee>) employeeService.getAllEmployee();
		 
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employees")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	@RequestMapping("/employees/{id}")
	public Optional<Employee> getSingleEmployee(@PathVariable Long id) {
		return employeeService.getSingleEmployee(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/employees/{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
		employeeService.updateEmployee(id, employee);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/employees/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
	}
	
	@RequestMapping("/employees/name/{name}")
	public Employee findByEmpName(@PathVariable String name) {
		return employeeService.findByEmployeeName(name);
	}
	
	@RequestMapping("/employees/role")
	public List<Role> getRoles() {
		return (List<Role>) employeeService.getAllRole();
	}
 	

}

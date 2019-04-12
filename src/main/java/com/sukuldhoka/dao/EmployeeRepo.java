package com.sukuldhoka.dao;

import org.springframework.data.repository.CrudRepository;

import com.sukuldhoka.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {
	public Employee findByEmpName(String name);
}

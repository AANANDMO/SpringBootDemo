package com.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import com.employeemanagement.entity.Employee;

public interface EmployeeService {

	public abstract void addEmployee(Employee employee);

	public abstract void updateEmployee(Employee employee);

	public abstract void removeEmployee(int empId);

	public abstract Optional<Employee> findEmployeeById(int eid);

	public abstract List<Employee> listEmployee();

	public List<Employee> getAllInBetween(int initialSal, int salary);
}

package com.employeemanagement.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.dao.EmployeeDao;
import com.employeemanagement.entity.Employee;



@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;
	@Override
	public void addEmployee(Employee emp) {
		dao.save(emp);//persist()
	}
	@Override
	public void updateEmployee(Employee emp) {
		dao.save(emp);
	}
	@Override
	public void removeEmployee(int empId) {
		dao.deleteById(empId);
	}
	@Override
	public Optional<Employee> findEmployeeById(int eid) {
		// no need of transaction, as it's an read operation
		Optional<Employee> emp = dao.findById(eid);//124
		return emp;
	}
	@Override
	public List<Employee> listEmployee() {
		// TODO Auto-generated method stub
		List<Employee> l1 = dao.findAll();
		return l1;
	}
	@Override
	public List<Employee> getAllInBetween(int initialSal,int salary) {
		
		return dao.getAllInBetween(initialSal, salary);
	}
}
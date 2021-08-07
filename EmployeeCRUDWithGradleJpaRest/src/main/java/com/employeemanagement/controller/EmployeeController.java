package com.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.exceptions.EmployeeNotFoundException;
import com.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employeeManagement")
public class EmployeeController {
	@Autowired
	EmployeeService serviceobj;

	// Create Employee //http://localhost:8586/employeeManagement/EmployeeCreation
	@PostMapping("/EmployeeCreation") //
	public ResponseEntity<String> EmployeeCreation(@Validated @RequestBody Employee emp) {
		serviceobj.addEmployee(emp);
		return new ResponseEntity<String>("Employee Added successfully", new HttpHeaders(), HttpStatus.OK);
	}

	// Get Particular Employee Data
	@GetMapping("/GetEmployee/{id}") // http://localhost:8586/employeeManagement/getEmployee/123
	private Employee getEmployee(@PathVariable("id") int id) throws EmployeeNotFoundException {
		Optional<Employee> e = serviceobj.findEmployeeById(id);
		if(e.isPresent())
			return e.get();
		else
			 throw new EmployeeNotFoundException("Employee not found with given id") ;
	}

	// Get All Employees Data
	@GetMapping("/GetAllEmployees") // http://localhost:8586:/employees/GetAllEmployees
	private ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> emplist = serviceobj.listEmployee();
		return new ResponseEntity<List<Employee>>(emplist, new HttpHeaders(), HttpStatus.OK);

	}

	// Updating Employee data
	@PutMapping("/UpdateEmployee")

	public ResponseEntity<String> UpdateEmployee(@Validated @RequestBody Employee emp) {
		serviceobj.updateEmployee(emp);
		return new ResponseEntity<String>("Updated Successfully", new HttpHeaders(), HttpStatus.OK);
	}

	// Deleting Employee
	@DeleteMapping("/DeleteEmployee/{id}")
	private ResponseEntity<String> delEmp(@PathVariable("id") int id) {
		serviceobj.removeEmployee(id);
		return new ResponseEntity<String>("employee deleted successfully", new HttpHeaders(), HttpStatus.OK);
	}
	@GetMapping("/GetAllEmployeesInBetween/{IntialSal}/{salary}") // http://localhost:8586:/employees/GetAllEmployees
	private ResponseEntity<List<Employee>> getAllEmployeeInBetween(@PathVariable("IntialSal") int intialSal,@PathVariable("salary") int salary) {
		List<Employee> emplist = serviceobj.getAllInBetween(intialSal,salary);
		return new ResponseEntity<List<Employee>>(emplist, new HttpHeaders(), HttpStatus.OK);

	}
}

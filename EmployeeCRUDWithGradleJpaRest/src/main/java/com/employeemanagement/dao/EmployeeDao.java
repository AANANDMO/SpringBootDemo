package com.employeemanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employeemanagement.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
@Query("select e from Employee e where esal between ?1 and ?2")
public List<Employee> getAllInBetween(int initialSal,int salary);

}
//fetch all student byname
//fetch students by marks inbetween
//....
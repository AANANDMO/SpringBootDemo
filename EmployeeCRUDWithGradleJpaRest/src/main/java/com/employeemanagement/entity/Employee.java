package com.employeemanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "emp_info")
public class Employee {
	@Id
	@GeneratedValue
	@Column(length = 12)
	private int eid;
	@Column(length = 12)
	@NotBlank(message = "Name is mandatory")
	@NotNull(message="name as null not allowed ")
	//@Min(value=6,message="name length must be above 6")
	private String ename;
	@Positive(message="Enter valid salary")
	@Min(value=10000,message="Salary must be above 10000")
	private Integer esal;
	@Column(length = 12)
	private String city;

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEsal() {
		return esal;
	}

	public void setEsal(int esal) {
		this.esal = esal;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
}

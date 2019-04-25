package misa.sme.example.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import misa.sme.example.common.Col;
import misa.sme.example.common.ID;
import misa.sme.example.common.Model;

@Model
public class EmployeeEntity {
	@Col
	private String employeeID;
	@Col
	private String codeEmployee;
	@Col
	private String name;

	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getCodeEmployee() {
		return codeEmployee;
	}
	public void setCodeEmployee(String codeEmployee) {
		this.codeEmployee = codeEmployee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}

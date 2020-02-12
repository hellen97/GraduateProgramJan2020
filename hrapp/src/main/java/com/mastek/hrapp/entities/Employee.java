package com.mastek.hrapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.springframework.data.annotation.Transient;


@Entity // declares the class as entity, to be managed by JPA
@Table(name="JPA_Employees") // declares the table name associated with this class
@EntityListeners({EmployeeListener.class})//call the appropriate listener event method on lifecycle event 
@NamedQueries({
	@NamedQuery(name="Employee.findBySalary",//declare the query name as the method in DAO
			query="select e from Employee e where e.salary between :minSalary and :maxSalary")
			//identify the query to fetch employee objects with properties and parameters
			//all the params are to be declared using @Param("<name>") in the DAO interface
	,
	@NamedQuery(name="Employee.findByDesignation",
				query="select e from Employee e where e.designation= :designation")
		//identify query method in DAO and pass the necessary params
})
public class Employee {
	
	int empno; 
	String name;			// This is the only thing that is typed. the rest are generated 
	double salary;
	Designation designation;
	
	
	Department currentDepartment;
	
	
	@ManyToOne//one Employee is asscociated with one of the many Departments 
	@JoinColumn(name="Fk_department_number")// the foreign key column to store the associate deptno
	@Transient//ignore this property when storing employee data in MongoDB
	public Department getCurrentDepartment() {
		return currentDepartment;
	}

	public void setCurrentDepartment(Department currentDepartment) {
		this.currentDepartment = currentDepartment;
	}
	
	Set<Project> projectsAssigned = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL)//configure many to many association for entities 
	@JoinTable(name="JPA_PROJECT_ASSIGNMENTS",//provide the join table name 
				joinColumns= {@JoinColumn(name="fk_empno")},//foreign key column for current class
				inverseJoinColumns= {@JoinColumn(name="fk_projectId")}//foreign key column for collection
	)
	@Transient//ignore this property when stroing employee data in MongoDB
	
	public Set<Project> getProjectsAssigned() {
		return projectsAssigned;
	}

	public void setProjectsAssigned(Set<Project> projectsAssigned) {
		this.projectsAssigned = projectsAssigned;
	}

	public Employee() {
		
	}
	
	@Id // marking the property as primary key for the table 
	@Column(name = "employee_number")//using column to provide the default column name
	@GeneratedValue(strategy=GenerationType.AUTO)//AUTO numbering configuration as per DB
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}
	@Column(name="employee_name", length=50,nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Enumerated(EnumType.STRING)
	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", salary=" + salary + ", designation=" + designation
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empno != other.empno)
			return false;
		return true;
	}
	
	

}

// @Transient: to mark the property get method, not to be stored in DB table 
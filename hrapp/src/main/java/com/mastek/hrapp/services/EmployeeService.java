package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.dao.DepartmemtJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.Project;

	@Component // do not give space between annotation and target
	@Scope("singleton")
	public class EmployeeService {
	
		String exampleProperty;
		
		@Autowired
		EmployeeJPADAO empDAO;
		
		@Autowired
		DepartmemtJPADAO deptDAO;
		
		@Autowired
		ProjectJPADAO projectDAO;

	
		public EmployeeService() {
			System.out.println("Enployee Service Created");
			
}
	@PostConstruct
	public void initializeService() {
			System.out.println("Employee Service Initialized");
}

	@PreDestroy
	public void terminateService() {
		  System.out.println("Employee Service Terminated");
			

}
	public void exampleMethod() {
			System.out.println("Connect to "+getExampleProperty()+" for business data");
		
}
	public String getExampleProperty() {
			return exampleProperty;
		
}
	@Value ("Spring Example Data Source")
	public void setExampleProperty(String exampleProperty) {
		System.out.println("Example property set:"+exampleProperty );
			this.exampleProperty=exampleProperty;
		}
	@Transactional//this will keep the session open until the method return the value 
	public Employee assignEmployeeToDepartment(int empno, int deptno) {
		Employee emp = empDAO.findById(empno).get();//fetch the employee if exists
		Department dept= deptDAO.findById(deptno).get();//fetch department if exists
		
		//assign the association between employee and department 
		emp.setCurrentDepartment(dept);//assign the department to employee
		dept.getTeam().add(emp);// add the employee in the department team 
		
		//save the changes in database 
		empDAO.save(emp);
		deptDAO.save(dept);
		
		return emp;//return the result 
	}
	@Transactional
	public Employee assignEmployeeToProject(int empno, int projectId) {
		Employee emp = empDAO.findById(empno).get();
		Project newProject = projectDAO.findById(projectId).get();
		
		emp.getProjectsAssigned().add(newProject);
		empDAO.save(emp);
		
		return emp;
	}
}

package com.mastek.hrapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmemtJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.services.EmployeeService;

@SpringBootTest // do not give space between annotation and target
class HrappApplicationTests {
	
	@Autowired//Spring will provide the object using IOC, dependency Injection technique
	EmployeeService empSvc;
	
	@Autowired  
	EmployeeService empSvc1;
	
	@Autowired
	EmployeeJPADAO empDAO;
	
	@Autowired
	DepartmemtJPADAO deptDAO;
	
	@Autowired
	ProjectJPADAO projectDAO;

	@Test
	void testEmployeeExampleMethod() {
		empSvc.exampleMethod();
		empSvc1.exampleMethod();
	}
	@Test
	void testEmployeeDAOAdd() {
		Employee emp = new Employee();
		emp.setName("New Emp");
		emp.setSalary(2334);
		emp.setDesignation(Designation.MANAGER);
		
		emp = empDAO.save(emp);
		
		System.out.println(emp);
		assertNotNull(emp, "Employee Not Added");
	}
	@Test
	void testListEmployees() {
		Iterable <Employee> emps = empDAO.findAll();
		assertNotNull(emps, "Employees not Found");
		for (Employee employee: emps) {
			System.out.println(employee);
		}
	}
	@Test 
	void testUpdateEmployees() {
		Employee emp=empDAO.findById(1).get();
		System.out.println("Employee Fetched"+emp);
		
		emp.setSalary(emp.getSalary()+1001);
		emp.setDesignation(Designation.TESTER);
		
		emp = empDAO.save(emp);
		
		System.out.println("Updated Employee:"+emp);
		
	}
	@Test
	void testDeleteEmployeeId() {
		//empDAO.delete(emp); deletes by object
		empDAO.deleteById(5);//deletes by ID
		
	}
	@Test
	   void testDepartmentDAOadd() {
	      Department dept = new Department();
	      dept.setName("Admin");
	      dept.setLocation("UK");
	      dept= deptDAO.save(dept);
	   
	        System.out.println(dept);
	        assertNotNull(dept,"Department Not Added");
	    }
	   
	    @Test
	    void testProjectDAOadd() {
	        Project pro = new Project();
	        pro.setName("NHS");
	        pro.setCustomerName("UK");
	        pro = projectDAO.save(pro);
	       
	        System.out.println(pro);
	        assertNotNull(pro,"Project Not Added");
	    }
	    @Test
	    void testAssignEmployeeToDepartment() {
	    Employee emp= empSvc.assignEmployeeToDepartment(7,13);
	    	assertNotNull(emp.getCurrentDepartment(),"Department Not Assigned");
	    }
	    @Test
	    void testAssignEmployeeToProject(){
	    	Employee emp= empSvc.assignEmployeeToProject(11,26);
	    			assertTrue(emp.getProjectsAssigned().size()>0,"Projects assigned");
	    }
}
	   
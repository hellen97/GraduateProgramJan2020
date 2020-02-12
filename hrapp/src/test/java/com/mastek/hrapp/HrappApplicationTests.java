package com.mastek.hrapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mastek.hrapp.dao.DepartmemtJPADAO;
import com.mastek.hrapp.dao.EmployeeJPADAO;
import com.mastek.hrapp.dao.JobPositionsDAO;
import com.mastek.hrapp.dao.PaymentJPADAO;
import com.mastek.hrapp.dao.ProjectJPADAO;
import com.mastek.hrapp.entities.CardPayment;
import com.mastek.hrapp.entities.ChequePayment;
import com.mastek.hrapp.entities.Department;
import com.mastek.hrapp.entities.Designation;
import com.mastek.hrapp.entities.Employee;
import com.mastek.hrapp.entities.JobPosition;
import com.mastek.hrapp.entities.Payement;
import com.mastek.hrapp.entities.Project;
import com.mastek.hrapp.services.EmployeeService;

@SpringBootTest // do not give space between annotation and target
class HrappApplicationTests {
	
	@Autowired
	JobPositionsDAO jobDAO;
	
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

	@Autowired
	PaymentJPADAO paymentDAO;
	
	@Test
	void testFindEmployeesBySalary(){
		double minSalary=100.0;
		double maxSalary=5000.0;
								//empDAO.findBySalary(minSalary,maxSalry)
		Iterable<Employee> emps= empDAO.findBySalary(minSalary,maxSalary);
		
		System.out.println("All Employees having salary between min:"+minSalary+ 
				"and max:"+maxSalary);
		
		for (Employee employee : emps) {
			System.out.println(employee);
		}
		
	}
	@Test
	void testFindEmployeesByDesignation() {
		Iterable<Employee> emps = empDAO.findByDesignation(Designation.MANAGER);
		System.out.println("All Employees with Designation as "+Designation.MANAGER);
		
		for (Employee employee : emps) {
			System.out.println(employee);
			
		}
		
	}
	@Test
	void testCashPaymentAdd() {
		Payement cashP = new Payement();
		cashP.setAmount(100);
		
		cashP= paymentDAO.save(cashP);
		
		System.out.println(cashP);
		assertNotNull(cashP,"Cash Payment Not Saved");
	}
	@Test
	void testCardPaymentAdd() {
		CardPayment cardP = new CardPayment();
		cardP.setAmount(2300);
		cardP.setCardNumber(1123456809);
		cardP.setCardService("VISA");
		
		cardP = paymentDAO.save(cardP);
		System.out.println(cardP);
		assertNotNull(cardP,"Card Payment not saved");
		
	}
	@Test
	void testChequePaymentAdd() {
		ChequePayment cheqP = new ChequePayment();
		cheqP.setAmount(444);
		cheqP.setBankName("RBS");
		cheqP.setChequeNumber(12345);
		
		cheqP = paymentDAO.save(cheqP);
		System.out.println(cheqP);
		assertNotNull(cheqP,"Cheque Payament not saved");
	}
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
		//empDAO.deleteById(5);//deletes by ID
		
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
	    @Test
	    void testAddJobPositionDocument() {
	    	JobPosition jp = new JobPosition();
	    	jp.setJobId(135);
	    	jp.setLocation("LEEDS");
	    	jp.setClientName("NHS");
	    	jp.setSkillsRequired("Java");
	    	jp.setNumberOfPositions(3);
	    	
	    	jp = jobDAO.save(jp);
	    	
	    	assertNotNull(jp, "Job Positions Not Saved");
	    }
	    @Test
	    void testListAllJobPositions() {
	    	System.out.println("Print All Job Positions");
	    	for (JobPosition jp : jobDAO.findAll()) {
	    		System.out.println(jp);
	    	}
	    
	    }	
	    @Test
	    void testApplyForJobPosition() {
	    	int jobId=122;
	    	int empno = 2;
	    	JobPosition jp = empSvc.applyForJobPosition(122, 6);
	    	
	    	assertNotNull (jp, "Job not Applied");
	    	
	    	for (Employee applicant : jp.getGetApplicants()) {
	    		System.out.println(applicant);
	    	}
	    }
}
	   
package com.mastek.training.tests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mastek.training.hrapp.Announcement;
import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.EmailAnnouncment;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mastek.training.hrapp.SMSAnnouncement;
import com.mastek.training.hrapp.SalesEmployee;
import com.mastek.training.pack1.Circle;
import com.mastek.training.pack1.Rectangle;
import com.mastek.training.pack1.Shape;



class HRApplicationTests {
	
	Employee ex1;
	
	@BeforeEach
	public void setupEmpTestCases() {
		System.out.println("Before TEst case");
		//Employee.DEFAULT_ZERO;  // <Class_Name>.<static_Member> 
		ex1 = new Employee(); 
		ex1.setEmpno(1002);
		ex1.setName("Example");
		ex1.setUnitDaySalary(300);
		ex1.setDesignation(Designations.MANAGER);
		ex1.setGrade(Grades.G8);
		
		Employee ex2 = new Employee(1122);
		
		Employee ex3 = new Employee(2233,"Example",344.0,Designations.DEVELOPER);
		
		ex2=null;// release the object to mark as garbage
		ex3=null;
		System.gc(); // notify System to collect Garbage
		//ex2.getEmpno(); will throw NullPointerException
	}
	
	@AfterEach
	public void tearDownEmpTestCases() {
		System.out.println("After Test Case");
	}	


	@Test
	void testCreateAndPrintExampleEmployeeObject() {
			System.out.println("Test Case Create");
			System.out.println(
					"Number: "+ex1.getEmpno()+
					"\nName: "+ex1.getName()+
					"\nDay Salary: "+ex1.getUnitDaySalary()+
					"\nDesignation: "+ex1.getDesignation()+
					"\nGrade: "+ex1.getGrade());
	}
	
	@Test
	void testCreateAndComputeSalaryEmployeeObject() {
		System.out.println("Test Case Compute");
		try {
			assertEquals(9000.0,ex1.getNetSalary(30),"Invalid Net Salary Computation");
			assertEquals(0,ex1.getNetSalary(-30),"Invalid Net Salary Computation");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testSalesEmployeeObjectUsage() {
		SalesEmployee saleEx1 = new SalesEmployee();
		saleEx1.setEmpno(224);
		saleEx1.setName("Example");
		saleEx1.setUnitDaySalary(100);
		saleEx1.setDesignation(Designations.OFFICER);
		saleEx1.setGrade(Grades.G8);
		saleEx1.setComission(0.8);
		saleEx1.setTarget(1000000000);
		
		try {
			assertEquals(1620,saleEx1.getNetSalary(9),"Invalid Salary calculated");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testObjectFeaturesOnEmployee() {
		System.out.println("<====Object Features Start ====>");
		
		System.out.println(ex1.toString());
		System.out.println("HashCode: "+ex1.hashCode());
		
		System.out.println("<====Object Features End====>");
	}
	@Test
	void testSendAnnouncementToEmployees() {
		//we can not create an object of abstract class using new keyword
		//Announcement exAnnouncement = new Annoucement();
		
		//To use an abstratct class object you must extend it with derived class 
		//and overide ALL abstraxt methods defined in base/parent class 
		Announcement exSMS = new SMSAnnouncement();
		exSMS.setFrom("UK-HR");
		exSMS.setForGroup("MASTEKEER_AT_GLASGOW");
		exSMS.setSubject("Inclement Weather Conditions at Glasgow");
		exSMS.setContentText("All Employees are advised to opt to Work From Home, tomorrow" );
		
		Announcement exEmail = new EmailAnnouncment();
		exEmail.setFrom("Leadership Team");
		exEmail.setForGroup("MASTEKEERS");
		exEmail.setSubject("QMEET JAN 2020");
		exEmail.setContentText("You all are invited to attend the Quarterly Meet Online via WEBEX");
		
		if (exSMS instanceof EmailAnnouncment) {
			System.out.println("Connect to Email Service");
		exSMS.sendAnnouncement();//CONNET TO sms and use to send from smsannouncement 
		}
		
		exEmail.sendAnnouncement();// connect to email and use send from smsannouncement
		assertTrue (exSMS instanceof SMSAnnouncement, "Invalid Announcement Implementation");
		assertTrue(exEmail instanceof EmailAnnouncment, "Invalid Announcement Implementation");
	}
		
	@Test
	void testShapeExample() {
		Rectangle rect = new Rectangle();
		rect.setLength (10);
		rect.setBreadth (20);
		
		Circle circle = new Circle ();
		circle.setRadius(20);
		
		Shape shRect = rect;
		Shape shCircle = circle;
		
		System.out.println("Rectangle Area:"+shRect.getArea());
		System.out.println("Rectangle Perimeter:"+shRect.getPerimeter());
		
		System.out.println("Circle Area: "+shCircle.getArea());
		System.out.println("Circle Perimeter:"+shCircle.getPerimeter());
		
		assertTrue(rect instanceof Shape,"Invalid Type of Shape");
		assertTrue(circle instanceof Shape, "Invalid Type of Shape");
	}

}
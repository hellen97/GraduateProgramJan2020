package com.mastek.training.hrapp;

//Each class specifies their base/parent class name using extends keyword
//If the class does not have extends keyword it is by default inheriting java.lang.object
public class SalesEmployee extends Employee {

	private long target;
	private double commission;
	
	public SalesEmployee() {
		//system.out.println("Example")
		//use super keyword to call the base class consructor from the child/derived class
		//super constuctor call must be the first line in the constructor 
		super (7777,"SalesExample",99,Designations.OFFICER);
		System.out.println("Sales Employee Created");
	}
	
	//Method Overriding 
	//we write the same method available in base class in child class with different or 
	//additional logic for processing the result
	@Override
	public double getNetSalary(int noOfDays) throws Exception{
		return super.getNetSalary(noOfDays)+(super.getNetSalary(noOfDays)*getComission());
	}
	
	public long getTarget() {
		return target;
	}
	public void setTarget(long target) {
		this.target = target;
	}
	public double getComission() {
		return commission;
	}
	public void setComission(double comission) {
		this.commission = comission;
	}
}

package com.mastek.training.pack1;

//a class can inherit from interface implements keyword
//one class can implement more than one interfaces 
//interfaces use the class object for implementing its behaviours 
//hence it is used freqently as it effectively saves additional number of objects created 
public class Rectangle implements Shape{
	
	private int length;
	private int breadth;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	//override all methods from implemented interface 
	@Override
	public double getArea() {
		return getLength()*getBreadth();
		
	}
	@Override
	public double getPerimeter() {
		return 2*(getLength()+getBreadth());
		
	}
	

}

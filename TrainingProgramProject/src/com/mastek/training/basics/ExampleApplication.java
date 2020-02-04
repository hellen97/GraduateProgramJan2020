package com.mastek.training.basics;

public class ExampleApplication {
	
	public static void main(String[] args) {
		int maxResult=0;
		
		maxResult =SelectionProvider.getMaxNumber(10, 2);
		System.out.println("Max Result is "+maxResult);
		
		maxResult =SelectionProvider.getMaxNumber(10, 10);
		System.out.println("Max Result is "+maxResult);
		
		maxResult =SelectionProvider.getMaxNumber(-110, -2);
		System.out.println("Max Result is "+maxResult);
		

	
	}
}

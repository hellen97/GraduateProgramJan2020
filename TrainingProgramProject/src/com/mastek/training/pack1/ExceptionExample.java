package com.mastek.training.pack1;

import java.util.Scanner;

public class ExceptionExample {
	
	public static void main(String[] args) {
		int num1,num2,result=0;
	
		Scanner sc = new Scanner (System.in);
		
		
		try {
			System.out.println("Enter num1: ");
			num1 =Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter num2: ");
			num2=Integer.parseInt(sc.nextLine());
			
			result =num1/num2;
			
			System.out.println("Division is:"+result);
		} catch (NumberFormatException e) {//handle specific scenarios of exceptions
			e.printStackTrace();//print the exception informaton on the console
			System.err.println("Invalid Number Entered");
		}
		catch(Exception ex) {//handles all types of exceptions
			System.err.println("Exception Occured: "+ex);//handles all types of exceptions
			System.err.println("Exception Message: "+ex.getMessage());//print the message
			ex.printStackTrace();//print the complete information about exception::stack trace
		}
		finally {//block will be executed in all the scenarios of success or failure of apllication
			//in case the exception is not handled, it will abort the application after the finally block
			System.out.println("Scanner Closed");
			sc.close();
		
		}
		//represents the rest of code
		System.out.println("Program Completed");
		
	}

}

package com.mastek.training.basics;

public class SelectionProvider {
	/*
	 * take two numbers from the user and display the maximum number as output 
	 * 
	 */
	//public static <return-datatype> <name>(<param_type1> <param_name1>,...)
	public static int getMaxNumber (int num1, int num2) {//declare inputs as params
		int max= 0;// declare output as local variable 
		if (num1>num2) {//validate the conditions for logical result 
			max=num1;
		} else {
			max=num2;

		}
		return max;//return the result to the caller 
		
	}

	public static String getQuotientAndRemainder(int num1, int num2) {
		int quotient=0, remainder=0;
		quotient=num1/num2;
		remainder=num1%num2;
	//	System.out.println(quotient+","+ remainder);
		return quotient+","+ remainder;
	}
	 //Write an algorithm and code for accepting distance in kilometers, convert it into miles and display the result
	public static double getMilesFromKilometers (double distanceInKilometers) {
		double distanceInMiles=0;
		distanceInMiles= distanceInKilometers/1.6;
		System.out.println( distanceInMiles);
		return distanceInMiles;
		
	}
	
	//Write an algorithm and code for calculating the area of rectangle
	public static int getAreaOfRectangle (int length, int width) {
		int area=0;
		area=length*width;
		System.out.println(area);
		return area;
	}
	// Write an algorithm and code to calculate the time taken for the journey and display the same.
	public static double getTimeTakenForJourney (int distance, int speed) {
		double timeTakenInMinutes=0;
		timeTakenInMinutes= distance/speed;
		System.out.println(timeTakenInMinutes);
		return timeTakenInMinutes;
	}
	//Write a code for accepting radius and calculate the area of the circle.
	public static double getAreaOfCircle (int radius) {
		double area = Math.PI*(radius*radius);
		System.out.println(area);
		return area;
	}
   //Write a code for accepting a number and display the multiplication table of the given number.
	public static int getMultiplicationTable (int num1, int num2) {
		int multiplication = num1* num2;
		System.out.println(multiplication);
		return multiplication;
	}
	//	 Write a code for accepting three numbers and display the lowest number out of three numbers.
	public static int getLowestNumber (int num1, int num2, int num3) {
		int LowestNumber = 0;
		if (num1>num2)
			LowestNumber = num2;
		if (num2>num3)
			LowestNumber=num3;
		if (num1>num3)
			LowestNumber=num3;
		System.out.println(LowestNumber);
		return LowestNumber;
	}
}

package com.mastek.training.pack1;

public class AnotherClass {
	
	public static void main (String[] args) {
		SimpleClass sc1 = new SimpleClass();
		//in the derived class, of same package we can access all the types of members of the class
		//except private members 
		System.out.println(
				//"private:"+sc1.privateNumber+
				"\nDefualt:"+sc1.defaultNumber+
				"\nProtected:"+sc1.protectedNumber+
				"\npublic:"+sc1.publicNumber);
	}

}

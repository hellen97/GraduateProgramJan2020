package com.mastek.training.pack1;

class DerivedClass extends SimpleClass {
	public static void main (String[] args) {
		DerivedClass sc1 = new DerivedClass();
		//in the same class we can access all the types of members of the class
		System.out.println(
				//"private:"+sc1.privateNumber+
				"\nDefualt:"+sc1.defaultNumber+
				"\nProtected:"+sc1.protectedNumber+
				"\npublic:"+sc1.publicNumber);
	}

}

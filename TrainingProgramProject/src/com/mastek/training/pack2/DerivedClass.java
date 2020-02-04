package com.mastek.training.pack2;

import com.mastek.training.pack1.SimpleClass;

class DerivedClass extends SimpleClass {
	public static void main (String[] args) {
		DerivedClass sc1 = new DerivedClass();
		//in the derived class we can access public and protected members of the class 
		//we cannot acess private and default members of the class
		System.out.println(
				//"private:"+sc1.privateNumber+
				//"\nDefualt:"+sc1.defaultNumber+
				"\nProtected:"+sc1.protectedNumber+
				"\npublic:"+sc1.publicNumber);
	}

} 

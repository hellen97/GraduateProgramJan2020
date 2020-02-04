package com.mastek.training.pack2;

import com.mastek.training.pack1.SimpleClass;

public class AnotherClass {
	
	public static void main (String[] args) {
		SimpleClass sc1 = new SimpleClass();
		//in the derived class, of another package we can only access public of members of the class
		//except private members 
		System.out.println(
				//"private:"+sc1.privateNumber+
				//"\nDefualt:"+sc1.defaultNumber+
				//"\nProtected:"+sc1.protectedNumber+
				"\npublic:"+sc1.publicNumber);
	}

}

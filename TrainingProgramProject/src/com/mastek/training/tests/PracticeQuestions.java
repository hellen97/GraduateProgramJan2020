package com.mastek.training.tests;

public class PracticeQuestions {
	class Parent {
		public final void helloWorld() {
			System.out.println("Base::show()called");
		}
		class child extends Parent{
			public void helloWorld1 () {
				System.out.println("Derved::show()called");
			}
		}
		public class Main{
			public void main(String[] args) {
				Parent c = new child();
				c.helloWorld();
			}
		}
				
				
			}
		
	}
			
	
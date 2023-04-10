package com.masai.demo1;

@FunctionalInterface
interface Intr {
	void sayHello(String name);
}

class IntrImpl implements Intr {
	public void sayHello(String name) {
		System.out.println("Welcome " + name);
	}
}

class test {
	public static void main(String[] args) {
		Intr i1 = new IntrImpl();
		i1.sayHello("Admin");
	}
}

//Overall, functional interfaces provide a powerful way to define and pass behavior in Java.
//They can be used in a wide variety of contexts, 
//from simple arithmetic calculations to complex data processing pipelines.
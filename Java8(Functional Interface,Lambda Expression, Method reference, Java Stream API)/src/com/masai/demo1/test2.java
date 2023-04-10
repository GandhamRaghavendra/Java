package com.masai.demo1;

interface MyFunctionalInterface {
    void doSomething();
}

// Here we are implementing FI using Anonymous_Inner class;

// Anonymous_Inner:- it is a class that defined and instantiated at the same time without a name..!

public class test2 {	
    public static void main(String[] args) {
        MyFunctionalInterface obj = new MyFunctionalInterface() {
        	@Override
            public void doSomething() {
                System.out.println("Something is being done!");
            }
        };
        obj.doSomething(); // prints "Something is being done!"
    }
}


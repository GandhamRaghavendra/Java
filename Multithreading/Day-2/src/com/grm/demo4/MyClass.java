package com.grm.demo4;
public class MyClass {
    private int count = 0;
    private final Object lock = new Object();

    public void incrementCount() {
        synchronized (lock) { // synchronized block to obtain lock on the lock object
            count++;
        }
    }
    
    public int getCount() {
		return count;
	}
}

class Main {
    public static void main(String[] args) {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                myClass1.incrementCount();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
            	myClass2.incrementCount();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int c= myClass1.getCount()+myClass2.getCount();
        
        System.out.println("Count: " + c); // should output 200000
    }
}

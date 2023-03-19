package com.grm.demo3;

// synchronized block to get a object level lock of the same class..!!

public class MyClass {
    private int count = 0;

    public void incrementCount() {
        synchronized (this) { 
        	// synchronized block to obtain lock on this object
            count++;
        }
    }

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
    
}

class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                myClass.incrementCount();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                myClass.incrementCount();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();// Here main thread will wait till thread1 complete execution..
            thread2.join();// same as above case..
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + myClass.getCount()); // should output 200000
    }
}

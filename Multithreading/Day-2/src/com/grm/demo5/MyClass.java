package com.grm.demo5;

//synchronized block to get a class level lock ..!!
public class MyClass {
	private static int count = 0;

	public static void incrementCount() {
		synchronized (MyClass.class) {
			count++;
		}
	}

	public static int getCount() {
		return count;
	}
}

class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                MyClass.incrementCount();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                MyClass.incrementCount();
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

        System.out.println("Count: " + MyClass.getCount()); // should output 200000
    }
}

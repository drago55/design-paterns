package main.creational_design_pattern.singleton;

public class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance;
	private ThreadSafeSingleton() {}
	
	public static synchronized ThreadSafeSingleton getInstance() {
		if (instance== null) {
			instance = new  ThreadSafeSingleton();
			System.out.println("This is a thread safe singleton example"); // Display the string.
		}
		return instance;
	}
	 
}

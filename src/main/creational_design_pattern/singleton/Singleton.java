package main.creational_design_pattern.singleton;


/*
 * Singleton is one of  
 * Gangs of Four design patterns and comes 
 * in the category of Creational Design patterns
 */

public class Singleton {

	private static final Singleton instance = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		System.out.println("This is singleton example"); // Display the string.
		return instance;
	}

}

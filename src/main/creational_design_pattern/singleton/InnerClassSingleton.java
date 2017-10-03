package main.creational_design_pattern.singleton;

public class InnerClassSingleton {
	
	private InnerClassSingleton () {}
	private static class SingletonHelper{
		
		private static final InnerClassSingleton INSTANCE = new  InnerClassSingleton();
		
	}
	public static InnerClassSingleton getInstance() {
		System.out.println("This is innerClassSingleton example"); // Display the string.
		return SingletonHelper.INSTANCE;
		
	}

	}

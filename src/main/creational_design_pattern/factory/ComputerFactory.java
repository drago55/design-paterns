package main.creational_design_pattern.factory;

public class ComputerFactory {
	
	/*
	 * This class is used to construct Computer object in first example we are passing type and object properties
	 *  then we are checking which type of object to construct.
	 *  In a second example we are passing factory object and calling create method in this example we need to have factory class for every type of object
	 *  
	 * */
	
	public static Computer getComputer(String type, String ram, String hdd, String cpu) {

		if ("PC".equalsIgnoreCase(type))
			return new PC(ram, hdd, cpu);
		else if ("Server".equalsIgnoreCase(type))
			return new Server(ram, hdd, cpu);
		return null;
	}

	public static Computer getAbstractFactoryComputer(ComputerAbstractFactory factory) {

		return factory.createComputer();
	}

}

package main;

import main.creational_design_pattern.factory.Computer;
import main.creational_design_pattern.factory.ComputerAbstractFactory;
import main.creational_design_pattern.factory.ComputerFactory;
import main.creational_design_pattern.factory.ServerFactory;
import main.singleton.InnerClassSingleton;
import main.singleton.Singleton;
import main.singleton.ThreadSafeSingleton;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello World!"); // Display the string.
		showSingletonExamples();
		testFactory();
	}

	private static void showSingletonExamples() {
		Singleton.getInstance();
		ThreadSafeSingleton.getInstance();
		InnerClassSingleton.getInstance();

	}

	private static void testFactory() {
		Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.1GHz");
		Computer server = ComputerFactory.getComputer("server", "16GB", "2TB", "3.0 GHz");
		
		System.out.println("Factory PC Config:: " + pc);
		System.out.println("Factory server config::" + server);

	}
	private static void testAbstractFactory() {
		
		Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500 GB", "2.1GHz");
		Computer server = ServerFactory.getComputer("server", "16GB", "2TB", "3.0 GHz");
		
		System.out.println("Factory PC Config:: " + pc);
		System.out.println("Factory server config::" + server);

	}

}

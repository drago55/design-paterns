package main;

import main.creational_design_pattern.builder.ComputerPaternBuilder;
import main.creational_design_pattern.factory.Computer;
import main.creational_design_pattern.factory.ComputerFactory;
import main.creational_design_pattern.factory.PCFactory;
import main.creational_design_pattern.factory.ServerFactory;
import main.creational_design_pattern.singleton.InnerClassSingleton;
import main.creational_design_pattern.singleton.Singleton;
import main.creational_design_pattern.singleton.ThreadSafeSingleton;
import main.structural_design_patterns.adapter.TestAdapter;

public class Main {

	public static void main(String[] args) {

		System.out.println("Hello World!"); // Display the string.
		showSingletonExamples();
		testFactory();
		testAbstractFactory();
		testAdapter();

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

		Computer pc = ComputerFactory.getAbstractFactoryComputer(new PCFactory("2 GB", "500 GB", "2.1GHz"));
		Computer server = ComputerFactory.getAbstractFactoryComputer(new ServerFactory("16GB", "2TB", "3.0 GHz"));

		System.out.println("AbstractFactory PC Config:: " + pc);
		System.out.println("AbstractFactory server config::" + server);

	}

	// we are showing how to construct object with builder pattern
	private static void testBuilder() {
		ComputerPaternBuilder comp = new ComputerPaternBuilder.ComputerBuilder("500GB", "2 GB")
				.setBluetoothEnabled(true).setGraphicsCardEnabled(true).build();
	}

	private static void testAdapter() {
		// Adapter pattern is one of the structural design pattern and its used so that
		// two unrelated interfaces can work together.
		// The object that join this unrelated interface is called an Adapter
		TestAdapter.testClassAdapter();
		TestAdapter.testObjectAdapter();
	}

}

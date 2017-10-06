package main;

import java.awt.Color;
import java.sql.Connection;

import main.creational_design_pattern.builder.ComputerPaternBuilder;
import main.creational_design_pattern.factory.Computer;
import main.creational_design_pattern.factory.ComputerFactory;
import main.creational_design_pattern.factory.PCFactory;
import main.creational_design_pattern.factory.ServerFactory;
import main.creational_design_pattern.singleton.InnerClassSingleton;
import main.creational_design_pattern.singleton.Singleton;
import main.creational_design_pattern.singleton.ThreadSafeSingleton;
import main.structural_design_patterns.adapter.TestAdapter;
import main.structural_design_patterns.bridge.GreenColor;
import main.structural_design_patterns.bridge.Pentagon;
import main.structural_design_patterns.bridge.RedColor;
import main.structural_design_patterns.bridge.Shape;
import main.structural_design_patterns.bridge.Triangle;
import main.structural_design_patterns.composit.TestComposit;
import main.structural_design_patterns.facade.HelperFacade;
import main.structural_design_patterns.facade.MySqlHelper;
import main.structural_design_patterns.facade.OracleHelper;
import main.structural_design_patterns.flyweight.DrawingClient;
import main.structural_design_patterns.proxy.ProxyPatternTest;

public class Main {

	static DrawingClient draw;

	public static void main(String[] args) {

		System.out.println("Hello World!"); // Display the string.
		showSingletonExamples();
		testFactory();
		testAbstractFactory();
		testAdapter();
		testComposit();
		testProxy();

		// draw = new DrawingClient(1000, 1000);
		testFacadePattern();
		testBridge();
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

	private static void testComposit() {
		// Composite pattern should be applied only when the group
		// of objects should behave as the single object
		// Composite pattern can be used to create tree like structure
		TestComposit.testComposit();
	}

	private static void testProxy() {
		// Proxy is one of the Structural design pattern
		// Proxy is used when we want to provide controlled access of a functionality
		ProxyPatternTest.testProxy();
	}

	private static void testFacadePattern() {

		// Facade pattern is used to help client application to easily interact with the
		// system.
		//
		String tableName = "Employee";
		Connection con = MySqlHelper.getMySqlDBConnection();
		MySqlHelper mySqlHelper = new MySqlHelper();
		mySqlHelper.generateMySqlHTMLReport(tableName, con);

		Connection con1 = OracleHelper.getOracleDBConnection();
		OracleHelper oracleHelper = new OracleHelper();
		oracleHelper.generateOraclePDFReport(tableName, con1);
		// We simplified use of accessing database
		HelperFacade.generateReport(HelperFacade.DBType.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
		HelperFacade.generateReport(HelperFacade.DBType.ORACLE, HelperFacade.ReportTypes.PDF, tableName);

	}

	private static void testBridge() {
		Shape tri = new Triangle(new RedColor());
		tri.applyColor();
		Shape pent = new Pentagon(new GreenColor());
		pent.applyColor();

	}
}

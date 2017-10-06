package main;

import java.sql.Connection;

import main.behavior_design_patterns.mediator.ChatMediator;
import main.behavior_design_patterns.mediator.ChatMediatorImpl;
import main.behavior_design_patterns.mediator.User;
import main.behavior_design_patterns.mediator.UserImpl;
import main.behavior_design_patterns.template_method.GlassHouse;
import main.behavior_design_patterns.template_method.HouseTemplate;
import main.behavior_design_patterns.template_method.WoodenHouse;
import main.creational_design_pattern.builder.ComputerPaternBuilder;
import main.creational_design_pattern.factory.Computer;
import main.creational_design_pattern.factory.ComputerFactory;
import main.creational_design_pattern.factory.PCFactory;
import main.creational_design_pattern.factory.ServerFactory;
import main.creational_design_pattern.prototype.PrototypePatternTest;
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
import main.structural_design_patterns.decorator.BasicCar;
import main.structural_design_patterns.decorator.Car;
import main.structural_design_patterns.decorator.LuxuryCar;
import main.structural_design_patterns.decorator.SportsCar;
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
		testProtoType();
		testAdapter();
		testComposit();
		testProxy();

		// draw = new DrawingClient(1000, 1000);
		testFacadePattern();
		testBridge();
		testDecoratorPattern();
		testTemplateMethod();
		testMediator();
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

	private static void testProtoType() {
		PrototypePatternTest.testPrototype();
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
		// Bridge design pattern can be used when both abstraction and implementation
		// can have different hierarchies independently and we want
		// to hide the implementation from the client
		Shape tri = new Triangle(new RedColor());
		tri.applyColor();
		Shape pent = new Pentagon(new GreenColor());
		pent.applyColor();

	}

	private static void testDecoratorPattern() {

		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.print("\n*****");
		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
	}

	private static void testTemplateMethod() {
		// Template Method is a behavioral design pattern and its used to create
		// method stub and deferring some of the steps of implementation to the
		// subclasses
		HouseTemplate houseType = new WoodenHouse();
		houseType.buildHouse();
		System.out.println("*********************");
		houseType = new GlassHouse();
		houseType.buildHouse();
	}

	private static void testMediator() {
		// Mediator pattern is one of the behavioral design pattern so it deals
		// behaviors of objects
		// Mediator is used to provide a centralized communication medium between
		// different objects in a system
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Pankaj");
		User user2 = new UserImpl(mediator, "Lisa");
		User user3 = new UserImpl(mediator, "Saurabh");
		User user4 = new UserImpl(mediator, "David");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);

		user1.send("Hi all");

	}
}

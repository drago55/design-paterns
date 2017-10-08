package main;

import java.sql.Connection;
import java.util.Scanner;

import main.behavior_design_patterns.chain_of_responsability.ATMDispenseChain;
import main.behavior_design_patterns.chain_of_responsability.Currency;
import main.behavior_design_patterns.command.CloseFileCommand;
import main.behavior_design_patterns.command.FileInvoker;
import main.behavior_design_patterns.command.FileSystemReciver;
import main.behavior_design_patterns.command.FileSystemReciverUtil;
import main.behavior_design_patterns.command.OpenFileCommand;
import main.behavior_design_patterns.command.WriteFileCommand;
import main.behavior_design_patterns.interpreter.InterpereteClient;
import main.behavior_design_patterns.interpreter.InterpreterContext;
import main.behavior_design_patterns.iterator.IteratorPatternTest;
import main.behavior_design_patterns.mediator.ChatMediator;
import main.behavior_design_patterns.mediator.ChatMediatorImpl;
import main.behavior_design_patterns.mediator.User;
import main.behavior_design_patterns.mediator.UserImpl;
import main.behavior_design_patterns.memento.FileWriterCaretaker;
import main.behavior_design_patterns.memento.FileWriterUtil;
import main.behavior_design_patterns.observer.MyTopic;
import main.behavior_design_patterns.observer.MyTopicSubscriber;
import main.behavior_design_patterns.observer.Observer;
import main.behavior_design_patterns.state.State;
import main.behavior_design_patterns.state.TVContext;
import main.behavior_design_patterns.state.TVRemoteBasic;
import main.behavior_design_patterns.state.TVStartState;
import main.behavior_design_patterns.state.TVStopState;
import main.behavior_design_patterns.strategy.CreditCardStrategy;
import main.behavior_design_patterns.strategy.Item;
import main.behavior_design_patterns.strategy.PaypalStrategy;
import main.behavior_design_patterns.strategy.ShopingCart;
import main.behavior_design_patterns.template_method.GlassHouse;
import main.behavior_design_patterns.template_method.HouseTemplate;
import main.behavior_design_patterns.template_method.WoodenHouse;
import main.behavior_design_patterns.visitor.Book;
import main.behavior_design_patterns.visitor.Fruit;
import main.behavior_design_patterns.visitor.ItemElement;
import main.behavior_design_patterns.visitor.ShoppingCartVisitor;
import main.behavior_design_patterns.visitor.ShoppingCartVisitorImpl;
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
		// Uncomment to test chain of responsibility
		// testChainOfResponsability();
		testObserverPattern();
		testStrategyPattern();
		testCommand();
		testTVRemoteBasic();
		testStatePattern();
		testVisitorPattern();
		testInterpreter();
		testIterator();
		testMemento();
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

	private static void testChainOfResponsability() {
		// Chain of responsibility design pattern is used to achive lose coupling
		// in software design where a request from client is
		// passed to chain of objects to process them

		ATMDispenseChain atmDispenseChain = new ATMDispenseChain();
		boolean i = true;
		while (i) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 10 != 0) {
				System.out.println("amount should be in multiple of 10s.");
				return;
			}
			atmDispenseChain.c1.dispense(new Currency(amount));
			i = false;
		}
	}

	private static void testObserverPattern() {
		// Observer design pattern is useful when you are interested in state of object
		// and want to get notified whenever there is any change.
		// In observer pattern the object that watch on the state of another object are
		// called Observer and
		// the object that is being watched is called Subject.
		MyTopic topic = new MyTopic();
		Observer obj1 = new MyTopicSubscriber("Obj1");
		Observer obj2 = new MyTopicSubscriber("Obj2");
		Observer obj3 = new MyTopicSubscriber("Obj3");
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);
		obj1.update();
		topic.postMessage("New Message");

	}

	private static void testStrategyPattern() {
		// Strategy pattern is used when have multiple
		// algorithm for a specific task and client

		ShopingCart cart = new ShopingCart();
		Item item1 = new Item("1234", 14);
		Item item2 = new Item("1455", 24);
		Item item3 = new Item("5532", 40);

		cart.addItem(item1);
		cart.addItem(item2);
		cart.addItem(item3);

		cart.pay(new PaypalStrategy("someone@domain.com", "myPasssw"));
		cart.pay(new CreditCardStrategy("Some one ", "12345678912334567", "214", "12/15"));
	}

	private static void testCommand() {
		/*
		 * Command pattern is one of the behavior design patterns and its used to
		 * implement lose coupling in a request-response model. In command pattern
		 * command is sent to the invoker pass it to the encapsulated command object
		 * Command object pass the request to the appropriate method of receiver object
		 * and then attach it to the command
		 */
		FileSystemReciver fs = FileSystemReciverUtil.getUnderlyingFileSystem();
		OpenFileCommand openFileCommand = new OpenFileCommand(fs);
		FileInvoker file = new FileInvoker(openFileCommand);
		file.execute();
		CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
		file = new FileInvoker(closeFileCommand);
		file.execute();
		WriteFileCommand writeFileCommand = new WriteFileCommand(fs);
		file = new FileInvoker(writeFileCommand);
		file.execute();

	}

	private static void testTVRemoteBasic() {
		// This is implementation of state without pattern
		TVRemoteBasic remote = new TVRemoteBasic();
		remote.setState("ON");
		remote.doAction();
		remote.setState("OFF");
		remote.doAction();

	}

	private static void testStatePattern() {
		/*
		 * The output is the same as with basicRemote implementation But the benefits of
		 * implementing polymorphic behavior is clearly visible the chance of error are
		 * less and its very easy to add more states for additional behavior making it
		 * more robust easily maintainable and flexible. Also state pattern helped to
		 * avoid switch or if else logic statements
		 */
		TVContext context = new TVContext();
		State tvStartState = new TVStartState();
		State tvStopState = new TVStopState();

		context.setTvState(tvStartState);
		context.doAction();
		context.setTvState(tvStopState);
		context.doAction();
	}

	private static void testVisitorPattern() {

		/*
		 * The benefit of this pattern is that if the logic of operation changes, then
		 * we need to make changes only in the visitor implementation rather than doing
		 * it in all the item classes
		 */
		ItemElement[] items = new ItemElement[] { new Book(20, "1234"), new Book(100, "5678"),
				new Fruit(10, 2, "banana"), new Fruit(5, 5, "Apple") };

		int total = calculatePrice(items);
		System.out.println("Total Cost =" + total);

	}

	private static int calculatePrice(ItemElement[] items) {
		ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
		int sum = 0;

		for (ItemElement item : items) {
			sum = sum + item.accept(visitor);
		}
		return sum;
	}

	private static void testInterpreter() {
		String str1 = "28 in Binary";
		String str2 = "28 in Hexadecimal";
		InterpereteClient ec = new InterpereteClient(new InterpreterContext());
		System.out.println(str1 + "+ " + ec.interpret(str1));
		System.out.println(str2 + "+ " + ec.interpret(str2));
	}

	private static void testIterator() {
		/*
		 * Iterator pattern is useful when you want to provide standard way to iterate
		 * over collection and hide the implementation from client program The logic for
		 * iteration is embedded in the collection itself and it helps client program to
		 * iterate over them easily
		 */
		IteratorPatternTest.testIterator();
	}

	private static void testMemento() {
		/*
		 * Memento design pattern i used when we want to save the state of an object so
		 * that we can restore later on.
		 */

		FileWriterCaretaker caretaker = new FileWriterCaretaker();
		FileWriterUtil fileWriter = new FileWriterUtil("data.txt");
		fileWriter.write("First set of data");
		System.out.println(fileWriter);
		caretaker.save(fileWriter);
		fileWriter.write("Second Set of Data");
		System.out.println(fileWriter);
		caretaker.undo(fileWriter);
		System.out.println(fileWriter);

	}
}

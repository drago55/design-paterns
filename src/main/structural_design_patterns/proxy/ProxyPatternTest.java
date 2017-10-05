package main.structural_design_patterns.proxy;

public class ProxyPatternTest {
	
	static CommandExecutor executor= new CommandExecutorProxy("Sandip","wrong_pwd");
	
	public static void testProxy() {
	try {
		executor.runCommand("ls -ltr");
		executor.runCommand("rm -rf abc.pdf");
		
		
	}catch(Exception e) {
		System.out.println("Exception Message::"+e.getMessage());
	}

}}

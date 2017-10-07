package main.behavior_design_patterns.command;

public class FileInvoker {

	public Command command;

	public FileInvoker(Command cmd) {
		this.command = cmd;
	}

	public void execute() {
		this.command.execute();
	}

}

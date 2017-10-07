package main.behavior_design_patterns.command;

public class WriteFileCommand implements Command {
	private FileSystemReciver fileSystem;

	public WriteFileCommand(FileSystemReciver fs) {
		this.fileSystem = fs;
	}

	@Override
	public void execute() {
		this.fileSystem.writeFile();
	}
}

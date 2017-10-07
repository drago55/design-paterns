package main.behavior_design_patterns.command;

public class OpenFileCommand implements Command {
	private FileSystemReciver fileSystem;

	public OpenFileCommand(FileSystemReciver fs) {
		this.fileSystem = fs;
	}

	@Override
	public void execute() {
		this.fileSystem.openFile();
	}

}

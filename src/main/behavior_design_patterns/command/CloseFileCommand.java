package main.behavior_design_patterns.command;

public class CloseFileCommand implements Command {

	private FileSystemReciver fileSystem;

	public CloseFileCommand(FileSystemReciver fs) {
		this.fileSystem = fs;
	}

	@Override
	public void execute() {
		this.fileSystem.closeFile();
	}

}

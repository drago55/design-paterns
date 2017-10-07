package main.behavior_design_patterns.command;

public class FileSystemReciverUtil {

	public static FileSystemReciver getUnderlyingFileSystem() {
		String osName = System.getProperty("os.name");
		System.out.println("Underlying OS is:" + osName);
		if (osName.contains("Windows")) {
			return new WindowsFileSystemReciver();
		} else {
			return new UnixFileSystemReciver();
		}
	}

}

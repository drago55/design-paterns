package main.behavior_design_patterns.interpreter;

public class InterpreterContext {

	public String getBinaryFormat(int i) {
		return Integer.toBinaryString(i);
	}

	public String getHexaDecimalFormat(int i) {
		return Integer.toHexString(i);
	}

}

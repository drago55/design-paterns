package main.behavior_design_patterns.interpreter;

public class InterpereteClient {

	public InterpreterContext ic;

	public InterpereteClient(InterpreterContext i) {
		this.ic = i;

	}

	public String interpret(String str) {
		Expression exp = null;
		if (str.contains("Hexadecimal")) {
			exp = new IntToHexExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
		} else if (str.contains("Binary")) {
			exp = new IntToBinaryExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
		} else
			return str;

		return exp.interpret(ic);
	}
}

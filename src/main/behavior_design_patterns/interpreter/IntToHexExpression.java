package main.behavior_design_patterns.interpreter;

public class IntToHexExpression implements Expression {

	private int i;

	public IntToHexExpression(int c) {
		this.i = c;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.getHexaDecimalFormat(i);
	}

}

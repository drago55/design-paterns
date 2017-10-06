package main.structural_design_patterns.bridge;

public class GreenColor implements Color {

	@Override
	public void applyColor() {
		System.out.print("green.");
	}

}

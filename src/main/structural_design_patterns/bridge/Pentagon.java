package main.structural_design_patterns.bridge;

public class Pentagon extends Shape {

	public Pentagon(Color c) {
		super(c);

	}

	@Override
	public void applyColor() {
		System.out.println("Pentagon filled with color ");
		color.applyColor();
	}

}

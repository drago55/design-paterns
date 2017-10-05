package main.structural_design_patterns.composit;

public class Circle implements Shape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing circle with color "+fillColor);
		
	}

}

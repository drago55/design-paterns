package main.structural_design_patterns.composit;

public class Triangle implements Shape{

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Triangle with color"+fillColor);
		
	}

}

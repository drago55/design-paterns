package main.structural_design_patterns.composit;

import java.util.ArrayList;
import java.util.List;

public class Drawing implements Shape {

	private List<Shape> shapes = new ArrayList();

	@Override
	public void draw(String fillColor) {
		for (Shape sh : shapes) {
			sh.draw(fillColor);
		}
	}

	public void add(Shape s) {
		this.shapes.add(s);
	}

	public void remove(Shape s) {
		this.shapes.remove(s);
	}

	public void clear() {
		System.out.println("Clearing all shapes from drawing");
		this.shapes.clear();
	}

}

package main.structural_design_patterns.composit;

public class TestComposit {

	public static void testComposit() {
		Shape tri = new Triangle();
		Shape tri1 = new Triangle();
		Shape cir = new Circle();

		Drawing drawing = new Drawing();
		drawing.add(tri);
		drawing.add(tri1);
		drawing.add(cir);
		drawing.draw("Red");
		drawing.clear();
		drawing.add(tri1);
		drawing.add(tri);
		drawing.draw("Green");

	}

}

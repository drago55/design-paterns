package main.structural_design_patterns.flyweight;

import java.util.HashMap;

public class ShapeFactory {
		
	private static final HashMap shapes = new HashMap();
	
	public static Shape getShape(ShapeType type) {
		//We are reusing object from HashMap
		Shape shapeImpl=(Shape) shapes.get(type);
		if(shapeImpl==null) {
			if(type.equals(ShapeType.OVAL_FILL)){
				shapeImpl=new Oval(true);
			}else if(type.equals(ShapeType.OVAL_NOFILL)) {
				shapeImpl= new Oval(false);
			}else if (type.equals(ShapeType.LINE)) {
				shapeImpl=new Line();
			}
		}
		return shapeImpl;
	}
	public static enum ShapeType{
		OVAL_FILL,OVAL_NOFILL,LINE;
	}
}

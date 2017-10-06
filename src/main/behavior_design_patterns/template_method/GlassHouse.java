package main.behavior_design_patterns.template_method;

public class GlassHouse extends HouseTemplate {

	@Override
	public void buildWalls() {
		System.out.println("Building glass walls");
	}

	@Override
	public void buildPillars() {
		System.out.println("Building pillars with glass coating");
	}

}

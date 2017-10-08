package main.behavior_design_patterns.state;

/*
 * This is implementation with out design patterns
 */
public class TVRemoteBasic {

	private String state = "";

	public void setState(String state) {
		this.state = state;
	}

	public void doAction() {
		System.out.println("RemoteBasic implementation");
		if (state.equalsIgnoreCase("ON")) {

			System.out.println("TV is turned ON");
		} else if (state.equalsIgnoreCase("OFF")) {
			System.out.println("TV is turned OFF");
		}
	}
}

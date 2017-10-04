package main.structural_design_patterns.adapter;

public interface SocketAdapter {

	// we are using interface this can also be abstract class

	public Volt get120Volt();

	public Volt get12Volt();

	public Volt get3Volt();

}

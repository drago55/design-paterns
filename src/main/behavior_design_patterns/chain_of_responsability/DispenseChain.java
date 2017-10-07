package main.behavior_design_patterns.chain_of_responsability;

public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);

	void dispense(Currency cur);

}

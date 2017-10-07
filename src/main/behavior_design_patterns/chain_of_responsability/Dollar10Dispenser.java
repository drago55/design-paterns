package main.behavior_design_patterns.chain_of_responsability;

public class Dollar10Dispenser implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if (cur.getAmount() >= 10) {
			int num = cur.getAmount() / 10;
			int reminder = cur.getAmount() % 10;
			System.out.println("Dispensing " + num + " 10$ note");
			if (reminder != 0) {
				this.chain.dispense(new Currency(reminder));
			}
		} else {
			this.chain.dispense(cur);
		}
	}

}

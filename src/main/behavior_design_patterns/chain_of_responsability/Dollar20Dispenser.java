package main.behavior_design_patterns.chain_of_responsability;

public class Dollar20Dispenser implements DispenseChain {
	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if (cur.getAmount() >= 20) {
			int num = cur.getAmount() / 20;
			int reminder = cur.getAmount() % 20;
			System.out.println("Dispensing " + num + " 20$ note");
			if (reminder != 0) {
				this.chain.dispense(new Currency(reminder));
			}
		} else {
			this.chain.dispense(cur);
		}
	}

}

package main.behavior_design_patterns.visitor;

public interface ItemElement {
	public int accept(ShoppingCartVisitor visitor);
}

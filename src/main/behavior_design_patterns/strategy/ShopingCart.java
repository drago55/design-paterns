package main.behavior_design_patterns.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShopingCart {

	List<Item> items;

	public ShopingCart() {
		this.items = new ArrayList();
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public int claculateTotal() {
		int sum = 0;
		for (Item item : items) {
			sum += item.getPrice();
		}
		return sum;
	}

	public void pay(PaymentStrategy paymentMethod) {
		int amount = claculateTotal();
		paymentMethod.pay(amount);
	}
}

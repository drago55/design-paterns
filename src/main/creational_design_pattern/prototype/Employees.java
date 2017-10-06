package main.creational_design_pattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {
	private List<String> empList;

	public Employees() {
		empList = new ArrayList();
	}

	public Employees(List list) {
		this.empList = list;
	}

	public void loadData() {
		empList.add("Pankaj");
		empList.add("Raj");
		empList.add("David");
		empList.add("Lisa");
	}

	public List<String> getEmpList() {
		return empList;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		List temp = new ArrayList();
		for (String s : this.getEmpList()) {
			temp.add(s);
		}
		return new Employees(temp);
	}
}

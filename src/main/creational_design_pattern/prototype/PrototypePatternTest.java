package main.creational_design_pattern.prototype;

import java.util.List;

public class PrototypePatternTest {

	public static void testPrototype() {
		Employees emps = new Employees();
		emps.loadData();

		try {
			Employees empsNew = (Employees) emps.clone();
			Employees empsNew1 = (Employees) emps.clone();
			List list = empsNew.getEmpList();
			list.add("John");
			List list1 = empsNew1.getEmpList();
			list1.remove("Pankaj");
			System.out.println("emps List: " + emps.getEmpList());
			System.out.println("empsNew List: " + list);
			System.out.println("empsNew1 List: " + list1);

		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

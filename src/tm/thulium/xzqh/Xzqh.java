package tm.thulium.xzqh;

import java.util.ArrayList;

public class Xzqh {
	protected String name;
	protected String suffix = new String();
	protected static ArrayList<Integer> children;
	protected static Integer serialNumber;

	public Xzqh() {
		serialNumber = Xzqhs.acquireSerial();
		name = "NaN";
	}

	public Xzqh(String namee) {
		serialNumber = Xzqhs.acquireSerial();
		name = namee;
	}

	public void output() {
		System.out.print(name);
		System.out.println(suffix);
	}

	public String getName() {
		return name;
	}

	public void setName(String namee) {
		name = namee;
	}

	public static ArrayList<Integer> getChild() {
		return children;
	}

	public static void setChild(ArrayList<Integer> child) {
		Xzqh.children = child;
	}

	public Xzqh addChild(Xzqh child) {
		children.add(child.getSerialNumber());
		return this;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		Xzqh.serialNumber = serialNumber;
	}

}

package tm.thulium.xzqh;

import java.util.ArrayList;

import tm.thulium.util.XzqhUtil;

public class Xzqh {
	protected String name;
	protected String suffix = new String();
	protected static ArrayList<Xzqh> children = new ArrayList<Xzqh>();
	protected static Integer serialNumber;

	public Xzqh() {
		serialNumber = XzqhUtil.maxSerial;
		XzqhUtil.maxSerial++;
		name = "NaN";
	}

	public Xzqh(String namee) {
		serialNumber = XzqhUtil.maxSerial;
		XzqhUtil.maxSerial++;
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

	public ArrayList<Xzqh> getChild() {
		return children;
	}

	public static void setChild(ArrayList<Xzqh> child) {
		Xzqh.children = child;
	}

	public Xzqh addChild(Xzqh child) {
		children.add(child);
		return this;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		Xzqh.serialNumber = serialNumber;
	}

}

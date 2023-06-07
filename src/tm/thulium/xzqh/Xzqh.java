package tm.thulium.xzqh;

import java.util.ArrayList;

public class Xzqh {
	protected String name = "";
	protected String suffix = new String();
	protected static ArrayList<Xzqh> children = new ArrayList<Xzqh>();
	protected static Integer serialNumber;

	public Xzqh() {
		serialNumber = XzqhUtil.getMaxSerial();
		name = "NaN";
	}

	public Xzqh(String namee) {
		serialNumber = XzqhUtil.getMaxSerial();
		name = namee;
	}

	public Xzqh(String namee, Integer ser) {
		serialNumber = ser;
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
		System.err.println("adding child. ch=(" + child.getSerialNumber() + ", " + child.getName() + ")");
		children.add(child);
		return this;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialumber) {
		serialNumber = serialumber;
	}

}

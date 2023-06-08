package tm.thulium.xzqh;

import java.util.ArrayList;

import tm.thulium.xzqh.nd.Fu;
import tm.thulium.xzqh.nd.Jun;
import tm.thulium.xzqh.nd.Shi;
import tm.thulium.xzqh.rd.Qu;
import tm.thulium.xzqh.rd.Xhi;
import tm.thulium.xzqh.rd.Xian;
import tm.thulium.xzqh.st.Zhou;
import tm.thulium.xzqh.th.Dao;
import tm.thulium.xzqh.th.Xiang;
import tm.thulium.xzqh.th.Zhen;

public class Xzqh {
	protected String name = "";
	protected String suffix = new String();
	protected ArrayList<Xzqh> children = new ArrayList<Xzqh>();
	protected Integer serialNumber;
	protected int level = -1;
	public String description = "";

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

	public Xzqh(String namee, Integer ser, String des) {
		serialNumber = ser;
		name = namee;
		description = des;
	}

	public Xzqh(String namee, Integer ser, String des, ArrayList<Xzqh> c) {
		serialNumber = ser;
		name = namee;
		description = des;
		children = c;
	}

	public Xzqh(String namee, Integer ser, String des, Xzqh x) {
		serialNumber = ser;
		name = namee;
		description = des;
		children.add(x);
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

	public void setChild(ArrayList<Xzqh> child) {
		children = child;
	}

	public Xzqh addChild(Xzqh child) {
		children.add(child);
		return this;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialumber) {
		serialNumber = serialumber;
	}

	public int getLevel() {
		if (level >= 0)
			return level;
		if (this.equals(XzqhUtil.MASTER) || serialNumber == 0)
			level = 0;
		else if (this instanceof Zhou)
			level = 1;
		else if (this instanceof Fu || this instanceof Shi || this instanceof Jun)
			level = 2;
		else if (this instanceof Qu || this instanceof Xhi || this instanceof Xian)
			level = 3;
		else if (this instanceof Zhen || this instanceof Dao || this instanceof Xiang)
			level = 4;
		return level;
	}

}

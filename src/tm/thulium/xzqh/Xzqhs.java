package tm.thulium.xzqh;

import java.util.ArrayList;

public class Xzqhs {
	private static ArrayList<Xzqh> LIST;

	public Xzqhs() {
		LIST = new ArrayList<Xzqh>();
	}

	public ArrayList<Xzqh> getLIST() {
		return LIST;
	}

	public static void setLIST(ArrayList<Xzqh> lIST) {
		LIST = lIST;
	}

	public void add(Xzqh x) {
		x.setSerialNumber(Integer.valueOf(LIST.size()));
		LIST.add(x);
	}

	public static Integer acquireSerial() {
		return Integer.valueOf(LIST.size());
	}

}

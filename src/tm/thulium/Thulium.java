package tm.thulium;

import tm.thulium.util.ReadInformationUtil;
import tm.thulium.xzqh.XzqhUtil;

public class Thulium {
	
	public Thulium() {
	}

	public static void main(String[] args) {
		System.out.println("Hello Thulium!");
		ReadInformationUtil.read(System.in);
		System.out.println("Added districts:");
		XzqhUtil.printInTree();
	}

}

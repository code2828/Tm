package tm.thulium;

import java.util.Scanner;

import tm.thulium.util.XzqhUtil;
import tm.thulium.xzqh.Xzqh;

public class Thulium {
	public static final Scanner sc = new Scanner(System.in);
	public static final XzqhUtil xu = new XzqhUtil();
	// Use {@link XzqhUtil#MASTER} instead
	@Deprecated
	public static final Xzqh MASTER = Thulium.xu.MASTER;

	public Thulium() {
	}

	public static void main(String[] args) {
		System.out.println("Hello Thulium!");
		String inp, in2;
		int ser = 0;
		System.out.println("a for Zhou, b for Fu, c for Shi, d for Jun, e for Xhi, f for Qu");
		System.out.println("g for Xian, h for Dao, i for Zhen, j for Xiang.");
		while (true) {
			inp = sc.nextLine();
			if (inp.length() == 0) {
				inp = sc.nextLine();
				if (inp.length() == 0) {
					break;
				}
			}
			if (inp.charAt(0) == '@') {
				break;
			}
			if (inp.charAt(0) == '1') {
				ser = sc.nextInt();
				in2 = sc.next();
				try {
					switch (inp.charAt(1)) {
					case 'a':
						XzqhUtil.findXzqhFromSerial(ser).addChild(new Xzqh(in2));
						break;
					}
				} catch (StringIndexOutOfBoundsException e) {
					e.printStackTrace();
					System.out.println("You have not properly entered the name!");
				}
			}
		}
		System.out.println("MASTER: " + xu.MASTER.getSerialNumber() + ' ' + xu.MASTER.getName());
		System.out.println("Added districts:");
		XzqhUtil.printInTree();
	}

}

package tm.thulium;

import java.util.Scanner;

import tm.thulium.xzqh.Xzqh;
import tm.thulium.xzqh.XzqhUtil;

public class Thulium {
	public static final Scanner sc = new Scanner(System.in);

	public Thulium() {
	}

	public static void main(String[] args) {
		System.out.println("Hello Thulium!");
		System.out.println("MASTER: " + XzqhUtil.MASTER.getSerialNumber() + ' ' + XzqhUtil.MASTER.getName());
		String inp, in2;
		int ser = 0;
		System.out.println("a for Zhou, b for Fu, c for Shi, d for Jun, e for Xhi, f for Qu");
		System.out.println("g for Xian, h for Dao, i for Zhen, j for Xiang.");
		while (true) {
			inp = sc.next();
			System.out.println("you input: \"" + inp + "\"");
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
				System.err.println("Hey");
				ser = sc.nextInt();
				in2 = sc.next();
				System.err.println("Found: ser=" + ser + "\tin=\"" + in2 + "\"");
				try {
					switch (inp.charAt(1)) {
					case 'a':
						System.err.println("州" + " Max serial=" + XzqhUtil.getMaxSerial());
						XzqhUtil.findXzqhFromSerial(ser).addChild(new Xzqh(in2, XzqhUtil.incMaxSerial()));
						break;
					default:
						System.err.println("Unknown");
						break;
					}
				} catch (StringIndexOutOfBoundsException e) {
					e.printStackTrace();
					System.out.println("You have not properly entered the name!");
				}
				System.err.println("end of loop");
			}
		}
		System.out.println("MASTER: " + XzqhUtil.MASTER.getSerialNumber() + ' ' + XzqhUtil.MASTER.getName());
		System.out.println("Added districts:");
		XzqhUtil.debugPrintLinear();
		System.out.println("MASTER: " + XzqhUtil.MASTER.getSerialNumber() + ' ' + XzqhUtil.MASTER.getName());
	}

}
/*
1a
0 癸
1a
0 壬
 */
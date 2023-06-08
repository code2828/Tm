package tm.thulium.util;

import java.io.InputStream;
import java.util.Scanner;

import tm.thulium.xzqh.XzqhUtil;
import tm.thulium.xzqh.nd.Fu;
import tm.thulium.xzqh.nd.Jun;
import tm.thulium.xzqh.nd.Shi;
import tm.thulium.xzqh.st.Zhou;

public class ReadInformationUtil {

	public ReadInformationUtil() {
	}

	public static void read(InputStream is) {
		final Scanner sc = new Scanner(is);
		String inp, in2;
		int ser = 0;
		System.out.println("a for Zhou, b for Fu, c for Shi, d for Jun, e for Xhi, f for Qu");
		System.out.println("g for Xian, h for Dao, i for Zhen, j for Xiang.");
		int debu = 0;
		while (true) {
			debu++;
			if (debu >= 100)
				break;
			inp = sc.next();
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
						XzqhUtil.ofSerial(ser).addChild(new Zhou(in2, XzqhUtil.incMaxSerial()));
						break;
					case 'b':
						XzqhUtil.ofSerial(ser).addChild(new Fu(in2, XzqhUtil.incMaxSerial()));
						break;
					case 'c':
						XzqhUtil.ofSerial(ser).addChild(new Shi(in2, XzqhUtil.incMaxSerial()));
						break;
					case 'd':
						XzqhUtil.ofSerial(ser).addChild(new Jun(in2, XzqhUtil.incMaxSerial()));
						break;
					default:
						System.err.println("Unknown");
						break;
					}
				} catch (StringIndexOutOfBoundsException e) {
					e.printStackTrace();
					System.err.println("You have not properly entered the name!");
				}
			}
		}
		sc.close();
	}

	public static void read() {
		read(System.in);
	}
}

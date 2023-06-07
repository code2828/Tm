package tm.thulium;

import java.util.Scanner;
import java.util.function.Consumer;

import tm.thulium.xzqh.Xzqh;
import tm.thulium.xzqh.Xzqhs;
import tm.thulium.xzqh.st.Zhou;

public class Thulium {
	public static final Scanner sc = new Scanner(System.in);
	public static final Xzqhs xs = new Xzqhs();

	public Thulium() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Hello Thulium!");
		String inp, in2;
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
				in2 = sc.next();
				try {
					switch (inp.charAt(1)) {
					case 'a':
						xs.add(new Zhou(in2));
						break;
					}
				} catch (StringIndexOutOfBoundsException e) {
					e.printStackTrace();
					System.out.println("You have not properly entered the name!");
				}
			}
		}
		System.out.println("Added districts:");
		Consumer<Xzqh> output = new Consumer<Xzqh>() {
			@Override
			public void accept(Xzqh t) {
				t.output();
			}
		};
		xs.getLIST().forEach(output);
	}

}

package tm.thulium.xzqh;

import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.LinkedList;

public class XzqhUtil {
	private static Integer maxSerial = 0;
	public static final Xzqh MASTER = new Xzqh("氢");

	public XzqhUtil() {
		maxSerial = 1;
		MASTER.setSerialNumber(0);
	}

	public static Integer getMaxSerial() {
		return maxSerial;
	}

	public static Integer incMaxSerial() {
		return ++maxSerial;
	}

	public static Xzqh findXzqhFromSerial(int ser) {
		System.err.println("Finding xzqh from ser=" + ser);
		Queue<Xzqh> q = new LinkedList<Xzqh>();
		Xzqh g = XzqhUtil.MASTER;
		g.setSerialNumber(0);
		System.err.println("g=(" + g.getSerialNumber() + ", " + g.getName() + ")");
		q.offer(g);
		Xzqh z = new Xzqh();
		int asjd = 0;
		while (!q.isEmpty()) {
			System.err.println("in loop g=(" + g.getSerialNumber() + ", " + g.getName() + ")");
			System.err.println("q.top()=(" + q.peek().getSerialNumber() + ", " + q.peek().getName() + ")");
			asjd++;
			if (asjd >= 30)
				break;
			z = q.remove();
			System.err.println("searching z=(" + z.getSerialNumber() + ", " + z.getName() + ")");
			if (z.getSerialNumber() == ser) {
				System.err.println("Found: z=(" + ser + ", " + z.getName() + ")");
				return z;
			} else {
				Consumer<Xzqh> putIntoQueue = new Consumer<Xzqh>() {
					@Override
					public void accept(Xzqh t) {
						System.err.println("z has child: ch=(" + t.getSerialNumber() + ", " + t.getName() + ")");
						q.offer(t);
					}
				};
				z.getChild().forEach(putIntoQueue);
			}
		}
		return XzqhUtil.MASTER;
	}

	public static void printInTree() {
		Stack<Xzqh> s = new Stack<Xzqh>();
		s.push(XzqhUtil.MASTER);
		Xzqh y = new Xzqh();
		while (!s.empty()) {
			y = s.pop();
			System.out.println(y.getName());
			System.out.println(y.getSerialNumber());
			Consumer<Xzqh> putIntoStack = new Consumer<Xzqh>() {
				@Override
				public void accept(Xzqh t) {
					s.push(t);
				}
			};
			y.getChild().forEach(putIntoStack);
		}
	}

	public static void debugPrintLinear() {
		Consumer<Xzqh> print = new Consumer<Xzqh>() {
			@Override
			public void accept(Xzqh t) {
				System.out.println(t.getName() + ' ' + t.getSerialNumber());
			}
		};
		MASTER.getChild().forEach(print);
	}

}

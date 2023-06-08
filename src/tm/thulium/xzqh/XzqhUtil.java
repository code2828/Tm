package tm.thulium.xzqh;

import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class XzqhUtil {
	private static Integer maxSerial = 0;
	public final static Xzqh MASTER = new Xzqh("氢", 0);

	public XzqhUtil() {
	}

	public static Integer getMaxSerial() {
		return maxSerial;
	}

	public static Integer incMaxSerial() {
		return ++maxSerial;
	}

	public static Xzqh ofSerial(int ser) {
		Queue<Xzqh> q = new LinkedList<Xzqh>();
		Xzqh g = XzqhUtil.MASTER;
		q.offer(g);
		Xzqh z;
		int asjd = 0;
		while (!q.isEmpty()) {
			asjd++;
			if (asjd >= 30)
				break;
			z = q.remove();
			if (z.getSerialNumber() == ser) {
				return z;
			} else {
				Consumer<Xzqh> putIntoQueue = new Consumer<Xzqh>() {
					@Override
					public void accept(Xzqh t) {
						q.offer(t);
					}
				};
				z.getChild().forEach(putIntoQueue);
			}
		}
		return XzqhUtil.MASTER;
	}

	public static Xzqh ofName(String n) {
		Queue<Xzqh> q = new LinkedList<Xzqh>();
		Xzqh g = XzqhUtil.MASTER;
		q.offer(g);
		Xzqh z;
		int asjd = 0;
		while (!q.isEmpty()) {
			asjd++;
			if (asjd >= 30)
				break;
			z = q.remove();
			if (z.getName().equals(n)) {
				return z;
			} else {
				Consumer<Xzqh> putIntoQueue2 = new Consumer<Xzqh>() {
					@Override
					public void accept(Xzqh t) {
						q.offer(t);
					}
				};
				z.getChild().forEach(putIntoQueue2);
			}
		}
		return XzqhUtil.MASTER;
	}

	public static Xzqh upperLevelOf(Xzqh o) {
		Queue<Xzqh> q = new LinkedList<Xzqh>();
		Xzqh g = XzqhUtil.MASTER;
		q.offer(g);
		Xzqh z;
		while (!q.isEmpty()) {
			z = q.remove();
			List<Xzqh> li = z.getChild();
			for (Iterator<Xzqh> it = li.iterator(); it.hasNext();) {
				Xzqh t = it.next();
				if (t.equals(o)) {
					return z;
				}
				q.offer(t);
			}
		}
		return XzqhUtil.MASTER;
	}

	public static void printInTree() {
		Stack<Xzqh> s = new Stack<Xzqh>();
		s.push(XzqhUtil.MASTER);
		Xzqh y = new Xzqh();
		int debu = 0;
		while (!s.empty()) {
			debu++;
			if (debu >= 40)
				break;
			y = s.pop();
			for (int k = 0; k < y.getLevel(); k++)
				System.out.print("   ");
			System.out.println(y.getName() + y.suffix);
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
				System.out.println(t.getName() + t.getSerialNumber());
			}
		};
		MASTER.getChild().forEach(print);
	}

}

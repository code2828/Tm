package tm.thulium.util;

import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.LinkedList;

import tm.thulium.Thulium;
import tm.thulium.xzqh.Xzqh;

public class XzqhUtil {
	public static Integer maxSerial = 0;
	public final Xzqh MASTER = new Xzqh("氢");

	public XzqhUtil() {
		maxSerial = 1;
		MASTER.setSerialNumber(0);
	}

	public static Xzqh findXzqhFromSerial(int ser) {
		Queue<Xzqh> q = new LinkedList<Xzqh>();
		q.offer(Thulium.xu.MASTER);
		Xzqh z = new Xzqh();
		while (!q.isEmpty()) {
			z = q.poll();
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
		return Thulium.xu.MASTER;
	}

	public static void printInTree() {
		Stack<Xzqh> s = new Stack<Xzqh>();
		s.push(Thulium.xu.MASTER);
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

}

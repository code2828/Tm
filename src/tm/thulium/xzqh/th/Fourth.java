package tm.thulium.xzqh.th;

import java.util.ArrayList;

import tm.thulium.Station;
import tm.thulium.xzqh.Xzqh;

public class Fourth extends Xzqh {
	private final ArrayList<Station> st = new ArrayList<Station>();

	public Fourth() {
	}

	public Fourth(String namee) {
		super(namee);
	}

	public Fourth(String namee, Integer ser) {
		super(namee, ser);
	}

	public Fourth(String namee, Integer ser, String des) {
		super(namee, ser, des);
	}

	public Fourth(String namee, Integer ser, String des, ArrayList<Xzqh> c) {
		super(namee, ser, des, c);
	}

	public Fourth(String namee, Integer ser, String des, Xzqh x) {
		super(namee, ser, des, x);
	}

	public Fourth(String namee, Integer ser, String des, Station s) {
		super(namee, ser, des);
		s.setF(this);
		st.add(s);
	}

	public void addStation(Station s) {
		s.setF(this);
		st.add(s);
	}

}

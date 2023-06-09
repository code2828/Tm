package tm.thulium;

import tm.thulium.xzqh.th.Fourth;

public class Station {
	private Fourth f = new Fourth();
	private int level = 4;

	public Station() {
	}

	public Station(int l) {
		level = l;
	}

	public Fourth getF() {
		return f;
	}

	public void setF(Fourth f) {
		this.f = f;
	}

}

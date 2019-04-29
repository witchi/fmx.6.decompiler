package info.phosco.forms.rotate;

public class OraclePoint {

	private final double x;
	private final double y;

	public OraclePoint(double x, double y) {
		this.x = Math.round(x * 1000.0) / 1000.0;
		this.y = Math.round(y * 1000.0) / 1000.0;
	}

	public OraclePoint(int x, int y) {
		this((double) x, (double) y);
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return getClass().getName() + "[" + this.x + ", " + this.y + "]";
	}

}

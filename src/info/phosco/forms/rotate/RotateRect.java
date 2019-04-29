package info.phosco.forms.rotate;

public class RotateRect {

	// Rotation point: x1,y1
	// Original x,y
	// Rotated x',y'
	// Rotation angle q

	private static OraclePoint rotate(OraclePoint p, OraclePoint c, int angle) {
		// x' = x1 + cos(q) * (x - x1) - sin(q) * (y - y1)
		double x = c.getX() + Math.cos(Math.toRadians(angle)) * (p.getX() - c.getX()) - Math.sin(Math.toRadians(angle)) * (p.getY() - c.getY());

		// y' = y1 + sin(q) * (x - x1) + cos(q) * (y - y1)
		double y = c.getY() + Math.sin(Math.toRadians(angle)) * (p.getX() - c.getX()) - Math.cos(Math.toRadians(angle)) * (p.getY() - c.getY());

		return new OraclePoint(x, y);
	}

	public static void main(String args[]) {
		// Border
		int x = 36;
		int y = 46;
		int w = 122;
		int h = 75;

		// Rectangle
		x = 37;
		y = 47;
		w = 120;
		h = 73;

		int angle = 45;

		// calc every corner
		OraclePoint p0 = new OraclePoint(x, y);
		OraclePoint p1 = new OraclePoint(x + w, y);
		OraclePoint p2 = new OraclePoint(x + w, y + h);
		OraclePoint p3 = new OraclePoint(x, y + h);

		System.out.println("rotate angle: 0°");
		System.out.println(p0);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

		// calc center point
		OraclePoint center = new OraclePoint(x + (w / 2.0d), y + (h / 2.0d));

		// Rotate rectangle
		OraclePoint r0 = rotate(p0, center, angle);
		OraclePoint r1 = rotate(p1, center, angle);
		OraclePoint r2 = rotate(p2, center, angle);
		OraclePoint r3 = rotate(p3, center, angle);

		System.out.println("----------");
		System.out.println("rotate angle: " + angle + "°");
		System.out.println(r0);
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);

	}
}

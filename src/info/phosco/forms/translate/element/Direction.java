package info.phosco.forms.translate.element;

public enum Direction {
	STANDARD(0x0), LEFT_TO_RIGHT(0x1), RIGHT_TO_LEFT(0x2);

	private final int direction;

	private Direction(int direction) {
		this.direction = direction;
	}

	public static Direction lookup(int direction) {
		for (Direction t : Direction.values()) {
			if (t.direction == direction) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown CanvasDirection "
				+ direction);
	}

}

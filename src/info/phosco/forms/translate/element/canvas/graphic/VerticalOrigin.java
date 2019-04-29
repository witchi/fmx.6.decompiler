package info.phosco.forms.translate.element.canvas.graphic;

public enum VerticalOrigin {

	TOP(0x8), CENTER(0x4), BOTTOM(0x0);

	private final int origin;

	private VerticalOrigin(int origin) {
		this.origin = origin;
	}

	public static VerticalOrigin lookup(int origin) {
		for (VerticalOrigin t : VerticalOrigin.values()) {
			if (t.origin == origin) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown VerticalOrigin " + origin);
	}
}

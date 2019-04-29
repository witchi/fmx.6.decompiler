package info.phosco.forms.translate.element.canvas.graphic;

public enum HorizontalOrigin {

	LEFT(0x0), CENTER(0x1), RIGHT(0x2);

	private final int origin;

	private HorizontalOrigin(int origin) {
		this.origin = origin;
	}

	public static HorizontalOrigin lookup(int origin) {
		for (HorizontalOrigin t : HorizontalOrigin.values()) {
			if (t.origin == origin) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown HorizontalOrigin " + origin);
	}
}

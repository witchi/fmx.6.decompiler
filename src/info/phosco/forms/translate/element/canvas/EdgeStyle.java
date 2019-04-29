package info.phosco.forms.translate.element.canvas;

public enum EdgeStyle {

	BEVELED(0x0), SQUARE(0x1), ROUND(0x2);

	private final int style;

	private EdgeStyle(int style) {
		this.style = style;
	}

	public static EdgeStyle lookup(int style) {
		for (EdgeStyle t : EdgeStyle.values()) {
			if (t.style == style) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown EdgeStyle " + style);
	}

}

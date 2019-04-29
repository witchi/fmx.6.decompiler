package info.phosco.forms.translate.element.canvas.graphic;

public enum CapStyle {

	BUTT(0x0), ROUND(0x10), PROJECTING(0x8);

	private final int style;

	private CapStyle(int style) {
		this.style = style;
	}

	public static CapStyle lookup(int style) {
		for (CapStyle t : CapStyle.values()) {
			if (t.style == style) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown CapStyle " + style);
	}
}

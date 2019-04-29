package info.phosco.forms.translate.element.canvas.graphic;

public enum DashStyle {

	SOLID(0x0), DOTTED(0x1), DASHED(0x2), DASH_DOT(0x3), DOUBLE_DOT(0x4), LONG_DASH(0x5), DASH_DOUBLE_DOT(0x6);

	private final int style;

	private DashStyle(int style) {
		this.style = style;
	}

	public static DashStyle lookup(int style) {
		for (DashStyle t : DashStyle.values()) {
			if (t.style == style) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown DashStyle " + style);
	}
}

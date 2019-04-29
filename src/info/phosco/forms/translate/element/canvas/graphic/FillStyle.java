package info.phosco.forms.translate.element.canvas.graphic;

public enum FillStyle {

	PIE(0x0), CHORD(0x1);

	private final int style;

	private FillStyle(int style) {
		this.style = style;
	}

	public static FillStyle lookup(int style) {
		for (FillStyle t : FillStyle.values()) {
			if (t.style == style) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown FillStyle " + style);
	}
}

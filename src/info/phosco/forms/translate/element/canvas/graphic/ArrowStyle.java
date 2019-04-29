package info.phosco.forms.translate.element.canvas.graphic;

public enum ArrowStyle {

	NONE(0x0), START(0x1), END(0x2), BOTH_ENDS(0x3), MIDDLE_TO_START(0x4), MIDDLE_TO_END(0x5);

	private final int style;

	private ArrowStyle(int style) {
		this.style = style;
	}

	public static ArrowStyle lookup(int style) {
		for (ArrowStyle t : ArrowStyle.values()) {
			if (t.style == style) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown ArrowStyle " + style);
	}
}

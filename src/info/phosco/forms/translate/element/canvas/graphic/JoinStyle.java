package info.phosco.forms.translate.element.canvas.graphic;

public enum JoinStyle {

	MITRE(0x20), BEVEL(0x40), ROUND(0x60);

	private final int style;

	private JoinStyle(int style) {
		this.style = style;
	}

	public static JoinStyle lookup(int style) {
		for (JoinStyle t : JoinStyle.values()) {
			if (t.style == style) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown JoinStyle " + style);
	}
}

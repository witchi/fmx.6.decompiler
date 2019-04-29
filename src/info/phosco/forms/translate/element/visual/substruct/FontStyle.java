package info.phosco.forms.translate.element.visual.substruct;

public enum FontStyle {

	NORMAL(0x0),
	ITALIC(0x1),
	INCLINED(0x2),
	UNDERLINE(0x4),
	CONTOURS(0x8),
	SHADOW(0x10),
	INVERS(0x20),
	STRIKETHROUGH(0x40),
	FLASHING(0x80);
	
	private final int style;

	private FontStyle(int style) {
		this.style = style;
	}

	public static FontStyle lookup(int style) {
		for (FontStyle t : FontStyle.values()) {
			if (t.style == style) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown FontStyle " + Integer.toHexString(style));
	}	
}

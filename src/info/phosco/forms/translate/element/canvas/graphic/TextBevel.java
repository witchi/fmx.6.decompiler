package info.phosco.forms.translate.element.canvas.graphic;

public enum TextBevel {

	RAISED(0x18), LOWERED(0x20), NONE(0x0), INSET(0x8), OUTSET(0x10), PLAIN(0x0);

	private final int bevel;

	private TextBevel(int bevel) {
		this.bevel = bevel;
	}

	public static TextBevel lookup(int bevel) {
		for (TextBevel t : TextBevel.values()) {
			if (t.bevel == bevel) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown RectangleBevel " + bevel);
	}
}

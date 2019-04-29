package info.phosco.forms.translate.element.canvas.graphic;

public enum LineBevel {

	RAISED(0x1a), LOWERED(0x22), NONE(0x2), INSET(0xa), OUTSET(0x12), PLAIN(0x2);

	private final int bevel;

	private LineBevel(int bevel) {
		this.bevel = bevel;
	}

	public static LineBevel lookup(int bevel) {
		for (LineBevel t : LineBevel.values()) {
			if (t.bevel == bevel) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown Bevel " + bevel);
	}
}

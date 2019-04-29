package info.phosco.forms.translate.element.canvas;

public enum StyleWidth {

	STATIC(0x8000), VARIABLE(0x0);

	private final int style;

	private StyleWidth(int style) {
		this.style = style;
	}

	public static StyleWidth lookup(int style) {
		for (StyleWidth t : StyleWidth.values()) {
			if (t.style == style) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown StyleWidth " + style);
	}

}

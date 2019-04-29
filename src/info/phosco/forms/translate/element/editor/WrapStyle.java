package info.phosco.forms.translate.element.editor;

public enum WrapStyle {
	NONE(0x1), CHARACTER(0x2), WORD(0x4);

	private final int style;

	private WrapStyle(int style) {
		this.style = style;
	}

	public static WrapStyle lookup(int style) {
		for (WrapStyle t : WrapStyle.values()) {
			if (t.style == style) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown WrapStyle " + style);
	}
}

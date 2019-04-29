package info.phosco.forms.translate.element.window;

public enum WindowStyle {

	DOCUMENT(0x0), DIALOG(0x4000);

	private final int style;

	private WindowStyle(int style) {
		this.style = style;
	}

	public static WindowStyle lookup(int style) {
		for (WindowStyle t : WindowStyle.values()) {
			if (t.style == style) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown WindowStyle " + style);
	}
}

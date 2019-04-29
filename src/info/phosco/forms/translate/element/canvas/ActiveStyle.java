package info.phosco.forms.translate.element.canvas;

public enum ActiveStyle {

	NORMAL(0x0), BOLD(0x10000);

	private final int style;

	private ActiveStyle(int style) {
		this.style = style;
	}

	public static ActiveStyle lookup(int style) {
		for (ActiveStyle t : ActiveStyle.values()) {
			if (t.style == style) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown ActiveStyle " + style);
	}
}

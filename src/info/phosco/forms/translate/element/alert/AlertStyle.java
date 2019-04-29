package info.phosco.forms.translate.element.alert;


public enum AlertStyle {
	STOP(0x1), WARNING(0x2), NOTE(0x4);

	private final int style;

	private AlertStyle(int style) {
		this.style = style;
	}

	public static AlertStyle lookup(int style) {
		for (AlertStyle t : AlertStyle.values()) {
			if (t.style == style) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown WarningStyle " + style);
	}
}

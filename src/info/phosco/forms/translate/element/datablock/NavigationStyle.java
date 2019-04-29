package info.phosco.forms.translate.element.datablock;

public enum NavigationStyle {

	SAME_RECORD(0x0), CHANGE_RECORD(0x1), CHANGE_DATA_BLOCK(0x2);

	private final int style;

	private NavigationStyle(int orientation) {
		this.style = orientation;
	}

	public static NavigationStyle lookup(int style) {
		for (NavigationStyle t : NavigationStyle.values()) {
			if (t.style == style) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown NavigationStyle " + style);
	}
}

package info.phosco.forms.translate.element.application;

public enum MouseNavigation {

	OBJECT(0x1), RECORD(0x2), BLOCK(0x3), FORM(0x4);

	private final int navi;

	private MouseNavigation(int navi) {
		this.navi = navi;
	}

	public static MouseNavigation lookup(int navi) {
		for (MouseNavigation t : MouseNavigation.values()) {
			if (t.navi == navi) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown MouseNavigation " + navi);
	}
}

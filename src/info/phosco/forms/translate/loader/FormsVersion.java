package info.phosco.forms.translate.loader;

public enum FormsVersion {

	FORMS_6(0xD6), FORMS_9(0xDC), FORMS_10(0xDD), FORMS_11(0xE0), UNKNOWN(0xFF);

	private final int hex;

	private FormsVersion(int version) {
		this.hex = version;
	}

	public int hex() {
		return this.hex;
	}

	public static FormsVersion lookup(int hex) {
		for (FormsVersion t : FormsVersion.values()) {
			if (t.hex == hex) {
				return t;
			}
		}
		return FormsVersion.UNKNOWN;
	}

}

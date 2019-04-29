package info.phosco.forms.translate.element.application;

public enum ValidationUnit {

	STANDARD(0x0), OBJECT(0x1), RECORD(0x2), BLOCK(0x3), FORM(0x4);

	private final int unit;

	private ValidationUnit(int unit) {
		this.unit = unit;
	}

	public static ValidationUnit lookup(int unit) {
		for (ValidationUnit t : ValidationUnit.values()) {
			if (t.unit == unit) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown ValidationUnit " + unit);
	}
}

package info.phosco.forms.translate.element.application;

public enum DeferRequired {

	NO(0x4), YES(0x5), FOUR_FIVE(0x7);

	private final int value;

	private DeferRequired(int value) {
		this.value = value;
	}

	public static DeferRequired lookup(int value) {
		for (DeferRequired t : DeferRequired.values()) {
			if (t.value == value) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown DeferRequired " + value);
	}

}

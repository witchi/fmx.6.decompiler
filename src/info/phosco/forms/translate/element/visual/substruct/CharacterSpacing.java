package info.phosco.forms.translate.element.visual.substruct;

public enum CharacterSpacing {

	ULTRA_THIN(0x1),
	EXTRA_THIN(0x2),
	THIN(0x3),
	HALF_THIN(0x4),
	NORMAL(0x5),
	HALF_WIDE(0x6),
	WIDE(0x7),
	EXTRA_WIDE(0x8),
	ULTRA_WIDE(0x9);

	private final int spacing;

	private CharacterSpacing(int spacing) {
		this.spacing = spacing;
	}

	public static CharacterSpacing lookup(int spacing) {
		for (CharacterSpacing t : CharacterSpacing.values()) {
			if (t.spacing == spacing) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown CharacterSpacing " + Integer.toHexString(spacing));
	}
}

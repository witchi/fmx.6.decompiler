package info.phosco.forms.translate.element.visual.substruct;

public enum FontWeight {

	ULTRA_LEAN(0x1),
	EXTRA_LEAN(0x2),
	LEAN(0x3),
	HALF_LEAN(0x4),
	MIDDLE(0x5),
	HALF_BOLD(0x6),
	BOLD(0x7),
	EXTRA_BOLD(0x8),
	ULTRA_BOLD(0x9);

	private final int weight;

	private FontWeight(int weight) {
		this.weight = weight;
	}

	public static FontWeight lookup(int weight) {
		for (FontWeight t : FontWeight.values()) {
			if (t.weight == weight) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown FontWeight " + Integer.toHexString(weight));
	}
}

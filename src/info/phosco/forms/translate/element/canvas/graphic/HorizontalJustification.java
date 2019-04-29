package info.phosco.forms.translate.element.canvas.graphic;

public enum HorizontalJustification {

	LEFT(0x0), CENTER(0x10), RIGHT(0x20), START(0x30), END(0x40);

	private final int justification;

	private HorizontalJustification(int justification) {
		this.justification = justification;
	}

	public static HorizontalJustification lookup(int justification) {
		for (HorizontalJustification t : HorizontalJustification.values()) {
			if (t.justification == justification) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown HorizontalJustification " + justification);
	}
}

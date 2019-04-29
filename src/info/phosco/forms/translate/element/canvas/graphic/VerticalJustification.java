package info.phosco.forms.translate.element.canvas.graphic;

public enum VerticalJustification {

	TOP(0x0), CENTER(0x40), BOTTOM(0x80);

	private final int justification;

	private VerticalJustification(int justification) {
		this.justification = justification;
	}

	public static VerticalJustification lookup(int justification) {
		for (VerticalJustification t : VerticalJustification.values()) {
			if (t.justification == justification) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown VerticalJustification " + justification);
	}
}

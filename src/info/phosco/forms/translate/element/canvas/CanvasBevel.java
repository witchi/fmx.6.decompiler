package info.phosco.forms.translate.element.canvas;

public enum CanvasBevel {

	NONE(0x1), LOWERED(0x1), RAISED(0x1), NORMAL(0x1), SHADE_BELOW(0x2), SHADE_ABOVE(0x3);

	private final int shape;

	private CanvasBevel(int shape) {
		this.shape = shape;
	}

	public static CanvasBevel lookup(int shape) {
		for (CanvasBevel t : CanvasBevel.values()) {
			if (t.shape == shape) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown CanvasShape " + shape);
	}

}

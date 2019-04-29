package info.phosco.forms.translate.element.window;

public enum WindowShape {

	// TODO: check the values, there is no difference between the options
	NONE(0x0), SHADE_ABOVE(0x2), NORMAL(0x2), RAISED(0x2), SUNKEN(0x2), 
	SHADE_BELOW(0x2);

	private final int shape;

	private WindowShape(int shape) {
		this.shape = shape;
	}

	public static WindowShape lookup(int shape) {
		for (WindowShape t : WindowShape.values()) {
			if (t.shape == shape) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown WindowShape " + shape);
	}
}

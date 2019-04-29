package info.phosco.forms.translate.element.canvas.graphic;

public enum LineSpacing {

	SINGLE(0x0), ONE_AND_A_HALF(0x1), DOUBLE(0x2), CUSTOM(0x3);

	private final int spacing;

	private LineSpacing(int spacing) {
		this.spacing = spacing;
	}

	public static LineSpacing lookup(int spacing) {
		for (LineSpacing t : LineSpacing.values()) {
			if (t.spacing == spacing) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown LineSpacing " + spacing);
	}
}

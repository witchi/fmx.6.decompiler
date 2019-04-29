package info.phosco.forms.translate.element.canvas;

public enum CanvasType {

	CONTENT(0x0), STACKED(0x1), H_TOOLBAR(0x2), V_TOOLBAR(0x3), TAB(0x4);

	private final int type;

	private CanvasType(int type) {
		this.type = type;
	}

	public static CanvasType lookup(int type) {
		for (CanvasType t : CanvasType.values()) {
			if (t.type == type) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown CanvasType " + type);
	}

}

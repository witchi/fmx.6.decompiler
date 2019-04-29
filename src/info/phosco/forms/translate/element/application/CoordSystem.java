package info.phosco.forms.translate.element.application;

public enum CoordSystem {

	UNIT(0x0), CHARACTER(0x1);

	private final int mode;

	private CoordSystem(int mode) {
		this.mode = mode;
	}

	public static CoordSystem lookup(int mode) {
		for (CoordSystem t : CoordSystem.values()) {
			if (t.mode == mode) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown CoordSystem " + mode);
	}
}

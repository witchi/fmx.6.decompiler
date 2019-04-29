package info.phosco.forms.translate.element.datablock;

public enum RecordOrientation {

	VERTICAL(0x0), HORIZONTAL(0x20);

	private final int orientation;

	private RecordOrientation(int orientation) {
		this.orientation = orientation;
	}

	public static RecordOrientation lookup(int orientation) {
		for (RecordOrientation t : RecordOrientation.values()) {
			if (t.orientation == orientation) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown RecordOrientation " + orientation);
	}
}

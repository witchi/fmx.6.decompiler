package info.phosco.forms.translate.element.recordgroup.column;

public enum ColumnDatatype {
	CHAR(0x1), NUMBER(0x3), DATE(0x2);

	private final int type;

	private ColumnDatatype(int type) {
		this.type = type;
	}

	public static ColumnDatatype lookup(int type) {
		for (ColumnDatatype t : ColumnDatatype.values()) {
			if (t.type == type) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown ColumnDatatype " + type);
	}
}

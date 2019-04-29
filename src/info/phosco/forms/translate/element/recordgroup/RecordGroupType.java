package info.phosco.forms.translate.element.recordgroup;

public enum RecordGroupType {

	// TODO: instead 0x3/0x12/0x13 use only one bit
	STATIC(0x0), QUERY(0x10);

	private final int type;

	private RecordGroupType(int type) {
		this.type = type;
	}

	public static RecordGroupType lookup(int type) {
		for (RecordGroupType t : RecordGroupType.values()) {
			if (t.type == type) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown RecordGroupType " + type);
	}
}

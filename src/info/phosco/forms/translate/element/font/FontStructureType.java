package info.phosco.forms.translate.element.font;

public enum FontStructureType {

	NORMAL(0x07FE), EMPTY(0x7FC);

	private final int type;

	private FontStructureType(int type) {
		this.type = type;
	}

	public static FontStructureType lookup(int type) {
		for (FontStructureType t : FontStructureType.values()) {
			if (t.type == type) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown FontStructureType " + type);
	}

}

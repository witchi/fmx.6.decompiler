package info.phosco.forms.translate.element.visual.attribute;

public enum VisualGroupType {

	DEFAULT(0x0), COMMON(0x1), PROMPT(0x2), TITLE(0x3);

	private final int type;

	private VisualGroupType(int type) {
		this.type = type;
	}

	public static VisualGroupType lookup(int type) {
		for (VisualGroupType t : VisualGroupType.values()) {
			if (t.type == type) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown VisualGroupType " + type);
	}
}

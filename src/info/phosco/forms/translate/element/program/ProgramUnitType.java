package info.phosco.forms.translate.element.program;

public enum ProgramUnitType {

	PROCEDURE_OR_FUNCTION(0x1), PACKAGE_SPEC(0x2), PACKAGE_BODY(0x4);

	private final int type;

	private ProgramUnitType(int type) {
		this.type = type;
	}

	public static ProgramUnitType lookup(int type) {
		for (ProgramUnitType t : ProgramUnitType.values()) {
			if (t.type == type) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown ProgramUnitType 0x" + Integer.toHexString(type));
	}
}

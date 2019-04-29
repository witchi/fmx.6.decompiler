package info.phosco.forms.translate.element.datablock;

public enum LockingMode {

	// TODO: check the values
	AUTOMATIC(0xe), DELAYED(0x3), IMMEDIATE(0x2);

	private final int mode;

	private LockingMode(int mode) {
		this.mode = mode;
	}

	public static LockingMode lookup(int mode) {
		for (LockingMode t : LockingMode.values()) {
			if (t.mode == mode) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown LockingMode " + mode);
	}
}

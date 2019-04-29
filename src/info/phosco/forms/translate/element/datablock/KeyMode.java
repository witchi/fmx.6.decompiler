package info.phosco.forms.translate.element.datablock;

public enum KeyMode {

	// TODO: check the values
	AUTOMATIC(0xd), NON_UPDATEABLE(0x8), UPDATEABLE(0x1), UNIQUE(0x0);

	private final int mode;

	private KeyMode(int mode) {
		this.mode = mode;
	}

	public static KeyMode lookup(int mode) {
		for (KeyMode t : KeyMode.values()) {
			if (t.mode == mode) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown KeyMode " + mode);
	}
}

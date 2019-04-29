package info.phosco.forms.translate.element.application;

public enum InteractionMode {

	BLOCK(0x9), NO_BLOCK(0xa);

	private final int mode;

	private InteractionMode(int mode) {
		this.mode = mode;
	}

	public static InteractionMode lookup(int mode) {
		for (InteractionMode t : InteractionMode.values()) {
			if (t.mode == mode) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown InteractionMode " + mode);
	}
}

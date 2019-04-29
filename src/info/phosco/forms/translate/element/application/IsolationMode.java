package info.phosco.forms.translate.element.application;

public enum IsolationMode {

	SAVE_ON_READ(0xb), SERIALIZABLE(0xc);

	private final int mode;

	private IsolationMode(int mode) {
		this.mode = mode;
	}

	public static IsolationMode lookup(int mode) {
		for (IsolationMode t : IsolationMode.values()) {
			if (t.mode == mode) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown IsolationMode " + mode);
	}
}

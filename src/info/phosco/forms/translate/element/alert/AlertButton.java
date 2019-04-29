package info.phosco.forms.translate.element.alert;

public enum AlertButton {
	FIRST(0x8), SECOND(0x10), THIRD(0x20);

	private final int button;

	private AlertButton(int button) {
		this.button = button;
	}

	public static AlertButton lookup(int button) {
		for (AlertButton t : AlertButton.values()) {
			if (t.button == button) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown WarningStyle " + button);
	}
}

package info.phosco.forms.translate.element.application;

public enum MenuSource {

	DATABASE(0x0), FILE(0x1);

	private final int source;

	private MenuSource(int source) {
		this.source = source;
	}

	public static MenuSource lookup(int source) {
		for (MenuSource t : MenuSource.values()) {
			if (t.source == source) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown MenuSource " + source);
	}
}

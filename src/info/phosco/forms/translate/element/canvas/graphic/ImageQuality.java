package info.phosco.forms.translate.element.canvas.graphic;

public enum ImageQuality {

	HIGH(0x0), MEDIUM(0x1), LOW(0x2);

	private final int quality;

	private ImageQuality(int quality) {
		this.quality = quality;
	}

	public static ImageQuality lookup(int quality) {
		for (ImageQuality t : ImageQuality.values()) {
			if (t.quality == quality) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown ImageQuality " + quality);
	}
}

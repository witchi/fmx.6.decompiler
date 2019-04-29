package info.phosco.forms.translate.element;

public enum ElementType {

	EDITOR(0x2), WINDOW(0x7), CANVAS(0x6), ALERT(0xA), PARAMETER(0xD),

	// TODO: check the values
	GROUP(0x18020202),
	LINE(0x50205),
	ARC(0x30203),

	IMAGE(0x40204),

	RECTANGLE(0x80208),
	TEXT(0x090209),
	FRAME(0xb020b),

	TRIGGER(0xF7),
	LIBRARY(0xF8),
	TEXT_PART(0xF9),
	FONT(0xFA),
	DATA_BLOCK(0xFB),
	RECORD_GROUP_COLUMN(0xFC),
	RECORD_GROUP(0xFD), // could be 0x3!
	VISUAL_GROUP(0xFE),
	MODULE(0xFF),
	PROGRAM_UNIT(0x9);

	private final int hex;

	private ElementType(int hex) {
		this.hex = hex;
	}

	public int hex() {
		return this.hex;
	}

	public static ElementType lookup(int hex) {
		for (ElementType t : ElementType.values()) {
			if (t.hex == hex) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown FormElement Type 0x" + Integer.toHexString(hex));
	}
}

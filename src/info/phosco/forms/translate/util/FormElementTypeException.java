package info.phosco.forms.translate.util;

public class FormElementTypeException extends DecompilerException {

	private static final long serialVersionUID = -8189854387199828464L;

	private final int type;
	private final int pos;

	public FormElementTypeException(int type, int pos) {
		this.type = type;
		this.pos = pos;
	}

	@Override
	public String getMessage() {
		return "The file contains an unknown/unexpected form element type (0x" + Integer.toHexString(this.type)
				+ ") on position 0x" + Integer.toHexString(this.pos) + ".";
	}
}

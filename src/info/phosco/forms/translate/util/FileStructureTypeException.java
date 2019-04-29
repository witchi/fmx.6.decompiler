package info.phosco.forms.translate.util;

public class FileStructureTypeException extends DecompilerException {

	private static final long serialVersionUID = -8189854387199828464L;

	private final int type;
	private final int pos;

	public FileStructureTypeException(int type, int pos) {
		this.type = type;
		this.pos = pos;
	}

	@Override
	public String getMessage() {
		return "The file contains an unknown/unexpected structure type ("
				+ this.type + ") on position " + this.pos + ".";
	}
}

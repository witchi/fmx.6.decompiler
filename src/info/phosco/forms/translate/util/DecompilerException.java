package info.phosco.forms.translate.util;

public class DecompilerException extends Exception {

	private static final long serialVersionUID = -8189854387199828464L;

	@Override
	public String getMessage() {
		return "Decompiler cannot recognize file structures.";
	}
}

package info.phosco.forms.translate.util;

import java.util.Arrays;

public class NumberFormatException extends DecompilerException {

	private static final long serialVersionUID = -5627810239184586322L;
	private final byte[] array;

	public NumberFormatException(byte[] array) {
		this.array = Arrays.copyOf(array, array.length);
	}

	@Override
	public String getMessage() {
		String out = "There is an unknown number representation within the FMX.\n";
		out += "Length : " + array.length + "\n";
		out += "Content: " + array.toString() + "\n";
		return out;
	}
}

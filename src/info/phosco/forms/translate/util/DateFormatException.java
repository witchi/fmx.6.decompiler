package info.phosco.forms.translate.util;

import java.util.Arrays;

public class DateFormatException extends DecompilerException {

	private static final long serialVersionUID = 8414314085574892487L;

	private final int[] array;

	public DateFormatException(int[] array) {
		this.array = Arrays.copyOf(array, array.length);
	}

	@Override
	public String getMessage() {
		String out = "There is an unknown date representation within the FMX.\n";
		out += "Length : " + array.length + "\n";
		out += "Content: " + ArrayHexFormatter.format(array) + "\n";
		return out;
	}
}

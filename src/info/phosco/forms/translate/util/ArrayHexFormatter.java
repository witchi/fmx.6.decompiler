package info.phosco.forms.translate.util;

public class ArrayHexFormatter {

	public static String format(int[] array) {
		String out = "";
		for (int v : array) {
			out += "0x" + Integer.toHexString(v) + " ";
		}
		return out.trim();
	}
}

package info.phosco.forms.translate.util;

import info.phosco.forms.translate.bytes.AbstractFileStructure;

import java.util.ArrayList;

public class HexFormatter {

	private boolean ascii;

	private boolean address;

	private boolean absolute;

	private int width;

	public HexFormatter() {
		this.absolute = false;
		this.ascii = false;
		this.address = false;
		this.width = 24;
	}

	public HexFormatter enableAbsolutePos(boolean absolute) {
		this.absolute = absolute;
		return this;
	}

	public HexFormatter enableAscii(boolean ascii) {
		this.ascii = ascii;
		return this;
	}

	public HexFormatter enableAdresses(boolean address) {
		this.address = address;
		return this;
	}

	public HexFormatter setWidth(int width) {
		this.width = width;
		return this;
	}

	private String repeatChars(String c, int repeat) {
		String res = "";
		for (int i = 0; i < repeat; i++) {
			res += c;
		}
		return res;
	}

	private String toHex(int i) {
		return ((i < 0x10 ? "0" : "") + Integer.toHexString(i));
	}

	private boolean isPrintable(int i) {
		return (i >= 32 && i <= 126);
	}

	public String format(AbstractFileStructure buffer) {

		int len = buffer.getLength();

		StringBuffer res = new StringBuffer(len * 3);

		ArrayList<String> bytes = new ArrayList<String>();
		ArrayList<String> absolute = new ArrayList<String>();
		ArrayList<String> address = new ArrayList<String>();
		ArrayList<String> ascii = new ArrayList<String>();

		int value;

		String currBytes = "";
		String currAscii = "";

		for (int i = 0; i < len; i++) {

			if (i > 0 && i % 8 == 0 && i % this.width != 0) {
				currBytes += "  ";
			}

			if (i % width == 0) {

				// EOL
				if (i > 0) {
					bytes.add(currBytes);
					ascii.add(currAscii);
					currBytes = "";
					currAscii = "";
				}

				// relative address in buffer
				if (this.address) {
					String hex = toHex(i);
					address.add("0x" + repeatChars("0", toHex(len).length() - hex.length()) + hex);
				}

				// absolute address
				if (this.absolute) {
					String hex = toHex(buffer.getAbsolutePosition() + i);
					absolute.add("0x"
							+ repeatChars("0",
									toHex(buffer.getAbsolutePosition() + buffer.getLength()).length() - hex.length())
							+ hex);
				}

			}

			// store value
			value = buffer.getByte(i);
			currBytes += toHex(value) + " ";

			// printable
			if (this.ascii) {
				currAscii += (isPrintable(value) ? "" + ((char) value) : ".");
			}

		}

		// padding bytes last line
		if (len % this.width != 0) {
			int missing = this.width - (len % this.width);
			currBytes += repeatChars("   ", missing);
			currBytes += repeatChars("  ", missing / 8);
		}

		// last line
		bytes.add(currBytes);
		ascii.add(currAscii);

		// concat all parts
		for (int i = 0; i < bytes.size(); i++) {

			if (this.absolute) {
				res.append(absolute.get(i));
				res.append(" | ");
			}

			if (this.address) {
				res.append(address.get(i));
				res.append(" | ");
			}

			res.append(bytes.get(i));

			if (this.ascii) {
				res.append("  " + ascii.get(i));
			}

			res.append("\n");
		}

		return res.toString();

	}

}

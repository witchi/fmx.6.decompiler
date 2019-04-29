package info.phosco.forms.translate.bytes;

import info.phosco.forms.translate.util.HexFormatter;

import java.io.UnsupportedEncodingException;

public abstract class AbstractFileStructure {

	private final int absPos;

	private final int length;

	private final UnsignedByteBuffer content;

	public AbstractFileStructure(UnsignedByteBuffer buf, int absPos, int length) {
		this.length = length;
		this.absPos = absPos;
		this.content = UnsignedByteBuffer.wrap(buf, this.absPos, this.length);
	}

	public int getAbsolutePosition() {
		return this.absPos;
	}

	public int getLength() {
		return this.length;
	}

	public UnsignedByteBuffer getContent() {
		return this.content;
	}

	protected int alignTo32bit(int pos) {
		return pos + (pos % 4);
	}

	protected String convertToString(byte[] a) {
		try {
			return new String(a, "ISO-8859-1"); // TODO: this should match the
												// global charset?
		} catch (UnsupportedEncodingException e) {
			return "unsupported encoding error";
		}
	}

	protected byte[] readToNull(int pos) {
		return this.content.readToNull(pos);
	}

	protected byte[] getBytes(int pos, int count) {
		return this.content.getBytes(pos, count);
	}

	protected int getShort(int pos) {
		return this.content.getShort(pos);
	}

	protected int getInt(int pos) {
		return this.content.getInt(pos);
	}

	protected String getStringByLength(int pos, int length) {
		return convertToString(getBytes(pos, length));
	}

	protected String getTerminatedString(int pos) {
		return convertToString(readToNull(pos));
	}

	public int getByte(int pos) {
		return this.content.getByte(pos);
	}

	public String formatHex(boolean withAddress, boolean withAscii, boolean absolutePos, int width) {
		HexFormatter formatter = new HexFormatter().setWidth(width).enableAdresses(withAddress).enableAscii(withAscii)
				.enableAbsolutePos(absolutePos);
		return formatter.format(this);
	}

	public int findHex(int offset, int... hex) {
		return this.content.findHex(offset, hex);
	}
}

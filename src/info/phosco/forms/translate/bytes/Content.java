package info.phosco.forms.translate.bytes;

import info.phosco.forms.translate.util.FileStructureTypeException;
import info.phosco.forms.translate.util.Log;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Content extends AbstractFileStructure {

	private final static Logger log = Log.getLogger(Content.class);

	private final Header header;

	private final Text text;

	private final Element attribute;

	private final Footer footer;

	public Content(Footer footer, Element attribute, Text text, Header header, UnsignedByteBuffer buf) {
		super(buf, header.getLength(), attribute.getLength() + text.getLength());

		this.footer = footer;
		this.attribute = attribute;
		this.text = text;
		this.header = header;
	}

	public ArrayList<Integer> getObjectReferenceList() {
		return this.footer.getObjectReferenceList();
	}

	public ArrayList<Integer> getAttributeReferenceList() {
		return this.footer.getAttributeReferenceList();
	}

	public byte[] getByteArray(int address, int pos, int length) throws FileStructureTypeException {
		byte[] res = new byte[length];
		for (int i = 0; i < length; i++) {
			res[i] = (byte) getByte(address, pos + i);
		}
		return res;
	}

	public int[] getBytes(int address, int pos, int length) throws FileStructureTypeException {
		int[] res = new int[length];
		for (int i = 0; i < length; i++) {
			res[i] = getByte(address, pos + i);
		}
		return res;
	}

	public int getByte(int address, int pos) throws FileStructureTypeException {
		switch (FileStructureType.lookup(address & 0xFF)) {

		case TEXT:
			return this.text.getByte((address >> 0x8) + pos);

		case ATTRIBUTES:
			return this.attribute.getByte((address >> 0x8) + pos);

		default:
		}

		throw new FileStructureTypeException(address & 0xFF, pos);
	}

	public int getShort(int address, int pos) throws FileStructureTypeException {
		switch (FileStructureType.lookup(address & 0xFF)) {

		case TEXT:
			return this.text.getShort((address >> 0x8) + pos);

		case ATTRIBUTES:
			return this.attribute.getShort((address >> 0x8) + pos);

		default:
		}

		throw new FileStructureTypeException(address & 0xFF, pos);
	}

	public int getInt(int address, int pos) throws FileStructureTypeException {
		switch (FileStructureType.lookup(address & 0xFF)) {

		case TEXT:
			return this.text.getInt((address >> 0x8) + pos);

		case ATTRIBUTES:
			return this.attribute.getInt((address >> 0x8) + pos);

		default:
		}

		throw new FileStructureTypeException(address & 0xFF, pos);
	}

	public String getString(int address, int pos, int length) throws FileStructureTypeException {
		switch (FileStructureType.lookup(address & 0xFF)) {

		case TEXT:
			return this.text.getStringByLength((address >> 0x8) + pos, length);

		case ATTRIBUTES:
			return this.attribute.getStringByLength((address >> 0x8) + pos, length);

		default:
		}

		throw new FileStructureTypeException(address & 0xFF, pos);
	}

	public String getString(int address, int pos) throws FileStructureTypeException {
		switch (FileStructureType.lookup(address & 0xFF)) {

		case TEXT:
			return this.text.getTerminatedString((address >> 0x8) + pos);

		case ATTRIBUTES:
			return this.attribute.getTerminatedString((address >> 0x8) + pos);

		default:
		}

		throw new FileStructureTypeException(address & 0xFF, pos);
	}
}

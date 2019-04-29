package info.phosco.forms.translate.bytes;

import info.phosco.forms.translate.util.Log;

import java.util.ArrayList;
import java.util.logging.Logger;

public class AttributeReferences extends AbstractFileStructure {

	private final static Logger log = Log.getLogger(AttributeReferences.class);

	private static final int POS_REFERENCE_NBR = 0x0;

	private static final int POS_REFERENCES = 0x4;

	public AttributeReferences(UnsignedByteBuffer buf, int absPos, int len) {
		super(buf, absPos, len);
	}

	private int getNumberOfReferences() {
		return getInt(POS_REFERENCE_NBR);
	}

	private int makeAddressInAttributeStructure(int ref) {
		return (getInt(POS_REFERENCES + ref) << 0x8) + FileStructureType.ATTRIBUTES.id();
	}

	public ArrayList<Integer> getReferenceList() {
		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < getNumberOfReferences() * 4; i += 4) {
			res.add(makeAddressInAttributeStructure(i));
		}
		return res;
	}

}

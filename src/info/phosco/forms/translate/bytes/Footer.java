package info.phosco.forms.translate.bytes;

import java.util.ArrayList;

public class Footer extends AbstractFileStructure {

	private static final int POS_FOOTER_LENGTH = 0x24;

	private static final int POS_OBJECT_LIST_LEN = 0x4;

	private final ObjectReferences objects;

	private final AttributeReferences attributes;

	public Footer(UnsignedByteBuffer buf) {
		super(buf, buf.getLength() - (buf.getInt(POS_FOOTER_LENGTH) - 4), buf.getInt(POS_FOOTER_LENGTH) - 4);

		int absPos = getAbsolutePosition();
		int len = findHex(POS_OBJECT_LIST_LEN, 0xFF, 0xFF, 0xFF, 0xFF) + 4;

		this.objects = new ObjectReferences(buf, absPos, len);
		this.attributes = new AttributeReferences(buf, absPos + len, buf.getLength() - absPos - len);
	}

	public ObjectReferences getObjects() {
		return this.objects;
	}

	public ArrayList<Integer> getObjectReferenceList() {
		return this.objects.getReferenceList();
	}

	public AttributeReferences getAttributes() {
		return this.attributes;
	}

	public ArrayList<Integer> getAttributeReferenceList() {
		return this.attributes.getReferenceList();
	}
}

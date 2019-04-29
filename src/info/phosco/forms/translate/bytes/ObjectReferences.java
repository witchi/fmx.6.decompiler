package info.phosco.forms.translate.bytes;

import java.util.ArrayList;

public class ObjectReferences extends AbstractFileStructure {

	private static final int POS_REFERENCE_NBR = 0x0;

	private static final int POS_REFERENCES = 0x4;

	public ObjectReferences(UnsignedByteBuffer buf, int absPos, int len) {
		super(buf, absPos, len);
	}

	public ArrayList<Integer> getReferenceList() {
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		int pos = POS_REFERENCE_NBR;
		int count;
		
		while (true) {
			
			count = getInt(pos);
			if (count == 0xFFFFFFFF) {
				break;
			}
			
			for (int i = 0; i < count; i++) {
				pos += 4;
				res.add((getInt(POS_REFERENCES + i * 4) << 0x8) + FileStructureType.TEXT.id());
			}
			pos += 4;
		}
		
		return res;
	}

}

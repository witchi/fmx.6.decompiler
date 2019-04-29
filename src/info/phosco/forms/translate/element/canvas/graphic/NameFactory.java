package info.phosco.forms.translate.element.canvas.graphic;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class NameFactory {

	private static final int POS_NAME= 0x0;

	private static final int POS_NAME_LEN = 0x4;

	private NameFactory() {
	}
	
	public static String getName(Content content, int offset) throws FileStructureTypeException {
		
		int len = content.getInt(offset, POS_NAME_LEN);
		int ref = content.getInt(offset, POS_NAME);
		
		return content.getString(ref, 0, len);
	}
}

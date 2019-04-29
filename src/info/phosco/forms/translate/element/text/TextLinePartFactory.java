package info.phosco.forms.translate.element.text;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class TextLinePartFactory {

	private static final int POS_TEXT = 0x0;

	private static final int POS_FONT_INDEX = 0x4;

	private static final int POS_TEXT_LEN = 0x8;

	public static TextLinePart getPart(Content content, int offset) throws FileStructureTypeException {

		TextLinePart res = new TextLinePart(offset);

		int len = content.getInt(offset, POS_TEXT_LEN);
		int ref = content.getInt(offset, POS_TEXT);
		res.setProperty(TextLinePartAttributes.TEXT, content.getString(ref, 0, len));

		res.setProperty(TextLinePartAttributes.FONT_INDEX, content.getInt(offset, POS_FONT_INDEX) - 1);

		return res;
	}
}

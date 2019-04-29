package info.phosco.forms.translate.element.text;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class TextLineFactory {

	private static final int TEXT_PART_SIZE = 0x14;

	public static TextLine getLine(Content content, int offset, int parts) throws FileStructureTypeException {

		TextLine res = new TextLine(offset);

		for (int i = 0; i < parts; i++) {

			int ref = offset + ((i * TEXT_PART_SIZE) << 8);
			res.add(TextLinePartFactory.getPart(content, ref));
		}

		return res;
	}
}

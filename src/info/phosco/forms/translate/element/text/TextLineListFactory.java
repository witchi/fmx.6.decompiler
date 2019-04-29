package info.phosco.forms.translate.element.text;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.util.FileStructureTypeException;

import java.util.ArrayList;
import java.util.List;

public class TextLineListFactory {

	private static final int POS_LINE = 0x0;
	
	private static final int POS_LINE_PART_COUNT = 0x4;
	
	

	private TextLineListFactory() {
	}

	public static List<TextLine> getList(Content content, int offset, int lines) throws FileStructureTypeException {

		ArrayList<TextLine> res = new ArrayList<TextLine>();

		for (int i = 0; i < lines; i++) {

			int ref = content.getInt(offset, POS_LINE + (i * 8));
			int parts = content.getInt(offset, POS_LINE_PART_COUNT + (i*8));
			res.add(TextLineFactory.getLine(content, ref, parts));
		}
		return res;
	}
}

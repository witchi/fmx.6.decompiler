package info.phosco.forms.translate.element.font;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.util.FileStructureTypeException;
import info.phosco.forms.translate.util.Log;

import java.util.logging.Logger;

public class FontListFactory {

	private final static Logger log = Log.getLogger(FontListFactory.class);

	private static final int SIZEOF_FONT_STRUCTURE = 0x38;

	private FontListFactory() {
	}

	public static ElementList<FormFont> get(Content content, int offset, int length) throws FileStructureTypeException {

		ElementList<FormFont> res = new ElementList<FormFont>();
		if (offset == 0x0) {
			return res;
		}

		for (int i = 0; i < length; i++) {
			int pos = offset + ((i * SIZEOF_FONT_STRUCTURE) << 8);
			res.add(FormFontFactory.instance(content, pos));
		}

		return res;
	}

}

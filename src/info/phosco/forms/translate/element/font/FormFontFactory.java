package info.phosco.forms.translate.element.font;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.element.visual.substruct.FontStyle;
import info.phosco.forms.translate.element.visual.substruct.FontWeight;
import info.phosco.forms.translate.util.FileStructureTypeException;
import info.phosco.forms.translate.util.Log;

import java.util.logging.Logger;

public class FormFontFactory extends AbstractFactory {

	private final static Logger log = Log.getLogger(FormFontFactory.class);

	private static final int POS_STRUCTURE_TYPE = 0x0;
	
	private static final int POS_FONT_NAME = 0x8;

	private static final int POS_FONT_SIZE = 0x14;

	private static final int POS_FONT_STYLE = 0x18;

	private static final int POS_FONT_WEIGHT = 0x1C;

	private static final int UNKNOWN_3 = 0x20;

	private static final int UNKNOWN_4 = 0x2C;

	private static final int UNKNOWN_5 = 0x30;

	private FormFontFactory() {
	}

	public static FormFont instance(Content content, int offset) throws FileStructureTypeException {

		FormFont res = new FormFont(offset);

		if (FontStructureType.lookup(content.getInt(offset, POS_STRUCTURE_TYPE)) != FontStructureType.NORMAL) {
			return res;
		}
		
		int ref = content.getInt(offset, POS_FONT_NAME);
		res.setProperty(FontAttributes.FONT_NAME, content.getString(ref, 0));

		res.setProperty(FontAttributes.FONT_SIZE, content.getInt(offset, POS_FONT_SIZE) / 100);
		res.setProperty(FontAttributes.FONT_WEIGHT, FontWeight.lookup(content.getInt(offset, POS_FONT_WEIGHT)));
		res.setProperty(FontAttributes.FONT_STYLE, FontStyle.lookup(content.getInt(offset, POS_FONT_STYLE)));

		// TODO: read properties

		return res;
	}
}

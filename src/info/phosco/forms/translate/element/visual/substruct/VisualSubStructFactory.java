package info.phosco.forms.translate.element.visual.substruct;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class VisualSubStructFactory extends AbstractFactory {

	private static final int POS_LOGICAL_ATTRIBUTE = 0x8;

	private static final int POS_FOREGROUND = 0xC;

	private static final int POS_BACKGROUND = 0x10;

	private static final int POS_FILL_PATTERN = 0x14;

	private static final int POS_FONT_NAME = 0x18;

	private static final int POS_FONT_SIZE = 0x1C;

	private static final int POS_FONT_STYLE = 0x20;

	private static final int POS_FONT_WEIGHT = 0x24;

	private static final int POS_CHARACTER_SPACING = 0x28;

	private static final int POS_VISUAL_BITMASK = 0x44;

	private VisualSubStructFactory() {
	}

	public static VisualSubStruct instance(Content content, int offset) throws FileStructureTypeException {
		VisualSubStruct res = new VisualSubStruct(offset);
		
		if (offset == 0) {
			return res; // sub-structure doesn't exist
		}

		int bitmask = content.getShort(offset, POS_VISUAL_BITMASK);

		res.setProperty(VisualAttributes.VALID_FOREGROUND, !bool(bitmask & 0x2));
		res.setProperty(VisualAttributes.VALID_BACKGROUND, !bool(bitmask & 0x4));
		res.setProperty(VisualAttributes.VALID_LOGICAL_ATTRIBUTE, !bool(bitmask & 0x8));
		res.setProperty(VisualAttributes.VALID_FILL_PATTERN, !bool(bitmask & 0x10));
		res.setProperty(VisualAttributes.VALID_FONT_NAME, !bool(bitmask & 0x20));
		res.setProperty(VisualAttributes.VALID_FONT_SIZE, !bool(bitmask & 0x40));
		res.setProperty(VisualAttributes.VALID_FONT_STYLE, !bool(bitmask & 0x80));
		res.setProperty(VisualAttributes.VALID_FONT_WEIGHT, !bool(bitmask & 0x100));
		res.setProperty(VisualAttributes.VALID_CHARACTER_SPACING, !bool(bitmask & 0x200));
		res.setProperty(VisualAttributes.VALID_WHITE_ON_BLACK, !bool(bitmask & 0x400));

		if ((Boolean) res.getProperty(VisualAttributes.VALID_WHITE_ON_BLACK)) {
			res.setProperty(VisualAttributes.WHITE_ON_BLACK, !bool(bitmask & 0x1));
		}

		if ((Boolean) res.getProperty(VisualAttributes.VALID_LOGICAL_ATTRIBUTE)) {
			int ref = content.getInt(offset, POS_LOGICAL_ATTRIBUTE);
			res.setProperty(VisualAttributes.LOGICAL_ATTRIBUTE, (ref == 0 ? "" : content.getString(ref, 0)));
		}

		if ((Boolean) res.getProperty(VisualAttributes.VALID_FOREGROUND)) {
			res.setProperty(VisualAttributes.FOREGROUND, Color.lookup(content.getInt(offset, POS_FOREGROUND)));
		}

		if ((Boolean) res.getProperty(VisualAttributes.VALID_BACKGROUND)) {
			res.setProperty(VisualAttributes.BACKGROUND, Color.lookup(content.getInt(offset, POS_BACKGROUND)));
		}

		if ((Boolean) res.getProperty(VisualAttributes.VALID_FILL_PATTERN)) {
			res.setProperty(VisualAttributes.FILL_PATTERN, FillPattern.lookup(content.getInt(offset, POS_FILL_PATTERN)));
		}

		if ((Boolean) res.getProperty(VisualAttributes.VALID_FONT_NAME)) {
			int ref = content.getInt(offset, POS_FONT_NAME);
			res.setProperty(VisualAttributes.FONT_NAME, (ref == 0 ? "" : content.getString(ref, 0)));
		}

		if ((Boolean) res.getProperty(VisualAttributes.VALID_FONT_SIZE)) {
			// TODO: is Fontsize/100 only for coord-System "Point"
			res.setProperty(VisualAttributes.FONT_SIZE, content.getInt(offset, POS_FONT_SIZE) / 100);
		}

		if ((Boolean) res.getProperty(VisualAttributes.VALID_FONT_STYLE)) {
			res.setProperty(VisualAttributes.FONT_STYLE, FontStyle.lookup(content.getInt(offset, POS_FONT_STYLE)));
		}

		if ((Boolean) res.getProperty(VisualAttributes.VALID_FONT_WEIGHT)) {
			res.setProperty(VisualAttributes.FONT_WEIGHT, FontWeight.lookup(content.getInt(offset, POS_FONT_WEIGHT)));
		}

		if ((Boolean) res.getProperty(VisualAttributes.VALID_CHARACTER_SPACING)) {
			res.setProperty(VisualAttributes.CHARACTER_SPACING,
					CharacterSpacing.lookup(content.getInt(offset, POS_CHARACTER_SPACING)));
		}

		return res;
	}
}

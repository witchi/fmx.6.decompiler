package info.phosco.forms.translate.element.canvas.graphic;

import java.util.List;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.element.Direction;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.font.FormFont;
import info.phosco.forms.translate.element.text.TextLine;
import info.phosco.forms.translate.element.text.TextLineListFactory;
import info.phosco.forms.translate.element.text.TextLinePart;
import info.phosco.forms.translate.element.text.TextLinePartAttributes;
import info.phosco.forms.translate.element.visual.substruct.Color;
import info.phosco.forms.translate.element.visual.substruct.FillPattern;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class FormTextFactory extends AbstractFactory {

	private static final int POS_NAME_SUBSTRUCT = 0x34;

	private static final int POS_THICKNESS = 0x3C;

	private static final int POS_EDGE_FOREGROUND = 0x42;

	private static final int POS_EDGE_BACKGROUND = 0x43;

	private static final int POS_EDGE_PATTERN = 0x44;

	private static final int POS_FOREGROUND = 0x45;

	private static final int POS_BACKGROUND = 0x46;

	private static final int POS_FILL_PATTERN = 0x47;

	private static final int POS_BITMASK1 = 0x48;

	private static final int POS_BEVEL = 0x49;

	private static final int POS_TEXT_SUBSTRUCT = 0x4C;

	private static final int POS_X = 0x50;

	private static final int POS_Y = 0x54;

	private static final int POS_TEXT_LINES = 0x68;

	private static final int POS_WIDTH = 0x6c;

	private static final int POS_HEIGHT = 0x70;

	private static final int POS_CUSTOM_SPACING = 0x74;

	private static final int POS_BITMASK2 = 0x78;

	private static final int POS_BITMASK3 = 0x79;

	private static final int POS_BITMASK4 = 0x7A;

	private FormTextFactory() {
	}

	@SuppressWarnings("unchecked")
	public static FormText instance(Content content, int offset, ElementList<FormFont> fontList) throws FileStructureTypeException {

		FormText res = new FormText(offset);

		int substruct = content.getInt(offset, POS_NAME_SUBSTRUCT);
		res.setProperty(GraphicAttributes.NAME, NameFactory.getName(content, substruct));

		substruct = content.getInt(offset, POS_TEXT_SUBSTRUCT);
		int nbrLines = content.getInt(offset, POS_TEXT_LINES);
		res.setProperty(GraphicAttributes.TEXT_LINES, TextLineListFactory.getList(content, substruct, nbrLines));

		res.setProperty(GraphicAttributes.X, content.getInt(offset, POS_X));
		res.setProperty(GraphicAttributes.Y, content.getInt(offset, POS_Y));
		res.setProperty(GraphicAttributes.WIDTH, content.getInt(offset, POS_WIDTH));
		res.setProperty(GraphicAttributes.HEIGHT, content.getInt(offset, POS_HEIGHT));

		res.setProperty(GraphicAttributes.FOREGROUND, Color.lookup(content.getByte(offset, POS_FOREGROUND)));
		res.setProperty(GraphicAttributes.BACKGROUND, Color.lookup(content.getByte(offset, POS_BACKGROUND)));
		res.setProperty(GraphicAttributes.FILL_PATTERN, FillPattern.lookup(content.getByte(offset, POS_FILL_PATTERN)));

		res.setProperty(GraphicAttributes.EDGE_FOREGROUND, Color.lookup(content.getByte(offset, POS_EDGE_FOREGROUND)));
		res.setProperty(GraphicAttributes.EDGE_BACKGROUND, Color.lookup(content.getByte(offset, POS_EDGE_BACKGROUND)));
		res.setProperty(GraphicAttributes.EDGE_PATTERN, FillPattern.lookup(content.getByte(offset, POS_EDGE_PATTERN)));

		res.setProperty(GraphicAttributes.DIRECTION, Direction.lookup((content.getByte(offset, POS_BITMASK2) >> 2) & 0x3));

		res.setProperty(GraphicAttributes.JOIN_STYLE, JoinStyle.lookup(content.getByte(offset, POS_BITMASK1) & 0x60));
		res.setProperty(GraphicAttributes.CAP_STYLE, CapStyle.lookup(content.getByte(offset, POS_BITMASK1) & 0x18));
		res.setProperty(GraphicAttributes.DASH_STYLE, DashStyle.lookup(content.getByte(offset, POS_BITMASK1) & 0x7));

		res.setProperty(GraphicAttributes.THICKNESS, content.getInt(offset, POS_THICKNESS));

		res.setProperty(GraphicAttributes.WRAP_TEXT, !bool(content.getByte(offset, POS_BITMASK4) & 0x2));
		res.setProperty(GraphicAttributes.BOX_SCALEABLE, !bool(content.getByte(offset, POS_BITMASK4) & 0x4));
		res.setProperty(GraphicAttributes.FONT_SCALEABLE, !bool(content.getByte(offset, POS_BITMASK4) & 0x8));

		res.setProperty(GraphicAttributes.LINE_SPACING, LineSpacing.lookup(content.getByte(offset, POS_BITMASK2) & 0x3));
		res.setProperty(GraphicAttributes.CUSTOM_SPACING, content.getInt(offset, POS_CUSTOM_SPACING));

		res.setProperty(GraphicAttributes.H_JUSTIFICATION, HorizontalJustification.lookup(content.getByte(offset, POS_BITMASK2) & 0x70));
		res.setProperty(GraphicAttributes.V_JUSTIFICATION, VerticalJustification.lookup(content.getByte(offset, POS_BITMASK3) & 0xC0));

		res.setProperty(GraphicAttributes.H_ORIGIN, HorizontalOrigin.lookup(content.getByte(offset, POS_BITMASK3) & 0x3));
		res.setProperty(GraphicAttributes.V_ORIGIN, VerticalOrigin.lookup(content.getByte(offset, POS_BITMASK3) & 0xC));

		res.setProperty(GraphicAttributes.BEVEL, TextBevel.lookup(content.getByte(offset, POS_BEVEL)));

		// TODO: read properties (Border, Rotation, Visual Attribute Class)

		mapFontToText((List<TextLine>) res.getProperty(GraphicAttributes.TEXT_LINES), fontList);
		return res;
	}

	private static void mapFontToText(List<TextLine> text, ElementList<FormFont> fontList) {

		for (int i = 0; i < text.size(); i++) {

			List<TextLinePart> parts = text.get(i).getParts();
			for (int j = 0; j < parts.size(); j++) {
				TextLinePart p = parts.get(j);
				p.setProperty(TextLinePartAttributes.FONT, fontList.get((int) p.getProperty(TextLinePartAttributes.FONT_INDEX)));
			}
		}
	}
}

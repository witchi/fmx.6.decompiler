package info.phosco.forms.translate.element.canvas.graphic;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.element.visual.substruct.Color;
import info.phosco.forms.translate.element.visual.substruct.FillPattern;
import info.phosco.forms.translate.util.FileStructureTypeException;
import info.phosco.forms.translate.util.Log;

import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Logger;

public class FormLineFactory extends AbstractFactory {

	private final static Logger log = Log.getLogger(FormLineFactory.class);

	private static final int POS_X = 0xC;

	private static final int POS_Y = 0x10;

	private static final int POS_WIDTH = 0x14;

	private static final int POS_HEIGHT = 0x18;

	private static final int POS_SUBSTRUCT = 0x34;

	private static final int POS_THICKNESS = 0x3C;

	private static final int POS_ROTATION_ANGLE = 0x40;

	private static final int POS_EDGE_FOREGROUND = 0x42;

	private static final int POS_EDGE_BACKGROUND = 0x43;

	private static final int POS_EDGE_PATTERN = 0x44;

	private static final int POS_FOREGROUND = 0x45;

	private static final int POS_BACKGROUND = 0x46;

	private static final int POS_FILL_PATTERN = 0x47;

	private static final int POS_BITMASK = 0x48;

	private static final int POS_BEVEL = 0x49;

	private static final int POS_ARROW_STYLE = 0x6C;

	private FormLineFactory() {
	}

	public static FormLine instance(Content content, int offset) throws FileStructureTypeException {

		FormLine res = new FormLine(offset);

		res.setProperty(GraphicAttributes.X, content.getInt(offset, POS_X));
		res.setProperty(GraphicAttributes.Y, content.getInt(offset, POS_Y));
		res.setProperty(GraphicAttributes.WIDTH, content.getInt(offset, POS_WIDTH));
		res.setProperty(GraphicAttributes.HEIGHT, content.getInt(offset, POS_HEIGHT));

		res.setProperty(GraphicAttributes.THICKNESS, content.getInt(offset, POS_THICKNESS));

		res.setProperty(GraphicAttributes.JOIN_STYLE, JoinStyle.lookup(content.getByte(offset, POS_BITMASK) & 0x60));
		res.setProperty(GraphicAttributes.CAP_STYLE, CapStyle.lookup(content.getByte(offset, POS_BITMASK) & 0x18));
		res.setProperty(GraphicAttributes.DASH_STYLE, DashStyle.lookup(content.getByte(offset, POS_BITMASK) & 0x7));

		res.setProperty(GraphicAttributes.FOREGROUND, Color.lookup(content.getByte(offset, POS_FOREGROUND)));
		res.setProperty(GraphicAttributes.BACKGROUND, Color.lookup(content.getByte(offset, POS_BACKGROUND)));
		res.setProperty(GraphicAttributes.FILL_PATTERN, FillPattern.lookup(content.getByte(offset, POS_FILL_PATTERN)));

		res.setProperty(GraphicAttributes.EDGE_FOREGROUND, Color.lookup(content.getByte(offset, POS_EDGE_FOREGROUND)));
		res.setProperty(GraphicAttributes.EDGE_BACKGROUND, Color.lookup(content.getByte(offset, POS_EDGE_BACKGROUND)));
		res.setProperty(GraphicAttributes.EDGE_PATTERN, FillPattern.lookup(content.getByte(offset, POS_EDGE_PATTERN)));

		res.setProperty(GraphicAttributes.ROTATION_ANGLE, content.getShort(offset, POS_ROTATION_ANGLE) >> 6);
		if (res.isRotation()) {
			ArrayList<Point> list = new ArrayList<Point>();
			res.setProperty(GraphicAttributes.COORDINATE_LIST, list);

			// TODO: get the coords

		}
		res.setProperty(GraphicAttributes.BEVEL, LineBevel.lookup(content.getByte(offset, POS_BEVEL)));
		res.setProperty(GraphicAttributes.ARROW_STYLE, ArrowStyle.lookup(content.getByte(offset, POS_ARROW_STYLE)));

		int substruct = content.getInt(offset, POS_SUBSTRUCT);
		res.setProperty(GraphicAttributes.NAME, NameFactory.getName(content, substruct));

		// TODO: read properties

		return res;
	}
}

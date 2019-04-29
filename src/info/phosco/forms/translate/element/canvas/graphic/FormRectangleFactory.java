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

public class FormRectangleFactory extends AbstractFactory {

	private final static Logger log = Log.getLogger(FormRectangleFactory.class);

	private static final int POS_BORDER_X = 0x1C;

	private static final int POS_BORDER_Y = 0x20;

	private static final int POS_BORDER_WIDTH = 0x24;

	private static final int POS_BORDER_HEIGHT = 0x28;

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

	private static final int POS_X = 0x4C;

	private static final int POS_Y = 0x50;

	private static final int POS_WIDTH = 0x54;

	private static final int POS_HEIGHT = 0x58;

	private static final int POS_X0 = 0x5C;

	private static final int POS_Y0 = 0x78;

	private static final int POS_X1 = 0x64;

	private static final int POS_Y1 = 0x70;

	private static final int POS_X2 = 0x6C;

	private static final int POS_Y2 = 0x68;

	private static final int POS_X3 = 0x74;

	private static final int POS_Y3 = 0x60;

	private FormRectangleFactory() {
	}

	public static FormRectangle instance(Content content, int offset) throws FileStructureTypeException {

		FormRectangle res = new FormRectangle(offset);

		res.setProperty(GraphicAttributes.ROTATION_ANGLE, content.getShort(offset, POS_ROTATION_ANGLE) >> 6);

		res.setProperty(GraphicAttributes.X, content.getInt(offset, POS_X));
		res.setProperty(GraphicAttributes.Y, content.getInt(offset, POS_Y));
		res.setProperty(GraphicAttributes.WIDTH, content.getInt(offset, POS_WIDTH));
		res.setProperty(GraphicAttributes.HEIGHT, content.getInt(offset, POS_HEIGHT));

		res.setProperty(GraphicAttributes.BORDER_X, content.getInt(offset, POS_BORDER_X));
		res.setProperty(GraphicAttributes.BORDER_Y, content.getInt(offset, POS_BORDER_Y));
		res.setProperty(GraphicAttributes.BORDER_WIDTH, content.getInt(offset, POS_BORDER_WIDTH));
		res.setProperty(GraphicAttributes.BORDER_HEIGHT, content.getInt(offset, POS_BORDER_HEIGHT));

		if (res.isRotation()) {
			ArrayList<Point> list = new ArrayList<Point>();
			res.setProperty(GraphicAttributes.COORDINATE_LIST, list);

			Point p = new Point(content.getInt(offset, POS_X0), content.getInt(offset, POS_Y0));
			list.add(p);
			p = new Point(content.getInt(offset, POS_X1), content.getInt(offset, POS_Y1));
			list.add(p);
			p = new Point(content.getInt(offset, POS_X2), content.getInt(offset, POS_Y2));
			list.add(p);
			p = new Point(content.getInt(offset, POS_X3), content.getInt(offset, POS_Y3));
			list.add(p);

			// TODO: where are the border coordinates?
		}

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

		res.setProperty(GraphicAttributes.BEVEL, RectangleBevel.lookup(content.getByte(offset, POS_BEVEL)));

		int substruct = content.getInt(offset, POS_SUBSTRUCT);
		res.setProperty(GraphicAttributes.NAME, NameFactory.getName(content, substruct));

		// TODO: read properties

		return res;
	}
}

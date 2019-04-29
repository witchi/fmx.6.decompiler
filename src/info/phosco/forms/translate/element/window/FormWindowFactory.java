package info.phosco.forms.translate.element.window;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.element.Direction;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStructFactory;
import info.phosco.forms.translate.util.Log;
import info.phosco.forms.translate.util.FileStructureTypeException;

import java.util.logging.Logger;

public class FormWindowFactory extends AbstractFactory {

	private final static Logger log = Log.getLogger(FormWindowFactory.class);

	private static final int POS_NAME = 0x8;

	private static final int POS_MIN_TITLE = 0xC;

	private static final int POS_MIN_TITLE_LEN = 0x10;

	private static final int POS_BITMASK = 0x1C;

	private static final int POS_X = 0x20;

	private static final int POS_Y = 0x24;

	private static final int POS_WIDTH = 0x28;

	private static final int POS_HEIGHT = 0x2C;

	private static final int POS_VISUAL_SUBSTRUCT = 0x30;

	private static final int POS_TITLE = 0x50;

	private static final int POS_TITLE_LEN = 0x54;

	private static final int POS_CANVAS = 0x58;

	private static final int POS_DIRECTION = 0x68;

	private static final int POS_HELP_THEME = 0x70;

	private FormWindowFactory() {
	}

	public static FormWindow instance(Content content, int offset) throws FileStructureTypeException {

		FormWindow res = new FormWindow(offset);

		int ref = content.getInt(offset, POS_NAME);
		res.setProperty(WindowAttributes.NAME, content.getString(ref, 2, content.getShort(ref, 0)));

		res.setProperty(WindowAttributes.X, content.getInt(offset, POS_X));
		res.setProperty(WindowAttributes.Y, content.getInt(offset, POS_Y));
		res.setProperty(WindowAttributes.WIDTH, content.getInt(offset, POS_WIDTH));
		res.setProperty(WindowAttributes.HEIGHT, content.getInt(offset, POS_HEIGHT));

		int bitmask = content.getInt(offset, POS_BITMASK);

		res.setProperty(WindowAttributes.STYLE, WindowStyle.lookup(bitmask & 0x4000));
		res.setProperty(WindowAttributes.MODAL, !bool(bitmask & 0x1));
		res.setProperty(WindowAttributes.SHAPE, WindowShape.lookup(bitmask & 0x2));
		res.setProperty(WindowAttributes.SHOW_VSCROLLER, !bool(bitmask & 0x4));
		res.setProperty(WindowAttributes.HIDE_ON_CLOSE, !bool(bitmask & 0x10));
		res.setProperty(WindowAttributes.INHERIT_MENU, !bool(bitmask & 0x20));
		res.setProperty(WindowAttributes.SCALE, bool(bitmask & 0x40));
		res.setProperty(WindowAttributes.CLOSE, bool(bitmask & 0x80));
		res.setProperty(WindowAttributes.MOVE, bool(bitmask & 0x100));
		res.setProperty(WindowAttributes.MAXIMIZE, bool(bitmask & 0x200));
		res.setProperty(WindowAttributes.MINIMIZE, bool(bitmask & 0x400));
		res.setProperty(WindowAttributes.SHOW_HSCROLLER, !bool(bitmask & 0x800));

		ref = content.getInt(offset, POS_MIN_TITLE);
		int refLen = content.getInt(offset, POS_MIN_TITLE_LEN);
		res.setProperty(WindowAttributes.MIN_TITLE, (ref == 0 ? "" : content.getString(ref, 0, refLen)));

		ref = content.getInt(offset, POS_TITLE);
		refLen = content.getInt(offset, POS_TITLE_LEN);
		res.setProperty(WindowAttributes.TITLE, (ref == 0 ? "" : content.getString(ref, 0, refLen)));

		res.setProperty(WindowAttributes.DIRECTION, Direction.lookup(content.getInt(offset, POS_DIRECTION)));

		ref = content.getInt(offset, POS_HELP_THEME);
		res.setProperty(WindowAttributes.HELP, (ref == 0 ? "" : content.getString(ref, 0)));

		res.setProperty(WindowAttributes.PRIMARY_CANVAS, content.getInt(offset, POS_CANVAS));

		// it points also to a global visual group, if there is inheritance
		// TODO: we have to look for known visual group instances to build the
		// graph
		ref = content.getInt(offset, POS_VISUAL_SUBSTRUCT);
		res.setProperty(WindowAttributes.VISUAL_STRUCT, VisualSubStructFactory.instance(content, ref));

		// TODO: read properties

		return res;
	}
}

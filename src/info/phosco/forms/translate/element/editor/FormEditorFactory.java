package info.phosco.forms.translate.element.editor;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStructFactory;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class FormEditorFactory extends AbstractFactory {

	private final static int POS_NAME = 0x4;

	private final static int POS_TITLE = 0xC;

	private final static int POS_FUNCTIONAL_COMMENT = 0x14;

	private final static int POS_BITMASK = 0x1C;

	private final static int POS_X = 0x20;

	private final static int POS_Y = 0x24;

	private final static int POS_WIDTH = 0x28;

	private final static int POS_HEIGHT = 0x2C;

	private final static int POS_VISUAL_SUBSTRUCT = 0x30;

	private FormEditorFactory() {
	}

	public static FormEditor instance(Content content, int offset) throws FileStructureTypeException {
		FormEditor res = new FormEditor(offset);

		int ref = content.getInt(offset, POS_NAME);
		res.setProperty(EditorAttributes.NAME, content.getString(ref, 2, content.getShort(ref, 0)));

		ref = content.getInt(offset, POS_TITLE);
		res.setProperty(EditorAttributes.TITLE, content.getString(ref, 0));

		ref = content.getInt(offset, POS_FUNCTIONAL_COMMENT);
		if (ref != 0x0) {
			res.setProperty(EditorAttributes.FUNCTIONAL_COMMENT, content.getString(ref, 0));
		}

		int bitmask = content.getInt(offset, POS_BITMASK);

		res.setProperty(EditorAttributes.WRAP_STYLE, WrapStyle.lookup(bitmask & 0x7));
		res.setProperty(EditorAttributes.V_SCROLLBAR, bool(bitmask & 0x8));

		res.setProperty(EditorAttributes.X, content.getInt(offset, POS_X));
		res.setProperty(EditorAttributes.Y, content.getInt(offset, POS_Y));
		res.setProperty(EditorAttributes.WIDTH, content.getInt(offset, POS_WIDTH));
		res.setProperty(EditorAttributes.HEIGHT, content.getInt(offset, POS_HEIGHT));

		ref = content.getInt(offset, POS_VISUAL_SUBSTRUCT);
		res.setProperty(EditorAttributes.VISUAL_STRUCT, VisualSubStructFactory.instance(content, ref));

		// TODO: read properties

		return res;
	}

}

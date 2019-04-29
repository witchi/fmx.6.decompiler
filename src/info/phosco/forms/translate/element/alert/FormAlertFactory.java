package info.phosco.forms.translate.element.alert;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.element.Direction;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStructFactory;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class FormAlertFactory extends AbstractFactory {

	private final static int POS_NAME = 0x4;

	private final static int POS_BUTTON_1 = 0x8;

	private final static int POS_BUTTON_1_LEN = 0xC;

	private final static int POS_BUTTON_2 = 0x10;

	private final static int POS_BUTTON_2_LEN = 0x14;

	private final static int POS_BUTTON_3 = 0x18;

	private final static int POS_BUTTON_3_LEN = 0x1C;

	private final static int POS_TITLE = 0x20;

	private final static int POS_TITLE_LEN = 0x24;

	private final static int POS_BITMASK = 0x28;

	private final static int POS_VISUAL_SUBSTRUCT = 0x2c;

	private final static int POS_MESSAGE = 0x38;

	private final static int POS_MESSAGE_LEN = 0x3C;

	private final static int POS_DIRECTION = 0x40;

	private FormAlertFactory() {
	}

	public static FormAlert instance(Content content, int offset) throws FileStructureTypeException {
		FormAlert res = new FormAlert(offset);

		int ref = content.getInt(offset, POS_NAME);
		res.setProperty(AlertAttributes.NAME, content.getString(ref, 2, content.getShort(ref, 0)));

		ref = content.getInt(offset, POS_BUTTON_1);
		int len = content.getInt(offset, POS_BUTTON_1_LEN);
		res.setProperty(AlertAttributes.BUTTON_1, (ref == 0x0 ? "" : content.getString(ref, 0, len)));

		ref = content.getInt(offset, POS_BUTTON_2);
		len = content.getInt(offset, POS_BUTTON_2_LEN);
		res.setProperty(AlertAttributes.BUTTON_2, (ref == 0x0 ? "" : content.getString(ref, 0, len)));

		ref = content.getInt(offset, POS_BUTTON_3);
		len = content.getInt(offset, POS_BUTTON_3_LEN);
		res.setProperty(AlertAttributes.BUTTON_3, (ref == 0x0 ? "" : content.getString(ref, 0, len)));

		ref = content.getInt(offset, POS_MESSAGE);
		len = content.getInt(offset, POS_MESSAGE_LEN);
		res.setProperty(AlertAttributes.MESSAGE, (ref == 0x0 ? "" : content.getString(ref, 0, len)));

		ref = content.getInt(offset, POS_TITLE);
		len = content.getInt(offset, POS_TITLE_LEN);
		res.setProperty(AlertAttributes.TITLE, (ref == 0x0 ? "" : content.getString(ref, 0, len)));

		int bitmask = content.getInt(offset, POS_BITMASK);

		res.setProperty(AlertAttributes.STYLE, AlertStyle.lookup(bitmask & 0x7));
		res.setProperty(AlertAttributes.DEFAULT_BUTTON, AlertButton.lookup(bitmask & 0x38));

		res.setProperty(AlertAttributes.DIRECTION, Direction.lookup(content.getInt(offset, POS_DIRECTION)));

		ref = content.getInt(offset, POS_VISUAL_SUBSTRUCT);
		res.setProperty(AlertAttributes.VISUAL_STRUCT, VisualSubStructFactory.instance(content, ref));

		// TODO: read properties

		return res;
	}

}

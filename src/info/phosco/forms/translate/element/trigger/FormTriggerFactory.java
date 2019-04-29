package info.phosco.forms.translate.element.trigger;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.util.FileStructureTypeException;

import java.util.List;

public class FormTriggerFactory extends AbstractFactory {

	private final static int POS_KEYBOARD_HELP_TEXT = 0x0;

	private final static int POS_TRIGGER_TYPE = 0xC;

	private final static int POS_BITMASK = 0x24;

	private final static int POS_TRIGGER_TEXT = 0x28;

	private FormTriggerFactory() {
	}

	public static FormTrigger instance(Content content, int offset, List<String> userNames) throws FileStructureTypeException {
		FormTrigger res = new FormTrigger(offset);

		int ref = content.getInt(offset, POS_KEYBOARD_HELP_TEXT);
		if (ref != 0x0) {
			res.setProperty(TriggerAttributes.KEYBOARD_HELP_TEXT, content.getString(ref, 0));
		}

		TriggerType type = TriggerType.lookup(content.getInt(offset, POS_TRIGGER_TYPE));
		res.setProperty(TriggerAttributes.TYPE, type);

		if (type == TriggerType.USER_NAMED) {
			res.setProperty(TriggerAttributes.NAME, userNames.get(content.getInt(offset, POS_TRIGGER_TYPE) * (-1) - 1));
		} else {
			res.setProperty(TriggerAttributes.NAME, type.getOracleName());
		}

		int bitmask = content.getInt(offset, POS_BITMASK);

		res.setProperty(TriggerAttributes.DISPLAY_KEYBOARD_HELP, bool(bitmask & 0x1));
		res.setProperty(TriggerAttributes.FIRE_ENTER_QUERY, !bool(bitmask & 0x8));

		res.setProperty(TriggerAttributes.STYLE, "PL/SQL");  // somewhere coded?
		
		// TODO: read properties

		return res;
	}

}

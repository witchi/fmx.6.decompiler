package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.trigger.FormTrigger;
import info.phosco.forms.translate.element.trigger.TriggerAttributes;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;

import java.util.ArrayList;
import java.util.List;

public class TriggerAttributeListFactory {

	public static List<Attribute> getList(FormTrigger trigger) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("trigger.general")));
		res.add(new Attribute(Resource.getString("trigger.general.name"), trigger.getName()));
		res.add(new Attribute(Resource.getString("trigger.general.offset"), "0x" + Integer.toHexString(trigger.getOffset())));

		res.add(new CaptionAttribute(Resource.getString("trigger.functional")));
		res.add(new Attribute(Resource.getString("trigger.functional.style"), trigger.getProperty(TriggerAttributes.STYLE)));
		res.add(new Attribute(Resource.getString("trigger.functional.fire"), trigger.getProperty(TriggerAttributes.FIRE_ENTER_QUERY)));

		res.add(new CaptionAttribute(Resource.getString("trigger.help")));
		res.add(new Attribute(Resource.getString("trigger.help.display"), trigger.getProperty(TriggerAttributes.DISPLAY_KEYBOARD_HELP)));
		res.add(new Attribute(Resource.getString("trigger.help.text"), trigger.getProperty(TriggerAttributes.KEYBOARD_HELP_TEXT)));

		return res;
	}
}

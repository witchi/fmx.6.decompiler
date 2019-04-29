package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.alert.AlertAttributes;
import info.phosco.forms.translate.element.alert.FormAlert;
import info.phosco.forms.translate.element.visual.substruct.VisualAttributes;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStruct;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;

import java.util.ArrayList;
import java.util.List;

public class AlertAttributeListFactory {

	public static List<Attribute> getList(FormAlert alert) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("alert.general")));
		res.add(new Attribute(Resource.getString("alert.general.name"), alert.getName()));
		res.add(new Attribute(Resource.getString("alert.general.offset"), "0x" + Integer.toHexString(alert.getOffset())));

		res.add(new CaptionAttribute(Resource.getString("alert.functional")));
		res.add(new Attribute(Resource.getString("alert.functional.title"), alert.getProperty(AlertAttributes.TITLE)));
		res.add(new Attribute(Resource.getString("alert.functional.message"), alert.getProperty(AlertAttributes.MESSAGE)));
		res.add(new Attribute(Resource.getString("alert.functional.alert_style"), alert.getProperty(AlertAttributes.STYLE)));
		res.add(new Attribute(Resource.getString("alert.functional.button_1_label"), alert.getProperty(AlertAttributes.BUTTON_1)));
		res.add(new Attribute(Resource.getString("alert.functional.button_2_label"), alert.getProperty(AlertAttributes.BUTTON_2)));
		res.add(new Attribute(Resource.getString("alert.functional.button_3_label"), alert.getProperty(AlertAttributes.BUTTON_3)));
		res.add(new Attribute(Resource.getString("alert.functional.default_alert_button"), alert.getProperty(AlertAttributes.DEFAULT_BUTTON)));

		res.add(new CaptionAttribute(Resource.getString("alert.visual")));
		VisualSubStruct vs = (VisualSubStruct) alert.getProperty(AlertAttributes.VISUAL_STRUCT);

		res.add(new Attribute(Resource.getString("alert.visual.offset"), "0x" + Integer.toHexString(vs.getOffset())));
		res.add(new Attribute(Resource.getString("alert.visual.character_mode"), vs.getProperty(VisualAttributes.LOGICAL_ATTRIBUTE)));
		res.add(new Attribute(Resource.getString("alert.visual.white_on_black"), vs.getProperty(VisualAttributes.WHITE_ON_BLACK)));

		res.add(new CaptionAttribute(Resource.getString("alert.color")));
		res.add(new Attribute(Resource.getString("alert.color.foreground"), vs.getProperty(VisualAttributes.FOREGROUND)));
		res.add(new Attribute(Resource.getString("alert.color.background"), vs.getProperty(VisualAttributes.BACKGROUND)));
		res.add(new Attribute(Resource.getString("alert.color.fill_pattern"), vs.getProperty(VisualAttributes.FILL_PATTERN)));

		res.add(new CaptionAttribute(Resource.getString("alert.font")));
		res.add(new Attribute(Resource.getString("alert.font.name"), vs.getProperty(VisualAttributes.FONT_NAME)));
		res.add(new Attribute(Resource.getString("alert.font.size"), vs.getProperty(VisualAttributes.FONT_SIZE)));
		res.add(new Attribute(Resource.getString("alert.font.weight"), vs.getProperty(VisualAttributes.FONT_WEIGHT)));
		res.add(new Attribute(Resource.getString("alert.font.style"), vs.getProperty(VisualAttributes.FONT_STYLE)));
		res.add(new Attribute(Resource.getString("alert.font.spacing"), vs.getProperty(VisualAttributes.CHARACTER_SPACING)));

		res.add(new CaptionAttribute(Resource.getString("alert.international")));
		res.add(new Attribute(Resource.getString("alert.international.direction"), alert.getProperty(AlertAttributes.DIRECTION)));

		return res;
	}
}

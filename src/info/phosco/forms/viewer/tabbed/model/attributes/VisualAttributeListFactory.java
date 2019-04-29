package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.visual.attribute.FormVisualGroup;
import info.phosco.forms.translate.element.visual.attribute.VisualGroupAttributes;
import info.phosco.forms.translate.element.visual.substruct.VisualAttributes;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStruct;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;

import java.util.ArrayList;
import java.util.List;

public class VisualAttributeListFactory {

	public static List<Attribute> getList(FormVisualGroup visual) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("visual.general")));
		res.add(new Attribute(Resource.getString("visual.general.name"), visual.getName()));
		res.add(new Attribute(Resource.getString("visual.general.group_type"), visual.getProperty(VisualGroupAttributes.GROUP_TYPE)));
		res.add(new Attribute(Resource.getString("visual.general.offset"), "0x" + Integer.toHexString(visual.getOffset())));

		res.add(new CaptionAttribute(Resource.getString("visual.visual")));
		VisualSubStruct vs = (VisualSubStruct) visual.getProperty(VisualGroupAttributes.VISUAL_STRUCT);

		res.add(new Attribute(Resource.getString("visual.visual.offset"), "0x" + Integer.toHexString(vs.getOffset())));

		if (visual.isCommon()) {
			res.add(new Attribute(Resource.getString("visual.visual.character_mode"), vs.getProperty(VisualAttributes.LOGICAL_ATTRIBUTE)));
			res.add(new Attribute(Resource.getString("visual.visual.white_on_black"), vs.getProperty(VisualAttributes.WHITE_ON_BLACK)));

			res.add(new CaptionAttribute(Resource.getString("visual.color")));
			res.add(new Attribute(Resource.getString("visual.color.foreground"), vs.getProperty(VisualAttributes.FOREGROUND)));
			res.add(new Attribute(Resource.getString("visual.color.background"), vs.getProperty(VisualAttributes.BACKGROUND)));
			res.add(new Attribute(Resource.getString("visual.color.fill_pattern"), vs.getProperty(VisualAttributes.FILL_PATTERN)));

			res.add(new CaptionAttribute(Resource.getString("visual.font")));
			res.add(new Attribute(Resource.getString("visual.font.name"), vs.getProperty(VisualAttributes.FONT_NAME)));
			res.add(new Attribute(Resource.getString("visual.font.size"), vs.getProperty(VisualAttributes.FONT_SIZE)));
			res.add(new Attribute(Resource.getString("visual.font.weight"), vs.getProperty(VisualAttributes.FONT_WEIGHT)));
			res.add(new Attribute(Resource.getString("visual.font.style"), vs.getProperty(VisualAttributes.FONT_STYLE)));
			res.add(new Attribute(Resource.getString("visual.font.spacing"), vs.getProperty(VisualAttributes.CHARACTER_SPACING)));
		}

		if (visual.isTitle()) {
			res.add(new CaptionAttribute(Resource.getString("visual.frame_title_color")));
			res.add(new Attribute(Resource.getString("visual.frame_title_color.foreground"), vs.getProperty(VisualAttributes.FOREGROUND)));
			res.add(new Attribute(Resource.getString("visual.frame_title_color.background"), vs.getProperty(VisualAttributes.BACKGROUND)));
			res.add(new Attribute(Resource.getString("visual.frame_title_color.fill_pattern"), vs.getProperty(VisualAttributes.FILL_PATTERN)));

			res.add(new CaptionAttribute(Resource.getString("visual.title_font")));
			res.add(new Attribute(Resource.getString("visual.title_font.name"), vs.getProperty(VisualAttributes.FONT_NAME)));
			res.add(new Attribute(Resource.getString("visual.title_font.size"), vs.getProperty(VisualAttributes.FONT_SIZE)));
			res.add(new Attribute(Resource.getString("visual.title_font.weight"), vs.getProperty(VisualAttributes.FONT_WEIGHT)));
			res.add(new Attribute(Resource.getString("visual.title_font.style"), vs.getProperty(VisualAttributes.FONT_STYLE)));
			res.add(new Attribute(Resource.getString("visual.title_font.spacing"), vs.getProperty(VisualAttributes.CHARACTER_SPACING)));
		}

		if (visual.isPrompt()) {
			res.add(new CaptionAttribute(Resource.getString("visual.prompt_color")));
			res.add(new Attribute(Resource.getString("visual.prompt_color.foreground"), vs.getProperty(VisualAttributes.FOREGROUND)));

			res.add(new CaptionAttribute(Resource.getString("visual.prompt_font")));
			res.add(new Attribute(Resource.getString("visual.prompt_font.name"), vs.getProperty(VisualAttributes.FONT_NAME)));
			res.add(new Attribute(Resource.getString("visual.prompt_font.size"), vs.getProperty(VisualAttributes.FONT_SIZE)));
			res.add(new Attribute(Resource.getString("visual.prompt_font.weight"), vs.getProperty(VisualAttributes.FONT_WEIGHT)));
			res.add(new Attribute(Resource.getString("visual.prompt_font.style"), vs.getProperty(VisualAttributes.FONT_STYLE)));
			res.add(new Attribute(Resource.getString("visual.prompt_font.spacing"), vs.getProperty(VisualAttributes.CHARACTER_SPACING)));
		}
		return res;
	}
}

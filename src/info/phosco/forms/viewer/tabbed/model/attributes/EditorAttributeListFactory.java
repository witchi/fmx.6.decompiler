package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.editor.EditorAttributes;
import info.phosco.forms.translate.element.editor.FormEditor;
import info.phosco.forms.translate.element.visual.substruct.VisualAttributes;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStruct;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;

import java.util.ArrayList;
import java.util.List;

public class EditorAttributeListFactory {

	public static List<Attribute> getList(FormEditor editor) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("editor.general")));
		res.add(new Attribute(Resource.getString("editor.general.name"), editor.getName()));
		res.add(new Attribute(Resource.getString("editor.general.offset"), "0x" + Integer.toHexString(editor.getOffset())));

		res.add(new CaptionAttribute(Resource.getString("editor.functional")));
		res.add(new Attribute(Resource.getString("editor.functional.title"), editor.getProperty(EditorAttributes.TITLE)));
		res.add(new Attribute(Resource.getString("editor.functional.bottom_title"), editor.getProperty(EditorAttributes.FUNCTIONAL_COMMENT)));
		res.add(new Attribute(Resource.getString("editor.functional.wrap_style"), editor.getProperty(EditorAttributes.WRAP_STYLE)));

		res.add(new CaptionAttribute(Resource.getString("editor.physical")));
		res.add(new Attribute(Resource.getString("editor.physical.x"), editor.getProperty(EditorAttributes.X)));
		res.add(new Attribute(Resource.getString("editor.physical.y"), editor.getProperty(EditorAttributes.Y)));
		res.add(new Attribute(Resource.getString("editor.physical.width"), editor.getProperty(EditorAttributes.WIDTH)));
		res.add(new Attribute(Resource.getString("editor.physical.height"), editor.getProperty(EditorAttributes.HEIGHT)));
		res.add(new Attribute(Resource.getString("editor.physical.vertical_scrollbar"), editor.getProperty(EditorAttributes.V_SCROLLBAR)));

		res.add(new CaptionAttribute(Resource.getString("editor.visual")));
		VisualSubStruct vs = (VisualSubStruct) editor.getProperty(EditorAttributes.VISUAL_STRUCT);

		res.add(new Attribute(Resource.getString("editor.visual.offset"), "0x" + Integer.toHexString(vs.getOffset())));
		res.add(new Attribute(Resource.getString("editor.visual.character_mode"), vs.getProperty(VisualAttributes.LOGICAL_ATTRIBUTE)));
		res.add(new Attribute(Resource.getString("editor.visual.white_on_black"), vs.getProperty(VisualAttributes.WHITE_ON_BLACK)));

		res.add(new CaptionAttribute(Resource.getString("editor.color")));
		res.add(new Attribute(Resource.getString("editor.color.foreground"), vs.getProperty(VisualAttributes.FOREGROUND)));
		res.add(new Attribute(Resource.getString("editor.color.background"), vs.getProperty(VisualAttributes.BACKGROUND)));
		res.add(new Attribute(Resource.getString("editor.color.fill_pattern"), vs.getProperty(VisualAttributes.FILL_PATTERN)));

		res.add(new CaptionAttribute(Resource.getString("editor.font")));
		res.add(new Attribute(Resource.getString("editor.font.name"), vs.getProperty(VisualAttributes.FONT_NAME)));
		res.add(new Attribute(Resource.getString("editor.font.size"), vs.getProperty(VisualAttributes.FONT_SIZE)));
		res.add(new Attribute(Resource.getString("editor.font.weight"), vs.getProperty(VisualAttributes.FONT_WEIGHT)));
		res.add(new Attribute(Resource.getString("editor.font.style"), vs.getProperty(VisualAttributes.FONT_STYLE)));
		res.add(new Attribute(Resource.getString("editor.font.spacing"), vs.getProperty(VisualAttributes.CHARACTER_SPACING)));

		return res;
	}
}

package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.visual.substruct.VisualAttributes;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStruct;
import info.phosco.forms.translate.element.window.FormWindow;
import info.phosco.forms.translate.element.window.WindowAttributes;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;

import java.util.ArrayList;
import java.util.List;

public class WindowAttributeListFactory {

	public static List<Attribute> getList(FormWindow window) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("window.general")));
		res.add(new Attribute(Resource.getString("window.general.name"), window.getName()));
		res.add(new Attribute(Resource.getString("window.general.offset"), "0x" + Integer.toHexString(window.getOffset())));
		res.add(new Attribute(Resource.getString("window.general.help_book_topic"), window.getProperty(WindowAttributes.HELP)));

		res.add(new CaptionAttribute(Resource.getString("window.functional")));
		res.add(new Attribute(Resource.getString("window.functional.title"), window.getProperty(WindowAttributes.TITLE)));
		res.add(new Attribute(Resource.getString("window.functional.primary_canvas"), "0x"
				+ Integer.toHexString((int) window.getProperty(WindowAttributes.PRIMARY_CANVAS))));
		res.add(new Attribute(Resource.getString("window.functional.window_style"), window.getProperty(WindowAttributes.STYLE)));
		res.add(new Attribute(Resource.getString("window.functional.modal"), window.getProperty(WindowAttributes.MODAL)));
		res.add(new Attribute(Resource.getString("window.functional.hide_on_exit"), window.getProperty(WindowAttributes.HIDE_ON_CLOSE)));
		res.add(new Attribute(Resource.getString("window.functional.close_allowed"), window.getProperty(WindowAttributes.CLOSE)));
		res.add(new Attribute(Resource.getString("window.functional.move_allowed"), window.getProperty(WindowAttributes.MOVE)));
		res.add(new Attribute(Resource.getString("window.functional.maximize_allowed"), window.getProperty(WindowAttributes.MAXIMIZE)));
		res.add(new Attribute(Resource.getString("window.functional.minimize_allowed"), window.getProperty(WindowAttributes.MINIMIZE)));
		res.add(new Attribute(Resource.getString("window.functional.minimized_title"), window.getProperty(WindowAttributes.MIN_TITLE)));
		res.add(new Attribute(Resource.getString("window.functional.inherit_menu"), window.getProperty(WindowAttributes.INHERIT_MENU)));

		res.add(new CaptionAttribute(Resource.getString("window.physical")));
		res.add(new Attribute(Resource.getString("window.physical.x"), window.getProperty(WindowAttributes.X)));
		res.add(new Attribute(Resource.getString("window.physical.y"), window.getProperty(WindowAttributes.Y)));
		res.add(new Attribute(Resource.getString("window.physical.width"), window.getProperty(WindowAttributes.WIDTH)));
		res.add(new Attribute(Resource.getString("window.physical.height"), window.getProperty(WindowAttributes.HEIGHT)));
		res.add(new Attribute(Resource.getString("window.physical.bevel"), window.getProperty(WindowAttributes.SHAPE)));
		res.add(new Attribute(Resource.getString("window.physical.horizontal_scrollbar"), window.getProperty(WindowAttributes.SHOW_HSCROLLER)));
		res.add(new Attribute(Resource.getString("window.physical.vertical_scrollbar"), window.getProperty(WindowAttributes.SHOW_VSCROLLER)));

		res.add(new CaptionAttribute(Resource.getString("window.visual")));
		VisualSubStruct vs = (VisualSubStruct) window.getProperty(WindowAttributes.VISUAL_STRUCT);

		res.add(new Attribute(Resource.getString("window.visual.offset"), "0x" + Integer.toHexString(vs.getOffset())));
		res.add(new Attribute(Resource.getString("window.visual.character_mode"), vs.getProperty(VisualAttributes.LOGICAL_ATTRIBUTE)));
		res.add(new Attribute(Resource.getString("window.visual.white_on_black"), vs.getProperty(VisualAttributes.WHITE_ON_BLACK)));

		res.add(new CaptionAttribute(Resource.getString("window.color")));
		res.add(new Attribute(Resource.getString("window.color.foreground"), vs.getProperty(VisualAttributes.FOREGROUND)));
		res.add(new Attribute(Resource.getString("window.color.background"), vs.getProperty(VisualAttributes.BACKGROUND)));
		res.add(new Attribute(Resource.getString("window.color.fill_pattern"), vs.getProperty(VisualAttributes.FILL_PATTERN)));

		res.add(new CaptionAttribute(Resource.getString("window.font")));
		res.add(new Attribute(Resource.getString("window.font.name"), vs.getProperty(VisualAttributes.FONT_NAME)));
		res.add(new Attribute(Resource.getString("window.font.size"), vs.getProperty(VisualAttributes.FONT_SIZE)));
		res.add(new Attribute(Resource.getString("window.font.weight"), vs.getProperty(VisualAttributes.FONT_WEIGHT)));
		res.add(new Attribute(Resource.getString("window.font.style"), vs.getProperty(VisualAttributes.FONT_STYLE)));
		res.add(new Attribute(Resource.getString("window.font.spacing"), vs.getProperty(VisualAttributes.CHARACTER_SPACING)));

		res.add(new CaptionAttribute(Resource.getString("window.international")));
		res.add(new Attribute(Resource.getString("window.international.direction"), window.getProperty(WindowAttributes.DIRECTION)));

		return res;
	}
}

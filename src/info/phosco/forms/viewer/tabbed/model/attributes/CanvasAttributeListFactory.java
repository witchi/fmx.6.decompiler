package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.canvas.CanvasAttributes;
import info.phosco.forms.translate.element.canvas.FormCanvas;
import info.phosco.forms.translate.element.visual.substruct.VisualAttributes;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStruct;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;

import java.util.ArrayList;
import java.util.List;

public class CanvasAttributeListFactory {

	public static List<Attribute> getList(FormCanvas canvas) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("canvas.general")));
		res.add(new Attribute(Resource.getString("canvas.general.name"), canvas.getName()));
		res.add(new Attribute(Resource.getString("canvas.general.offset"), "0x" + Integer.toHexString(canvas.getOffset())));
		res.add(new Attribute(Resource.getString("canvas.general.canvas_type"), canvas.getProperty(CanvasAttributes.CANVAS_TYPE)));
		res.add(new Attribute(Resource.getString("canvas.general.help"), canvas.getProperty(CanvasAttributes.HELP)));

		res.add(new CaptionAttribute(Resource.getString("canvas.functional")));
		res.add(new Attribute(Resource.getString("canvas.functional.raise_on_entry"), canvas.getProperty(CanvasAttributes.AUTOMATIC)));

		if (canvas.isStacked() || canvas.isRegister()) {
			res.add(new CaptionAttribute(Resource.getString("canvas.viewport")));
			res.add(new Attribute(Resource.getString("canvas.viewport.x"), canvas.getProperty(CanvasAttributes.VIEWPORT_X)));
			res.add(new Attribute(Resource.getString("canvas.viewport.y"), canvas.getProperty(CanvasAttributes.VIEWPORT_Y)));
			res.add(new Attribute(Resource.getString("canvas.viewport.width"), canvas.getProperty(CanvasAttributes.VIEWPORT_WIDTH)));
			res.add(new Attribute(Resource.getString("canvas.viewport.height"), canvas.getProperty(CanvasAttributes.VIEWPORT_HEIGHT)));
		}

		res.add(new CaptionAttribute(Resource.getString("canvas.physical")));
		res.add(new Attribute(Resource.getString("canvas.physical.visible"), canvas.getProperty(CanvasAttributes.VISIBLE)));
		res.add(new Attribute(Resource.getString("canvas.physical.window_offset"), "0x"
				+ Integer.toHexString((int) canvas.getProperty(CanvasAttributes.WINDOW))));

		if (!canvas.isScrollbar() && !canvas.isRegister()) {
			res.add(new Attribute(Resource.getString("canvas.physical.viewport_x_on_canvas"), canvas
					.getProperty(CanvasAttributes.VIEWPORT_X_ON_CANVAS)));
			res.add(new Attribute(Resource.getString("canvas.physical.viewport_y_on_canvas"), canvas
					.getProperty(CanvasAttributes.VIEWPORT_Y_ON_CANVAS)));
		}

		if (!canvas.isHorizontalScrollbar() && !canvas.isRegister()) {
			res.add(new Attribute(Resource.getString("canvas.physical.width"), canvas.getProperty(CanvasAttributes.WIDTH)));
		}
		if (!canvas.isVerticalScrollbar() && !canvas.isRegister()) {
			res.add(new Attribute(Resource.getString("canvas.physical.height"), canvas.getProperty(CanvasAttributes.HEIGHT)));
		}

		res.add(new Attribute(Resource.getString("canvas.physical.bevel"), canvas.getProperty(CanvasAttributes.BEVEL)));

		if (canvas.isRegister()) {
			res.add(new Attribute(Resource.getString("canvas.physical.corner_style"), canvas.getProperty(CanvasAttributes.EDGE_STYLE)));
			res.add(new Attribute(Resource.getString("canvas.physical.width_style"), canvas.getProperty(CanvasAttributes.STYLE_WIDTH)));
			res.add(new Attribute(Resource.getString("canvas.physical.active_style"), canvas.getProperty(CanvasAttributes.ACTIVE_STYLE)));
			res.add(new Attribute(Resource.getString("canvas.physical.tab_edge"), canvas.getProperty(CanvasAttributes.REGISTER_EDGE)));
		}

		if (canvas.isStacked()) {
			res.add(new Attribute(Resource.getString("canvas.physical.horizontal_scrollbar"), canvas.getProperty(CanvasAttributes.H_SCROLLBAR)));
			res.add(new Attribute(Resource.getString("canvas.physical.vertical_scrollbar"), canvas.getProperty(CanvasAttributes.V_SCROLLBAR)));
		}

		res.add(new CaptionAttribute(Resource.getString("canvas.visual")));
		VisualSubStruct vs = (VisualSubStruct) canvas.getProperty(CanvasAttributes.VISUAL_STRUCT);

		res.add(new Attribute(Resource.getString("canvas.visual.offset"), "0x" + Integer.toHexString(vs.getOffset())));
		res.add(new Attribute(Resource.getString("canvas.visual.character_mode"), vs.getProperty(VisualAttributes.LOGICAL_ATTRIBUTE)));
		res.add(new Attribute(Resource.getString("canvas.visual.white_on_black"), vs.getProperty(VisualAttributes.WHITE_ON_BLACK)));

		res.add(new CaptionAttribute(Resource.getString("canvas.color")));
		res.add(new Attribute(Resource.getString("canvas.color.foreground"), vs.getProperty(VisualAttributes.FOREGROUND)));
		res.add(new Attribute(Resource.getString("canvas.color.background"), vs.getProperty(VisualAttributes.BACKGROUND)));
		res.add(new Attribute(Resource.getString("canvas.color.fill_pattern"), vs.getProperty(VisualAttributes.FILL_PATTERN)));

		if (canvas.isRegister()) {
			res.add(new CaptionAttribute(Resource.getString("canvas.font")));
			res.add(new Attribute(Resource.getString("canvas.font.name"), vs.getProperty(VisualAttributes.FONT_NAME)));
			res.add(new Attribute(Resource.getString("canvas.font.size"), vs.getProperty(VisualAttributes.FONT_SIZE)));
			res.add(new Attribute(Resource.getString("canvas.font.weight"), vs.getProperty(VisualAttributes.FONT_WEIGHT)));
			res.add(new Attribute(Resource.getString("canvas.font.style"), vs.getProperty(VisualAttributes.FONT_STYLE)));
			res.add(new Attribute(Resource.getString("canvas.font.spacing"), vs.getProperty(VisualAttributes.CHARACTER_SPACING)));
		}

		res.add(new CaptionAttribute(Resource.getString("canvas.international")));
		res.add(new Attribute(Resource.getString("canvas.international.direction"), canvas.getProperty(CanvasAttributes.DIRECTION)));

		return res;
	}
}

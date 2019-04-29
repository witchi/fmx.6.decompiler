package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.canvas.graphic.FormText;
import info.phosco.forms.translate.element.canvas.graphic.GraphicAttributes;
import info.phosco.forms.translate.element.text.TextLine;
import info.phosco.forms.translate.element.text.TextLinePart;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;
import info.phosco.forms.viewer.tabbed.model.CoordinateSystem;

import java.util.ArrayList;
import java.util.List;

public class TextAttributeListFactory {

	private static String buildSimpleContent(List<TextLine> content) {
		StringBuffer b = new StringBuffer();

		for (TextLine l : content) {
			for (TextLinePart p : l.getParts()) {
				b.append(p.getContent());
			}
		}

		return b.toString();
	}

	@SuppressWarnings("unchecked")
	public static List<Attribute> getList(FormText text, CoordinateSystem coords) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("text.general")));
		res.add(new Attribute(Resource.getString("text.general.name"), text.getName()));
		res.add(new Attribute(Resource.getString("text.general.type"), text.getType()));
		res.add(new Attribute(Resource.getString("text.general.offset"), "0x" + Integer.toHexString(text.getOffset())));
		res.add(new Attribute(Resource.getString("text.general.content"), buildSimpleContent((List<TextLine>) text
				.getProperty(GraphicAttributes.TEXT_LINES))));

		res.add(new CaptionAttribute(Resource.getString("text.physical")));
		res.add(new Attribute(Resource.getString("text.physical.x"), coords.toUnit((int) text.getProperty(GraphicAttributes.X))));
		res.add(new Attribute(Resource.getString("text.physical.y"), coords.toUnit((int) text.getProperty(GraphicAttributes.Y))));
		res.add(new Attribute(Resource.getString("text.physical.width"), coords.toUnit((int) text.getProperty(GraphicAttributes.WIDTH))));
		res.add(new Attribute(Resource.getString("text.physical.height"), coords.toUnit((int) text.getProperty(GraphicAttributes.HEIGHT))));
		res.add(new Attribute(Resource.getString("text.physical.line_width"), coords.toPoint((int) text.getProperty(GraphicAttributes.THICKNESS))));
		res.add(new Attribute(Resource.getString("text.physical.dash_style"), text.getProperty(GraphicAttributes.DASH_STYLE)));
		res.add(new Attribute(Resource.getString("text.physical.cap_style"), text.getProperty(GraphicAttributes.CAP_STYLE)));
		res.add(new Attribute(Resource.getString("text.physical.join_style"), text.getProperty(GraphicAttributes.JOIN_STYLE)));
		res.add(new Attribute(Resource.getString("text.physical.rotation_angle"), text.getProperty(GraphicAttributes.ROTATION_ANGLE)));
		res.add(new Attribute(Resource.getString("text.physical.bevel"), text.getProperty(GraphicAttributes.BEVEL)));

		res.add(new CaptionAttribute(Resource.getString("text.visual")));
		res.add(new Attribute(Resource.getString("text.visual.visual_attribute_group"), Resource.getString("text.visual.not_included")));

		res.add(new CaptionAttribute(Resource.getString("text.color")));
		res.add(new Attribute(Resource.getString("text.color.foreground"), text.getProperty(GraphicAttributes.FOREGROUND)));
		res.add(new Attribute(Resource.getString("text.color.background"), text.getProperty(GraphicAttributes.BACKGROUND)));
		res.add(new Attribute(Resource.getString("text.color.fill_pattern"), text.getProperty(GraphicAttributes.FILL_PATTERN)));
		res.add(new Attribute(Resource.getString("text.color.edge_foreground"), text.getProperty(GraphicAttributes.EDGE_FOREGROUND)));
		res.add(new Attribute(Resource.getString("text.color.edge_background"), text.getProperty(GraphicAttributes.EDGE_BACKGROUND)));
		res.add(new Attribute(Resource.getString("text.color.edge_pattern"), text.getProperty(GraphicAttributes.EDGE_PATTERN)));

		res.add(new CaptionAttribute(Resource.getString("text.international")));
		res.add(new Attribute(Resource.getString("text.international.direction"), text.getProperty(GraphicAttributes.DIRECTION)));

		return res;
	}
}

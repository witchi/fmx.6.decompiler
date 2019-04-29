package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.canvas.graphic.FormRectangle;
import info.phosco.forms.translate.element.canvas.graphic.GraphicAttributes;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;
import info.phosco.forms.viewer.tabbed.model.CoordinateSystem;

import java.util.ArrayList;
import java.util.List;

public class RectangleAttributeListFactory {

	public static List<Attribute> getList(FormRectangle rect, CoordinateSystem coords) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("rectangle.general")));
		res.add(new Attribute(Resource.getString("rectangle.general.name"), rect.getName()));
		res.add(new Attribute(Resource.getString("rectangle.general.type"), rect.getType()));
		res.add(new Attribute(Resource.getString("rectangle.general.offset"), "0x" + Integer.toHexString(rect.getOffset())));

		res.add(new CaptionAttribute(Resource.getString("rectangle.physical")));
		res.add(new Attribute(Resource.getString("rectangle.physical.x"), coords.toUnit((int) rect.getProperty(GraphicAttributes.X))));
		res.add(new Attribute(Resource.getString("rectangle.physical.y"), coords.toUnit((int) rect.getProperty(GraphicAttributes.Y))));
		res.add(new Attribute(Resource.getString("rectangle.physical.width"), coords.toUnit((int) rect.getProperty(GraphicAttributes.WIDTH))));
		res.add(new Attribute(Resource.getString("rectangle.physical.height"), coords.toUnit((int) rect.getProperty(GraphicAttributes.HEIGHT))));
		
		res.add(new Attribute(Resource.getString("rectangle.physical.line_width"),
				coords.toPoint((int) rect.getProperty(GraphicAttributes.THICKNESS))));
		
		res.add(new Attribute(Resource.getString("rectangle.physical.dash_style"), rect.getProperty(GraphicAttributes.DASH_STYLE)));
		res.add(new Attribute(Resource.getString("rectangle.physical.cap_style"), rect.getProperty(GraphicAttributes.CAP_STYLE)));
		res.add(new Attribute(Resource.getString("rectangle.physical.join_style"), rect.getProperty(GraphicAttributes.JOIN_STYLE)));
		res.add(new Attribute(Resource.getString("rectangle.physical.rotation_angle"), rect.getProperty(GraphicAttributes.ROTATION_ANGLE)));
		res.add(new Attribute(Resource.getString("rectangle.physical.bevel"), rect.getProperty(GraphicAttributes.BEVEL)));

		res.add(new CaptionAttribute(Resource.getString("rectangle.visual")));
		res.add(new Attribute(Resource.getString("rectangle.visual.visual_attribute_group"), Resource.getString("rectangle.visual.not_included")));

		res.add(new CaptionAttribute(Resource.getString("rectangle.color")));
		res.add(new Attribute(Resource.getString("rectangle.color.foreground"), rect.getProperty(GraphicAttributes.FOREGROUND)));
		res.add(new Attribute(Resource.getString("rectangle.color.background"), rect.getProperty(GraphicAttributes.BACKGROUND)));
		res.add(new Attribute(Resource.getString("rectangle.color.fill_pattern"), rect.getProperty(GraphicAttributes.FILL_PATTERN)));
		res.add(new Attribute(Resource.getString("rectangle.color.edge_foreground"), rect.getProperty(GraphicAttributes.EDGE_FOREGROUND)));
		res.add(new Attribute(Resource.getString("rectangle.color.edge_background"), rect.getProperty(GraphicAttributes.EDGE_BACKGROUND)));
		res.add(new Attribute(Resource.getString("rectangle.color.edge_pattern"), rect.getProperty(GraphicAttributes.EDGE_PATTERN)));

		return res;
	}
}

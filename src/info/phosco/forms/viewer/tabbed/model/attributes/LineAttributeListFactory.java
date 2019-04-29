package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.canvas.graphic.FormLine;
import info.phosco.forms.translate.element.canvas.graphic.GraphicAttributes;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;
import info.phosco.forms.viewer.tabbed.model.CoordinateSystem;

import java.util.ArrayList;
import java.util.List;

public class LineAttributeListFactory {

	public static List<Attribute> getList(FormLine line, CoordinateSystem coords) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("line.general")));
		res.add(new Attribute(Resource.getString("line.general.name"), line.getName()));
		res.add(new Attribute(Resource.getString("line.general.type"), line.getType()));
		res.add(new Attribute(Resource.getString("line.general.offset"), "0x" + Integer.toHexString(line.getOffset())));

		res.add(new CaptionAttribute(Resource.getString("line.physical")));
		res.add(new Attribute(Resource.getString("line.physical.x"), coords.toUnit((int) line.getProperty(GraphicAttributes.X))));
		res.add(new Attribute(Resource.getString("line.physical.y"), coords.toUnit((int) line.getProperty(GraphicAttributes.Y))));
		res.add(new Attribute(Resource.getString("line.physical.width"), coords.toUnit((int) line.getProperty(GraphicAttributes.WIDTH))));
		res.add(new Attribute(Resource.getString("line.physical.height"), coords.toUnit((int) line.getProperty(GraphicAttributes.HEIGHT))));
		res.add(new Attribute(Resource.getString("line.physical.line_width"), coords.toPoint((int) line.getProperty(GraphicAttributes.THICKNESS))));
		res.add(new Attribute(Resource.getString("line.physical.dash_style"), line.getProperty(GraphicAttributes.DASH_STYLE)));
		res.add(new Attribute(Resource.getString("line.physical.arrow_style"), line.getProperty(GraphicAttributes.ARROW_STYLE)));
		res.add(new Attribute(Resource.getString("line.physical.cap_style"), line.getProperty(GraphicAttributes.CAP_STYLE)));
		res.add(new Attribute(Resource.getString("line.physical.join_style"), line.getProperty(GraphicAttributes.JOIN_STYLE)));
		res.add(new Attribute(Resource.getString("line.physical.rotation_angle"), line.getProperty(GraphicAttributes.ROTATION_ANGLE)));
		res.add(new Attribute(Resource.getString("line.physical.bevel"), line.getProperty(GraphicAttributes.BEVEL)));

		res.add(new CaptionAttribute(Resource.getString("line.visual")));
		res.add(new Attribute(Resource.getString("line.visual.visual_attribute_group"), Resource.getString("line.visual.not_included")));

		res.add(new CaptionAttribute(Resource.getString("line.color")));
		res.add(new Attribute(Resource.getString("line.color.foreground"), line.getProperty(GraphicAttributes.FOREGROUND)));
		res.add(new Attribute(Resource.getString("line.color.background"), line.getProperty(GraphicAttributes.BACKGROUND)));
		res.add(new Attribute(Resource.getString("line.color.fill_pattern"), line.getProperty(GraphicAttributes.FILL_PATTERN)));
		res.add(new Attribute(Resource.getString("line.color.edge_foreground"), line.getProperty(GraphicAttributes.EDGE_FOREGROUND)));
		res.add(new Attribute(Resource.getString("line.color.edge_background"), line.getProperty(GraphicAttributes.EDGE_BACKGROUND)));
		res.add(new Attribute(Resource.getString("line.color.edge_pattern"), line.getProperty(GraphicAttributes.EDGE_PATTERN)));

		return res;
	}
}

package info.phosco.forms.translate.element.canvas.graphic;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.application.CoordSystemUnit;

public class FormRectangle extends FormGraphic {

	FormRectangle(int offset) {
		super(offset);
	}

	@Override
	public ElementType getType() {
		return ElementType.RECTANGLE;
	}

	public Float convertToScreen(Integer value) {
		if (value == null) {
			return null;
		}
		return Math.round(CoordSystemUnit.POINT.convert(value) * 100f) / 100f;
	}

	@Override
	public String toString() {
		String out = super.toString();

		out += "\nLine Width                                 : "
				+ convertToScreen((int) getProperty(GraphicAttributes.THICKNESS));

		out += "\nDash Style                                 : " + getProperty(GraphicAttributes.DASH_STYLE);
		out += "\nCap Style                                  : " + getProperty(GraphicAttributes.CAP_STYLE);
		out += "\nJoin Style                                 : " + getProperty(GraphicAttributes.JOIN_STYLE);

		out += "\nRotation Angle                             : " + getProperty(GraphicAttributes.ROTATION_ANGLE);
		out += "\nBevel                                      : " + getProperty(GraphicAttributes.BEVEL);
		
		out += "\nVisual Attribute Group                     : not included";

		out += "\nForeground Color                           : " + getProperty(GraphicAttributes.FOREGROUND);
		out += "\nBackground Color                           : " + getProperty(GraphicAttributes.BACKGROUND);
		out += "\nFill Pattern                               : " + getProperty(GraphicAttributes.FILL_PATTERN);

		out += "\nEdge Foreground Color                      : " + getProperty(GraphicAttributes.EDGE_FOREGROUND);
		out += "\nEdge Background Color                      : " + getProperty(GraphicAttributes.EDGE_BACKGROUND);
		out += "\nEdge Pattern                               : " + getProperty(GraphicAttributes.EDGE_PATTERN);
		return out;
	}

}

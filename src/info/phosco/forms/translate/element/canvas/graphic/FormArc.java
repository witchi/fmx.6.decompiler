package info.phosco.forms.translate.element.canvas.graphic;

import info.phosco.forms.translate.element.ElementType;

public class FormArc extends FormGraphic {

	FormArc(int offset) {
		super(offset);
	}

	@Override
	public ElementType getType() {
		return ElementType.ARC;
	}

	@Override
	public String toString() {
		String out = super.toString();

		out += "\nDash Style                                 : " + getProperty(GraphicAttributes.DASH_STYLE);
		out += "\nCap Style                                  : " + getProperty(GraphicAttributes.CAP_STYLE);
		out += "\nJoin Style                                 : " + getProperty(GraphicAttributes.JOIN_STYLE);

		out += "\nClosed                                     : " + getProperty(GraphicAttributes.CLOSED);
		out += "\nFill Style                                 : " + getProperty(GraphicAttributes.FILL_STYLE);

		out += "\nForeground Color                           : " + getProperty(GraphicAttributes.FOREGROUND);
		out += "\nBackground Color                           : " + getProperty(GraphicAttributes.BACKGROUND);
		out += "\nFill Pattern                               : " + getProperty(GraphicAttributes.FILL_PATTERN);

		out += "\nStart Angle                                : " + getProperty(GraphicAttributes.START_ANGLE);
		out += "\nEnd Angle                                  : " + getProperty(GraphicAttributes.END_ANGLE);

		out += "\nEdge Foreground Color                      : " + getProperty(GraphicAttributes.EDGE_FOREGROUND);
		out += "\nEdge Background Color                      : " + getProperty(GraphicAttributes.EDGE_BACKGROUND);
		out += "\nEdge Pattern                               : " + getProperty(GraphicAttributes.EDGE_PATTERN);

		return out;
	}

}

package info.phosco.forms.translate.element.canvas.graphic;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.application.CoordSystemUnit;
import info.phosco.forms.translate.element.text.TextLine;
import info.phosco.forms.translate.element.text.TextLinePart;

import java.util.List;

public class FormText extends FormGraphic {

	FormText(int offset) {
		super(offset);
	}

	@Override
	public ElementType getType() {
		return ElementType.TEXT;
	}

	public Float convertToScreen(Integer value) {
		if (value == null) {
			return null;
		}
		return Math.round(CoordSystemUnit.POINT.convert(value) * 100f) / 100f;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		String out = super.toString();

		List<TextLine> lines = (List<TextLine>) getProperty(GraphicAttributes.TEXT_LINES);
		for (int i = 0; i < lines.size(); i++) {

			String line = "";

			List<TextLinePart> parts = lines.get(i).getParts();
			for (int j = 0; j < parts.size(); j++) {
				line += parts.get(j).getContent();
			}
			out += "\nLine " + i + "                                     : " + line.replace("\n", "\\n");
		}

		out += "\nLine Width                                 : " + convertToScreen((int) getProperty(GraphicAttributes.THICKNESS));

		out += "\nDash Style                                 : " + getProperty(GraphicAttributes.DASH_STYLE);
		out += "\nCap Style                                  : " + getProperty(GraphicAttributes.CAP_STYLE);
		out += "\nJoin Style                                 : " + getProperty(GraphicAttributes.JOIN_STYLE);

		out += "\nCustom Spacing                             : " + getProperty(GraphicAttributes.CUSTOM_SPACING);
		out += "\nLine Spacing                               : " + getProperty(GraphicAttributes.LINE_SPACING);

		out += "\nWrap Text                                  : " + getProperty(GraphicAttributes.WRAP_TEXT);
		out += "\nBounding Box Scaleable                     : " + getProperty(GraphicAttributes.BOX_SCALEABLE);
		out += "\nFont Scaleable                             : " + getProperty(GraphicAttributes.FONT_SCALEABLE);

		out += "\nHorizontal Justification                   : " + getProperty(GraphicAttributes.H_JUSTIFICATION);
		out += "\nVertical Justification                     : " + getProperty(GraphicAttributes.V_JUSTIFICATION);
		out += "\nHorizontal Origin                          : " + getProperty(GraphicAttributes.H_ORIGIN);
		out += "\nVertical Origin                            : " + getProperty(GraphicAttributes.V_ORIGIN);
		out += "\nBevel                                      : " + getProperty(GraphicAttributes.BEVEL);

		out += "\nForeground Color                           : " + getProperty(GraphicAttributes.FOREGROUND);
		out += "\nBackground Color                           : " + getProperty(GraphicAttributes.BACKGROUND);
		out += "\nFill Pattern                               : " + getProperty(GraphicAttributes.FILL_PATTERN);

		out += "\nEdge Foreground Color                      : " + getProperty(GraphicAttributes.EDGE_FOREGROUND);
		out += "\nEdge Background Color                      : " + getProperty(GraphicAttributes.EDGE_BACKGROUND);
		out += "\nEdge Pattern                               : " + getProperty(GraphicAttributes.EDGE_PATTERN);

		out += "\nDirection                                  : " + getProperty(GraphicAttributes.DIRECTION);

		return out;
	}

}

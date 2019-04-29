package info.phosco.forms.translate.element.canvas.graphic;

import java.awt.Point;
import java.util.ArrayList;

public abstract class FormGraphic extends FormGroup {

	FormGraphic(int offset) {
		super(offset);
	}

	public boolean isRotation() {
		Object angle = getProperty(GraphicAttributes.ROTATION_ANGLE);
		return angle != null && (int) angle != 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		String out = super.toString();
		out += "\nName                                       : " + getName();

		out += "\nX-Position                                 : " + getProperty(GraphicAttributes.X);
		out += "\nY-Position                                 : " + getProperty(GraphicAttributes.Y);
		out += "\nBreite                                     : " + getProperty(GraphicAttributes.WIDTH);
		out += "\nHöhe                                       : " + getProperty(GraphicAttributes.HEIGHT);

		if (isRotation()) {
			ArrayList<Point> list = (ArrayList<Point>) getProperty(GraphicAttributes.COORDINATE_LIST);
			for (Point p : list) {
				out += "\nX,Y                                        : " + p;
			}
		}
		return out;
	}

}

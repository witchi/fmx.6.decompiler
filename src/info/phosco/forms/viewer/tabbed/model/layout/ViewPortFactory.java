package info.phosco.forms.viewer.tabbed.model.layout;

import info.phosco.forms.translate.element.canvas.CanvasAttributes;
import info.phosco.forms.translate.element.canvas.FormCanvas;
import info.phosco.forms.viewer.tabbed.model.CoordinateSystem;
import javafx.scene.paint.Color;

public class ViewPortFactory {

	public static RectangleLayoutElement newInstance(FormCanvas canvas, CoordinateSystem coords) {

		RectangleLayoutElement res = new RectangleLayoutElement();

		res.setX(coords.toUnitDouble((int) canvas.getProperty(CanvasAttributes.VIEWPORT_X_ON_CANVAS)));
		res.setY(coords.toUnitDouble((int) canvas.getProperty(CanvasAttributes.VIEWPORT_Y_ON_CANVAS)));
		//TODO: res.setWidth(coords.toUnitDouble((int) canvas.getProperty(CanvasAttributes.VIEWPORT_WIDTH)));
		//res.setHeight(coords.toUnitDouble((int) canvas.getProperty(CanvasAttributes.VIEWPORT_HEIGHT)));
		res.setWidth(537);
		res.setHeight(367);
		
		res.setBorder(1.0);
		res.setBackgroundColor(Color.TRANSPARENT);
		res.setForegroundColor(Color.BLACK);

		return res;
	}
}

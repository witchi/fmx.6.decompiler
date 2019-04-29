package info.phosco.forms.viewer.tabbed.model.layout;

import info.phosco.forms.translate.element.canvas.CanvasAttributes;
import info.phosco.forms.translate.element.canvas.CanvasBevel;
import info.phosco.forms.translate.element.canvas.FormCanvas;
import info.phosco.forms.translate.element.visual.substruct.VisualAttributes;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStruct;
import info.phosco.forms.viewer.tabbed.model.CoordinateSystem;
import javafx.scene.paint.Color;

public class CanvasFactory {

	private static Color getJavaColor(info.phosco.forms.translate.element.visual.substruct.Color color) {
		return Color.rgb(color.getRed(), color.getGreen(), color.getBlue());
	}

	public static RectangleLayoutElement newInstance(FormCanvas canvas, CoordinateSystem coords) {

		RectangleLayoutElement res = new RectangleLayoutElement();

		res.setX(0);
		res.setY(0);
		res.setWidth(coords.toUnitDouble((int) canvas.getProperty(CanvasAttributes.WIDTH)));
		res.setHeight(coords.toUnitDouble((int) canvas.getProperty(CanvasAttributes.HEIGHT)));
		res.setBorderWidth(2.0);
		res.setBevel((CanvasBevel) canvas.getProperty(CanvasAttributes.BEVEL));

		VisualSubStruct vs = (VisualSubStruct) canvas.getProperty(CanvasAttributes.VISUAL_STRUCT);
		if (vs != null) {

			res.setBackgroundColor(getJavaColor((info.phosco.forms.translate.element.visual.substruct.Color) vs
					.getProperty(VisualAttributes.BACKGROUND)));
		}
		return res;
	}
}

package info.phosco.forms.viewer.tabbed.model.layout;

import info.phosco.forms.translate.element.FormElement;
import info.phosco.forms.translate.element.canvas.CanvasAttributes;
import info.phosco.forms.translate.element.canvas.FormCanvas;
import info.phosco.forms.translate.element.canvas.graphic.FormGroup;
import info.phosco.forms.translate.element.canvas.graphic.FormImage;
import info.phosco.forms.translate.element.canvas.graphic.FormRectangle;
import info.phosco.forms.translate.element.canvas.graphic.GraphicAttributes;
import info.phosco.forms.viewer.tabbed.model.CoordinateSystem;
import info.phosco.forms.viewer.tabbed.model.LayoutElement;

import java.util.ArrayList;
import java.util.List;

public class CanvasLayoutFactory {

	@SuppressWarnings("unchecked")
	private static List<LayoutElement> getSubList(List<FormElement<?>> list, CoordinateSystem coords) {

		List<LayoutElement> res = new ArrayList<LayoutElement>();

		for (FormElement<?> elem : list) {

			switch (elem.getType()) {

			case GROUP:
				res.addAll(getSubList((List<FormElement<?>>) ((FormGroup) elem).getProperty(GraphicAttributes.CHILD_LIST), coords));
				break;

			case IMAGE:
				res.add(ImageFactory.newInstance((FormImage) elem, coords));
				break;

			case RECTANGLE:
				res.add(RectangleFactory.newInstance((FormRectangle) elem, coords));
				break;

			// TODO: add more types
			// TODO: Z-Order?

			default:
				break;
			}

		}

		return res;
	}

	@SuppressWarnings("unchecked")
	public static List<LayoutElement> getList(FormCanvas canvas, CoordinateSystem coords) {

		List<LayoutElement> res = new ArrayList<LayoutElement>();

		res.add(CanvasFactory.newInstance(canvas, coords));
		res.addAll(getSubList((List<FormElement<?>>) canvas.getProperty(CanvasAttributes.GRAPHIC_TREE), coords));
		res.add(ViewPortFactory.newInstance(canvas, coords));

		return res;
	}

}

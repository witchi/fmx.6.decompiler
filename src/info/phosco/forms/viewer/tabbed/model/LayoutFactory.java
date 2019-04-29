package info.phosco.forms.viewer.tabbed.model;

import info.phosco.forms.translate.element.FormElement;
import info.phosco.forms.translate.element.canvas.FormCanvas;
import info.phosco.forms.viewer.tabbed.model.layout.CanvasLayoutFactory;

import java.util.ArrayList;
import java.util.List;

public class LayoutFactory {

	// TODO: maybe we need more elements, like blocks or visual attributes
	public static List<LayoutElement> getList(FormElement<?> elem, CoordinateSystem coords) {
		List<LayoutElement> res = new ArrayList<LayoutElement>();

		if (elem == null) {
			return res;
		}

		switch (elem.getType()) {

		case CANVAS:
			// TODO: create List of Elements in the order to paint
			// TODO: we need Z-Order?
			// the controller runs thought the list and calls method on the view
			// to paint each element
			res = CanvasLayoutFactory.getList((FormCanvas) elem, coords);
			break;

		default:
			break;
		}

		return res;
	}
}

package info.phosco.forms.translate.element.canvas;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.font.FormFont;
import info.phosco.forms.translate.util.FileStructureTypeException;
import info.phosco.forms.translate.util.FormElementTypeException;

public class CanvasListFactory {

	private CanvasListFactory() {
	}

	/**
	 * Read the sorted list of the Canvas references. It starts on offset within
	 * the content, it contains len canvases.
	 * 
	 * @param content
	 *            The file content.
	 * @param offset
	 *            the start address of the list within content
	 * @param len
	 *            Number of Canvases within the list
	 * @return
	 * @throws FileStructureTypeException
	 * @throws FormElementTypeException
	 */
	public static ElementList<FormCanvas> get(Content content, int offset, int length, ElementList<FormFont> fontList)
			throws FileStructureTypeException, FormElementTypeException {

		ElementList<FormCanvas> res = new ElementList<FormCanvas>();

		for (int i = 0; i < length; i++) {
			res.add(FormCanvasFactory.instance(content, content.getInt(offset, i * 4), fontList));
		}

		return res;
	}

}

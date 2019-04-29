package info.phosco.forms.translate.element.canvas.graphic;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.font.FormFont;
import info.phosco.forms.translate.util.FileStructureTypeException;
import info.phosco.forms.translate.util.FormElementTypeException;

public class GraphicListFactory {

	private GraphicListFactory() {
	}

	/**
	 * Read the sorted list of the Graphics references. It starts on offset
	 * within the content, it contains len references.
	 * 
	 * @param content
	 *            The file content.
	 * @param offset
	 *            the start address of the list within content
	 * @param len
	 *            Number of Graphics within the list
	 * @return
	 * @throws FileStructureTypeException
	 * @throws FormElementTypeException
	 */
	public static ElementList<FormGroup> get(Content content, int offset, int length, ElementList<FormFont> fontList)
			throws FileStructureTypeException, FormElementTypeException {

		ElementList<FormGroup> res = new ElementList<FormGroup>();

		for (int i = 0; i < length; i++) {
			res.add(FormGraphicFactory.instance(content, content.getInt(offset, i * 4), fontList));
		}

		return res;
	}

}

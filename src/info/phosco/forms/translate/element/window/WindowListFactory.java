package info.phosco.forms.translate.element.window;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class WindowListFactory {

	private WindowListFactory() {
	}

	/**
	 * Read the sorted list of the Window references. It starts on offset within
	 * the content, it contains len windows.
	 * 
	 * @param content
	 *            The file content.
	 * @param offset
	 *            the start address of the list widthin content
	 * @param len
	 *            Number of Windows within the list
	 * @return
	 * @throws FileStructureTypeException
	 */
	public static ElementList<FormWindow> get(Content content, int offset, int length)
			throws FileStructureTypeException {

		ElementList<FormWindow> res = new ElementList<FormWindow>();

		for (int i = 0; i < length; i++) {
			res.add(FormWindowFactory.instance(content, content.getInt(offset, i * 4)));
		}

		return res;
	}

}

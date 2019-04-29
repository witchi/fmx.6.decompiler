package info.phosco.forms.translate.element.editor;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class EditorListFactory {

	private EditorListFactory() {
	}

	/**
	 * Read the sorted list of the editor references. It starts on offset within
	 * the content, it contains len editors.
	 * 
	 * @param content
	 *            The file content.
	 * @param offset
	 *            the start address of the list within content
	 * @param len
	 *            Number of Editors within the list
	 * @return
	 * @throws FileStructureTypeException
	 */
	public static ElementList<FormEditor> get(Content content, int offset, int length)
			throws FileStructureTypeException {

		ElementList<FormEditor> res = new ElementList<FormEditor>();

		for (int i = 0; i < length; i++) {
			res.add(FormEditorFactory.instance(content, content.getInt(offset, i * 4)));
		}

		return res;
	}

}

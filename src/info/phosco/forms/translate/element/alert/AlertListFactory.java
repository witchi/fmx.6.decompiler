package info.phosco.forms.translate.element.alert;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class AlertListFactory {

	private AlertListFactory() {
	}

	/**
	 * Read the sorted list of the Warning references. It starts on offset
	 * within the content, it contains len warnings.
	 * 
	 * @param content
	 *            The file content.
	 * @param offset
	 *            the start address of the list within content
	 * @param len
	 *            Number of Warning within the list
	 * @return
	 * @throws FileStructureTypeException
	 */
	public static ElementList<FormAlert> get(Content content, int offset, int length)
			throws FileStructureTypeException {

		ElementList<FormAlert> res = new ElementList<FormAlert>();

		for (int i = 0; i < length; i++) {
			res.add(FormAlertFactory.instance(content, content.getInt(offset, i * 4)));
		}

		return res;
	}

}

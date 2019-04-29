package info.phosco.forms.translate.element.parameter;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class ParameterListFactory {

	private ParameterListFactory() {
	}

	/**
	 * Read the sorted list of the Parameter references. It starts on offset
	 * within the content, it contains len parameters.
	 * 
	 * @param content
	 *            The file content.
	 * @param offset
	 *            the start address of the list within content
	 * @param len
	 *            Number of Parameters within the list
	 * @return
	 * @throws FileStructureTypeException
	 */
	public static ElementList<FormParameter> get(Content content, int offset, int length)
			throws FileStructureTypeException {

		ElementList<FormParameter> res = new ElementList<FormParameter>();

		for (int i = 0; i < length; i++) {
			res.add(FormParameterFactory.instance(content, content.getInt(offset, i * 4)));
		}

		return res;
	}

}

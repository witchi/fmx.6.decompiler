package info.phosco.forms.translate.element.datablock;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class DataBlockListFactory {

	private DataBlockListFactory() {
	}

	/**
	 * Read the sorted list of the DataBlock references. It starts on offset within
	 * the content, it contains len datablocks.
	 * 
	 * @param content
	 *            The file content.
	 * @param offset
	 *            the start address of the list within content
	 * @param len
	 *            Number of DataBlocks within the list
	 * @return
	 * @throws FileStructureTypeException
	 */
	public static ElementList<FormDataBlock> get(Content content, int offset, int length)
			throws FileStructureTypeException {

		ElementList<FormDataBlock> res = new ElementList<FormDataBlock>();

		for (int i = 0; i < length; i++) {
			res.add(FormDataBlockFactory.instance(content, content.getInt(offset, i * 4)));
		}

		return res;
	}

}

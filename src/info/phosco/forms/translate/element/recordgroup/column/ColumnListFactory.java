package info.phosco.forms.translate.element.recordgroup.column;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class ColumnListFactory {

	private static final int POS_NEXT_COLUMN = 0xC;

	private ColumnListFactory() {
	}

	/**
	 * RecordGroupColumns are stored as a chaining list.
	 * 
	 * @param content
	 * @param offset
	 * @return
	 * @throws FileStructureTypeException
	 */
	public static ElementList<Column> get(Content content, int offset) throws FileStructureTypeException {

		ElementList<Column> res = new ElementList<Column>();

		int address = offset;
		while (address != 0x0) {
			res.add(ColumnFactory.instance(content, address));
			address = content.getInt(address, POS_NEXT_COLUMN);
		}

		return res;
	}

}

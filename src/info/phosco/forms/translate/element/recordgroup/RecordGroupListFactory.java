package info.phosco.forms.translate.element.recordgroup;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.util.ColumnDatatypeException;
import info.phosco.forms.translate.util.DateFormatException;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class RecordGroupListFactory {

	private static final int POS_NEXT_RECORD_GROUP = 0x5C;
	
	private RecordGroupListFactory() {
	}

	/**
	 * RecordGroups are stored as a chaining list.
	 * 
	 * @param content
	 * @param offset
	 * @return
	 * @throws FileStructureTypeException
	 * @throws DateFormatException
	 * @throws ColumnDatatypeException
	 */
	public static ElementList<FormRecordGroup> get(Content content, int offset)
			throws FileStructureTypeException, ColumnDatatypeException, DateFormatException {

		ElementList<FormRecordGroup> res = new ElementList<FormRecordGroup>();

		int address = offset;
		while (address != 0x0) {
			res.add(FormRecordGroupFactory.instance(content, address));
			address = content.getInt(address, POS_NEXT_RECORD_GROUP);
		}

		return res;
	}

}

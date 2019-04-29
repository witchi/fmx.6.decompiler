package info.phosco.forms.translate.element.recordgroup;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.recordgroup.column.Column;
import info.phosco.forms.translate.element.recordgroup.column.ColumnAttributes;
import info.phosco.forms.translate.element.recordgroup.column.ColumnListFactory;
import info.phosco.forms.translate.element.recordgroup.value.ValueListFactory;
import info.phosco.forms.translate.util.ColumnDatatypeException;
import info.phosco.forms.translate.util.DateFormatException;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class FormRecordGroupFactory extends AbstractFactory {

	private static final int POS_TYPE = 0x0;

	private static final int POS_NAME = 0x8;

	private static final int POS_FIRST_COLUMN = 0xC;

	private static final int POS_LAST_COLUMN = 0x10;

	private static final int POS_COLUMN_COUNT = 0x14;

	private static final int POS_VALUE_LIST = 0x2C;

	private static final int POS_QUERY = 0x30;

	private static final int POS_QUERY_SIZE = 0x60;

	private FormRecordGroupFactory() {
	}

	public static FormRecordGroup instance(Content content, int offset) throws FileStructureTypeException,
			ColumnDatatypeException, DateFormatException {

		FormRecordGroup res = new FormRecordGroup(offset);

		res.setProperty(RecordGroupAttributes.RECORD_GROUP_TYPE,
				RecordGroupType.lookup(content.getInt(offset, POS_TYPE) & 0x10));
		res.setProperty(RecordGroupAttributes.QUERY_SIZE, content.getInt(offset, POS_QUERY_SIZE));

		int ref = content.getInt(offset, POS_NAME);
		res.setProperty(RecordGroupAttributes.NAME, content.getString(ref, 0));

		res.setProperty(RecordGroupAttributes.COLUMN_COUNT, content.getInt(offset, POS_COLUMN_COUNT));

		if (res.isQuery()) {
			ref = content.getInt(offset, POS_QUERY);
			res.setProperty(RecordGroupAttributes.QUERY, content.getString(ref, 0));
		}

		ref = content.getInt(offset, POS_FIRST_COLUMN);
		ElementList<Column> columns = ColumnListFactory.get(content, ref);
		res.setProperty(RecordGroupAttributes.COLUMN_LIST, columns);

		if (res.isStatic()) {

			int valueListOffset = content.getInt(offset, POS_VALUE_LIST);
			for (Column c : columns) {
				c.setProperty(ColumnAttributes.VALUE_LIST, ValueListFactory.get(content, valueListOffset, c));
			}
		}

		return res;
	}
}

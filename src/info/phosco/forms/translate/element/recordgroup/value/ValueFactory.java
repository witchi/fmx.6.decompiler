package info.phosco.forms.translate.element.recordgroup.value;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.element.recordgroup.column.Column;
import info.phosco.forms.translate.element.recordgroup.column.ColumnAttributes;
import info.phosco.forms.translate.element.recordgroup.column.ColumnDatatype;
import info.phosco.forms.translate.util.ColumnDatatypeException;
import info.phosco.forms.translate.util.DateFormatException;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class ValueFactory extends AbstractFactory {

	private static final int POS_LENGTH = 0x0;
	private static final int POS_VALUE = 0x2;

	private ValueFactory() {
	}

	public static Value get(Content content, int offset, Column c) throws FileStructureTypeException,
			ColumnDatatypeException, DateFormatException {

		int[] array;
		int valueOffset = (int) c.getProperty(ColumnAttributes.VALUE_OFFSET);
		int length = content.getShort(offset, valueOffset + POS_LENGTH);

		ColumnDatatype datatype = (ColumnDatatype) c.getProperty(ColumnAttributes.DATATYPE);
		switch (datatype) {

		case CHAR:
			return OracleString.newInstance(content.getString(offset, valueOffset + POS_VALUE, length));

		case NUMBER:
			array = content.getBytes(offset, valueOffset + POS_VALUE, length);
			return OracleNumber.newInstance(array);

		case DATE:
			array = content.getBytes(offset, valueOffset + POS_VALUE, length);
			return OracleDate.newInstance(array);

		default:
			throw new ColumnDatatypeException(c.getName(), datatype);
		}
	}

}

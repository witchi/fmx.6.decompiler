package info.phosco.forms.translate.element.recordgroup.column;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class ColumnFactory extends AbstractFactory {

	private static final int POS_NAME = 0x0;
	
	private static final int POS_VALUE_OFFSET = 0x4;
	
	private static final int POS_LENGTH = 0x6;
	
	private static final int POS_DATATYPE = 0x8;
	

	private ColumnFactory() {
	}

	public static Column instance(Content content, int offset) throws FileStructureTypeException {
		Column res = new Column(offset);

		int ref = content.getInt(offset, POS_NAME);
		res.setProperty(ColumnAttributes.NAME, content.getString(ref, 0));
		
		res.setProperty(ColumnAttributes.DATATYPE, ColumnDatatype.lookup(content.getShort(offset, POS_DATATYPE) >> 8));
		res.setProperty(ColumnAttributes.LENGTH, content.getShort(offset, POS_LENGTH));
		
		// we store this only for static record groups
		res.setProperty(ColumnAttributes.VALUE_OFFSET, content.getShort(offset, POS_VALUE_OFFSET));

		// TODO: get other attributes
		
		return res;
	}

}

package info.phosco.forms.translate.element.datablock;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;

import java.util.Properties;

public class FormDataBlock implements FormElement<DataBlockAttributes> {

	private final Properties props;

	FormDataBlock(int offset) {
		this.props = new Properties();
		setProperty(DataBlockAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(DataBlockAttributes key, Object value) {
		this.props.put(key.toString(), value);

	}

	@Override
	public Object getProperty(DataBlockAttributes key) {
		return this.props.get(key.toString());
	}

	@Override
	public String getName() {
		return (String) getProperty(DataBlockAttributes.NAME);
	}

	@Override
	public ElementType getType() {
		return ElementType.DATA_BLOCK;
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(DataBlockAttributes.OFFSET);
	}

	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nName                                       : " + getName();

		out += "\nNavigation Style                           : " + getProperty(DataBlockAttributes.NAVIGATION_STYLE);
		out += "\nPrevious Navigation Data Block             : " + (getProperty(DataBlockAttributes.PREV_NAV_DATA_BLOCK) == null ? "" : Integer.toHexString((int) getProperty(DataBlockAttributes.PREV_NAV_DATA_BLOCK)));
		out += "\nNext Navigation Data Block                 : " + (getProperty(DataBlockAttributes.NEXT_NAV_DATA_BLOCK) == null ? "" : Integer.toHexString((int) getProperty(DataBlockAttributes.NEXT_NAV_DATA_BLOCK)));

		out += "\nAlias                                      : " + getProperty(DataBlockAttributes.ALIAS);
		out += "\nWHERE Clause                               : " + getProperty(DataBlockAttributes.WHERE_CLAUSE);
		out += "\nORDER BY Clause                            : " + getProperty(DataBlockAttributes.ORDER_CLAUSE);
		
		out += "\nQuery Array Size                           : " + getProperty(DataBlockAttributes.QUERY_ARRAY_SIZE);
		out += "\nNumber of Records Buffered                 : " + getProperty(DataBlockAttributes.NUMBER_RECORDS_BUFFERED);
		out += "\nNumber of Records Displayed                : " + getProperty(DataBlockAttributes.NUMBER_RECORDS_DISPLAYED);
		out += "\nQuery All Records                          : " + getProperty(DataBlockAttributes.QUERY_ALL_RECORDS);
		out += "\nRecord Orientation                         : " + getProperty(DataBlockAttributes.RECORD_ORIENTATION);
		out += "\nSingle Record                              : " + getProperty(DataBlockAttributes.SINGLE_RECORD);

		out += "\nDatabase Data Block                        : " + getProperty(DataBlockAttributes.DATABASE_DATA_BLOCK);
		out += "\nQuery Allowed                              : " + getProperty(DataBlockAttributes.QUERY_ALLOWED);

		out += "\nInsert Allowed                             : " + getProperty(DataBlockAttributes.INSERT_ALLOWED);
		out += "\nUpdate Allowed                             : " + getProperty(DataBlockAttributes.UPDATE_ALLOWED);
		out += "\nLocking Mode                               : " + getProperty(DataBlockAttributes.LOCKING_MODE);
		out += "\nDelete Allowed                             : " + getProperty(DataBlockAttributes.DELETE_ALLOWED);
		out += "\nKey Mode                                   : " + getProperty(DataBlockAttributes.KEY_MODE);

		out += "\nMaximum Query Time                         : " + getProperty(DataBlockAttributes.MAX_QUERY_TIME);
		out += "\nMaximum Records Fetched                    : " + getProperty(DataBlockAttributes.MAX_RECORDS_FETCHED);

		out += "\nListed In Data Block Menu                  : " + getProperty(DataBlockAttributes.LIST_IN_DATA_BLOCK_MENU);
		out += "\nData Block Description                     : " + getProperty(DataBlockAttributes.DATA_BLOCK_DESCR);
		
		out += "\nDirection                                  : " + getProperty(DataBlockAttributes.DIRECTION);
		return out;
	}
}

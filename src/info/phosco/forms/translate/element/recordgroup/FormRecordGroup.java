package info.phosco.forms.translate.element.recordgroup;

import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;
import info.phosco.forms.translate.element.recordgroup.column.Column;

import java.util.Properties;

public class FormRecordGroup implements FormElement<RecordGroupAttributes> {

	private Properties properties;

	FormRecordGroup(int offset) {
		this.properties = new Properties();
		setProperty(RecordGroupAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(RecordGroupAttributes key, Object value) {
		this.properties.put(key, value);
	}

	@Override
	public Object getProperty(RecordGroupAttributes key) {
		return this.properties.get(key);
	}

	@Override
	public String getName() {
		return (String) getProperty(RecordGroupAttributes.NAME);
	}

	@Override
	public ElementType getType() {
		return ElementType.RECORD_GROUP;
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(RecordGroupAttributes.OFFSET);
	}

	public boolean isStatic() {
		return getProperty(RecordGroupAttributes.RECORD_GROUP_TYPE) == RecordGroupType.STATIC;
	}

	public boolean isQuery() {
		return getProperty(RecordGroupAttributes.RECORD_GROUP_TYPE) == RecordGroupType.QUERY;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nName                                       : " + getName();

		out += "\nDatensatzgruppentyp                        : " + getProperty(RecordGroupAttributes.RECORD_GROUP_TYPE);

		if (isQuery()) {
			out += "\nDatensatzgruppenabfrage                    : " + getProperty(RecordGroupAttributes.QUERY);
			out += "\nDatensatzgruppe Abrufgröße                 : " + getProperty(RecordGroupAttributes.QUERY_SIZE);
		}

		out += "\nAnzahl Spalten                             : " + getProperty(RecordGroupAttributes.COLUMN_COUNT);

		ElementList<Column> cols = (ElementList<Column>) getProperty(RecordGroupAttributes.COLUMN_LIST);
		for (Column c : cols) {
			out += "\n" + c.toString();
		}

		return out;
	}
}

package info.phosco.forms.translate.element.recordgroup.column;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;
import info.phosco.forms.translate.element.recordgroup.value.Value;

import java.util.List;
import java.util.Properties;

public class Column implements FormElement<ColumnAttributes> {

	private Properties properties;

	Column(int offset) {
		this.properties = new Properties();
		setProperty(ColumnAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(ColumnAttributes key, Object value) {
		this.properties.put(key, value);
	}

	@Override
	public Object getProperty(ColumnAttributes key) {
		return this.properties.get(key);
	}

	@Override
	public String getName() {
		return (String) getProperty(ColumnAttributes.NAME);
	}

	@Override
	public ElementType getType() {
		return ElementType.RECORD_GROUP_COLUMN;
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(ColumnAttributes.OFFSET);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nName                                       : " + getName();
		out += "\nDatentyp                                   : " + getProperty(ColumnAttributes.DATATYPE);
		out += "\nLänge                                      : " + getProperty(ColumnAttributes.LENGTH);

		List<Value> list = (List<Value>) getProperty(ColumnAttributes.VALUE_LIST);
		if (list != null) {
			out += "\nstatische Werteliste                       : \n";
			for (Value v : list) {
				out += "                                             " + v + "\n";
			}
		}

		return out;
	}
}

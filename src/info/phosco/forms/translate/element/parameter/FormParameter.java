package info.phosco.forms.translate.element.parameter;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;

import java.util.Properties;

public class FormParameter implements FormElement<ParameterAttributes> {

	private final Properties props;

	FormParameter(int offset) {
		this.props = new Properties();
		setProperty(ParameterAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(ParameterAttributes key, Object value) {
		this.props.put(key.toString(), value);

	}

	@Override
	public Object getProperty(ParameterAttributes key) {
		return this.props.get(key.toString());
	}

	@Override
	public String getName() {
		return (String) getProperty(ParameterAttributes.NAME);
	}

	@Override
	public ElementType getType() {
		return ElementType.PARAMETER;
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(ParameterAttributes.OFFSET);
	}

	public boolean hasDefault() {
		return (Boolean) getProperty(ParameterAttributes.VALID_DEFAULT);
	}

	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nName                                       : " + getName();
		out += "\nParameter-Datentyp                         : " + getProperty(ParameterAttributes.DATATYPE);
		out += "\nMaximale Länge                             : " + getProperty(ParameterAttributes.MAX_LENGTH);
		out += "\nParameter-Ausgangswert                     : " + getProperty(ParameterAttributes.DEFAULT_VALUE);
		return out;
	}
}

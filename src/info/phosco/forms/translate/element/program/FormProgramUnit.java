package info.phosco.forms.translate.element.program;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;

import java.util.Properties;

public class FormProgramUnit implements FormElement<ProgramUnitAttributes> {

	private Properties properties;

	FormProgramUnit(int offset) {
		this.properties = new Properties();
		setProperty(ProgramUnitAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(ProgramUnitAttributes key, Object value) {
		this.properties.put(key, value);
	}

	@Override
	public Object getProperty(ProgramUnitAttributes key) {
		return this.properties.get(key);
	}

	@Override
	public String getName() {
		return (String) getProperty(ProgramUnitAttributes.NAME);
	}

	@Override
	public ElementType getType() {
		return ElementType.PROGRAM_UNIT;
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(ProgramUnitAttributes.OFFSET);
	}

	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nName                                       : " + getName();

		out += "\nUnit Type                                  : " + getProperty(ProgramUnitAttributes.TYPE);
		
		return out;
	}
}

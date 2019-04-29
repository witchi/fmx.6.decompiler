package info.phosco.forms.translate.element.program;

import java.util.Properties;

public class SourceCode {

	private Properties properties;

	SourceCode(int offset) {
		this.properties = new Properties();
		setProperty(ProgramUnitAttributes.OFFSET, offset);
	}

	public void setProperty(ProgramUnitAttributes key, Object value) {
		this.properties.put(key, value);
	}

	public Object getProperty(ProgramUnitAttributes key) {
		return this.properties.get(key);
	}

	public int getOffset() {
		return (Integer) getProperty(ProgramUnitAttributes.OFFSET);
	}

	@Override
	public String toString() {
		String out = "";
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nLength                                     : " + Integer.toHexString((int) getProperty(ProgramUnitAttributes.LENGTH));

		return out;
	}

}

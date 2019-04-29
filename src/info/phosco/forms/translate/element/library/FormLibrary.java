package info.phosco.forms.translate.element.library;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;

import java.util.Properties;

public class FormLibrary implements FormElement<LibraryAttributes> {

	private Properties properties;

	FormLibrary(int offset) {
		this.properties = new Properties();
		setProperty(LibraryAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(LibraryAttributes key, Object value) {
		this.properties.put(key, value);
	}

	@Override
	public Object getProperty(LibraryAttributes key) {
		return this.properties.get(key);
	}

	@Override
	public String getName() {
		return (String) getProperty(LibraryAttributes.NAME);
	}

	@Override
	public ElementType getType() {
		return ElementType.LIBRARY;
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(LibraryAttributes.OFFSET);
	}

	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nName                                       : " + getName();

		out += "\nSource                                     : " + getProperty(LibraryAttributes.SOURCE);
		out += "\nLocation                                   : " + getProperty(LibraryAttributes.LOCATION);

		return out;
	}
}

package info.phosco.forms.translate.element.font;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;

import java.util.Properties;

public class FormFont implements FormElement<FontAttributes> {

	private final Properties props;

	FormFont(int offset) {
		this.props = new Properties();
		setProperty(FontAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(FontAttributes key, Object value) {
		this.props.put(key.toString(), value);

	}

	@Override
	public Object getProperty(FontAttributes key) {
		return this.props.get(key.toString());
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementType getType() {
		return ElementType.FONT;
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(FontAttributes.OFFSET);
	}

	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());

		out += "\nSchriftartname                             : " + getProperty(FontAttributes.FONT_NAME);
		out += "\nSchriftgrad                                : " + getProperty(FontAttributes.FONT_SIZE);
		out += "\nSchriftstärke                              : " + getProperty(FontAttributes.FONT_WEIGHT);
		out += "\nSchriftstil                                : " + getProperty(FontAttributes.FONT_STYLE);
		return out;
	}

}

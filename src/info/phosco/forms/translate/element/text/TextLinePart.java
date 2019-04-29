package info.phosco.forms.translate.element.text;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;

import java.util.Properties;

public class TextLinePart implements FormElement<TextLinePartAttributes> {

	private final Properties props;

	TextLinePart(int offset) {
		this.props = new Properties();
		setProperty(TextLinePartAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(TextLinePartAttributes key, Object value) {
		props.put(key.toString(), value);
	}

	@Override
	public Object getProperty(TextLinePartAttributes key) {
		return props.get(key.toString());
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementType getType() {
		return ElementType.TEXT_PART;
	}

	@Override
	public int getOffset() {
		return (int) getProperty(TextLinePartAttributes.OFFSET);
	}

	public String getContent() {
		return (String) getProperty(TextLinePartAttributes.TEXT);
	}

}

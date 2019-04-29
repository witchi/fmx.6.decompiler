package info.phosco.forms.translate.element.visual.substruct;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;

import java.util.Properties;

public class VisualSubStruct implements FormElement<VisualAttributes> {

	private final Properties props;
	private int offset;

	public VisualSubStruct(int offset) {
		this.props = new Properties();
		this.offset = offset;
	}

	@Override
	public void setProperty(VisualAttributes key, Object value) {
		this.props.put(key.toString(), value);

	}

	@Override
	public Object getProperty(VisualAttributes key) {
		return this.props.get(key.toString());
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public ElementType getType() {
		return null;
	}

	@Override
	public int getOffset() {
		return this.offset;
	}

}

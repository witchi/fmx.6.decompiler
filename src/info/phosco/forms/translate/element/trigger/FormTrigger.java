package info.phosco.forms.translate.element.trigger;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;

import java.util.Properties;

public class FormTrigger implements FormElement<TriggerAttributes> {

	private final Properties props;

	FormTrigger(int offset) {
		this.props = new Properties();
		setProperty(TriggerAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(TriggerAttributes key, Object value) {
		this.props.put(key.toString(), value);

	}

	@Override
	public Object getProperty(TriggerAttributes key) {
		return this.props.get(key.toString());
	}

	@Override
	public String getName() {
		return (String) getProperty(TriggerAttributes.NAME);
	}

	@Override
	public ElementType getType() {
		return ElementType.TRIGGER;
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(TriggerAttributes.OFFSET);
	}

	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nName                                       : " + getName();
		
		out += "\nFire in Enter-Query Mode                   : " + getProperty(TriggerAttributes.FIRE_ENTER_QUERY);
		
		out += "\nDisplay in 'Keyboard Help'                 : " + getProperty(TriggerAttributes.DISPLAY_KEYBOARD_HELP);
		out += "\n'Keyboard Help' Text                       : " + getProperty(TriggerAttributes.KEYBOARD_HELP_TEXT);
		return out;
	}

}

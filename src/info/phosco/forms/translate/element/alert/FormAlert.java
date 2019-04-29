package info.phosco.forms.translate.element.alert;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;
import info.phosco.forms.translate.element.visual.substruct.VisualAttributes;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStruct;

import java.util.Properties;

public class FormAlert implements FormElement<AlertAttributes> {

	private final Properties props;

	FormAlert(int offset) {
		this.props = new Properties();
		setProperty(AlertAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(AlertAttributes key, Object value) {
		this.props.put(key.toString(), value);

	}

	@Override
	public Object getProperty(AlertAttributes key) {
		return this.props.get(key.toString());
	}

	@Override
	public String getName() {
		return (String) getProperty(AlertAttributes.NAME);
	}

	@Override
	public ElementType getType() {
		return ElementType.ALERT;
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(AlertAttributes.OFFSET);
	}

	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nName                                       : " + getName();
		out += "\nTitel                                      : " + getProperty(AlertAttributes.TITLE);
		out += "\nMeldung                                    : " + getProperty(AlertAttributes.MESSAGE);
		out += "\nWarnstil                                   : " + getProperty(AlertAttributes.STYLE);

		out += "\nBeschriftung Schaltfläche 1                : " + getProperty(AlertAttributes.BUTTON_1);
		out += "\nBeschriftung Schaltfläche 2                : " + getProperty(AlertAttributes.BUTTON_2);
		out += "\nBeschriftung Schaltfläche 3                : " + getProperty(AlertAttributes.BUTTON_3);
		out += "\nStandard-Warnschaltfläche                  : " + getProperty(AlertAttributes.DEFAULT_BUTTON);

		VisualSubStruct vs = (VisualSubStruct) getProperty(AlertAttributes.VISUAL_STRUCT);

		out += "\nVisuelle Attributgruppe                    : " + Integer.toHexString(vs.getOffset());
		out += "\nLogisches Attribute Zeichenmodus           : " + vs.getProperty(VisualAttributes.LOGICAL_ATTRIBUTE);
		out += "\nWeiß auf Schwarz                           : " + vs.getProperty(VisualAttributes.WHITE_ON_BLACK);
		out += "\nVordergrundfarbe                           : " + vs.getProperty(VisualAttributes.FOREGROUND);
		out += "\nHintergrundfarbe                           : " + vs.getProperty(VisualAttributes.BACKGROUND);
		out += "\nFüllmuster                                 : " + vs.getProperty(VisualAttributes.FILL_PATTERN);

		out += "\nSchriftartname                             : " + vs.getProperty(VisualAttributes.FONT_NAME);
		out += "\nSchriftgrad                                : " + vs.getProperty(VisualAttributes.FONT_SIZE);
		out += "\nSchriftstärke                              : " + vs.getProperty(VisualAttributes.FONT_WEIGHT);
		out += "\nSchriftstil                                : " + vs.getProperty(VisualAttributes.FONT_STYLE);
		out += "\nZeichenabstand                             : " + vs.getProperty(VisualAttributes.CHARACTER_SPACING);

		out += "\nRichtung                                   : " + getProperty(AlertAttributes.DIRECTION);
		return out;
	}

}

package info.phosco.forms.translate.element.visual.attribute;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;
import info.phosco.forms.translate.element.visual.substruct.VisualAttributes;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStruct;

import java.util.Properties;

public class FormVisualGroup implements FormElement<VisualGroupAttributes> {

	private final static String DEFAULT_NAME = "#POPUPHINT#";

	private final Properties props;

	public FormVisualGroup(int offset) {
		this.props = new Properties();
		setProperty(VisualGroupAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(VisualGroupAttributes key, Object value) {
		this.props.put(key.toString(), value);

	}

	@Override
	public Object getProperty(VisualGroupAttributes key) {
		return this.props.get(key.toString());
	}

	@Override
	public String getName() {
		return (String) getProperty(VisualGroupAttributes.NAME);
	}

	@Override
	public ElementType getType() {
		return ElementType.VISUAL_GROUP;
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(VisualGroupAttributes.OFFSET);
	}

	public boolean isDefault() {
		return getProperty(VisualGroupAttributes.GROUP_TYPE) == VisualGroupType.DEFAULT;
	}

	public boolean isCommon() {
		return getProperty(VisualGroupAttributes.GROUP_TYPE) == VisualGroupType.COMMON;
	}

	public boolean isPrompt() {
		return getProperty(VisualGroupAttributes.GROUP_TYPE) == VisualGroupType.PROMPT;
	}

	public boolean isTitle() {
		return getProperty(VisualGroupAttributes.GROUP_TYPE) == VisualGroupType.TITLE;
	}

	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nName                                       : " + getName();
		out += "\nDefault                                    : " + isDefault();
		out += "\nVisueller Attributtyp                      : " + getProperty(VisualGroupAttributes.GROUP_TYPE);

		VisualSubStruct vs = (VisualSubStruct) getProperty(VisualGroupAttributes.VISUAL_STRUCT);

		if (isCommon() || isDefault()) {
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
		}

		if (isTitle()) {
			out += "\nRahmentitel Vordergrundfarbe               : " + vs.getProperty(VisualAttributes.FOREGROUND);
			out += "\nRahmentitel Hintergrundfarbe               : " + vs.getProperty(VisualAttributes.BACKGROUND);
			out += "\nRahmentitel Füllmuster                     : " + vs.getProperty(VisualAttributes.FILL_PATTERN);

			out += "\nRahmentitel Schriftartname                 : " + vs.getProperty(VisualAttributes.FONT_NAME);
			out += "\nRahmentitel Schriftgrad                    : " + vs.getProperty(VisualAttributes.FONT_SIZE);
			out += "\nRahmentitel Schriftstärke                  : " + vs.getProperty(VisualAttributes.FONT_WEIGHT);
			out += "\nRahmentitel Schriftstil                    : " + vs.getProperty(VisualAttributes.FONT_STYLE);
			out += "\nRahmentitel Zeichenabstand                 : " + vs.getProperty(VisualAttributes.CHARACTER_SPACING);
		}

		if (isPrompt()) {
			out += "\nPrompt-Vordergrundfarbe                    : " + vs.getProperty(VisualAttributes.FOREGROUND);

			out += "\nPrompt-Schriftartname                      : " + vs.getProperty(VisualAttributes.FONT_NAME);
			out += "\nPrompt-Schriftgrad                         : " + vs.getProperty(VisualAttributes.FONT_SIZE);
			out += "\nPrompt-Schriftstärke                       : " + vs.getProperty(VisualAttributes.FONT_WEIGHT);
			out += "\nPrompt-Schriftstil                         : " + vs.getProperty(VisualAttributes.FONT_STYLE);
			out += "\nPrompt-Zeichenabstand                      : " + vs.getProperty(VisualAttributes.CHARACTER_SPACING);
		}

		return out;
	}
}

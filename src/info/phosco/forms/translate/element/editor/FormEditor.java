package info.phosco.forms.translate.element.editor;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;
import info.phosco.forms.translate.element.visual.substruct.VisualAttributes;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStruct;

import java.util.Properties;

public class FormEditor implements FormElement<EditorAttributes> {

	private final Properties props;

	FormEditor(int offset) {
		this.props = new Properties();
		setProperty(EditorAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(EditorAttributes key, Object value) {
		this.props.put(key.toString(), value);

	}

	@Override
	public Object getProperty(EditorAttributes key) {
		return this.props.get(key.toString());
	}

	@Override
	public String getName() {
		return (String) getProperty(EditorAttributes.NAME);
	}

	@Override
	public ElementType getType() {
		return ElementType.EDITOR;
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(EditorAttributes.OFFSET);
	}

	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nName                                       : " + getName();

		out += "\nTitel                                      : " + getProperty(EditorAttributes.TITLE);
		out += "\nFunktionaler Kommentar                     : " + getProperty(EditorAttributes.FUNCTIONAL_COMMENT);
		out += "\nUmbruchstil                                : " + getProperty(EditorAttributes.WRAP_STYLE);

		out += "\nX-Position                                 : " + getProperty(EditorAttributes.X);
		out += "\nY-Position                                 : " + getProperty(EditorAttributes.Y);
		out += "\nBreite                                     : " + getProperty(EditorAttributes.WIDTH);
		out += "\nHöhe                                       : " + getProperty(EditorAttributes.HEIGHT);
		out += "\nVertikale Bildlaufleiste anzeigen          : " + getProperty(EditorAttributes.V_SCROLLBAR);
		
		VisualSubStruct vs = (VisualSubStruct) getProperty(EditorAttributes.VISUAL_STRUCT);

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
		return out;
	}

}

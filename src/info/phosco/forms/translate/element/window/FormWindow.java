package info.phosco.forms.translate.element.window;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;
import info.phosco.forms.translate.element.visual.substruct.VisualAttributes;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStruct;

import java.util.Properties;

public class FormWindow implements FormElement<WindowAttributes> {

	private final Properties props;

	FormWindow(int offset) {
		this.props = new Properties();
		setProperty(WindowAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(WindowAttributes key, Object value) {
		this.props.put(key.toString(), value);

	}

	@Override
	public Object getProperty(WindowAttributes key) {
		return this.props.get(key.toString());
	}

	@Override
	public String getName() {
		return (String) getProperty(WindowAttributes.NAME);
	}

	@Override
	public ElementType getType() {
		return ElementType.WINDOW;
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(WindowAttributes.OFFSET);
	}

	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nName                                       : " + getName();
		out += "\nThema im Hilfebuch                         : " + getProperty(WindowAttributes.HELP);
		out += "\nTitel                                      : " + getProperty(WindowAttributes.TITLE);
		out += "\nPrimäre Leinwand                           : " + Integer.toHexString((int) getProperty(WindowAttributes.PRIMARY_CANVAS));
		out += "\nFensterstil                                : " + getProperty(WindowAttributes.STYLE);
		out += "\nModal                                      : " + getProperty(WindowAttributes.MODAL);
		out += "\nBeim Beenden verbergen                     : " + getProperty(WindowAttributes.HIDE_ON_CLOSE);
		out += "\nSchließen zulässig                         : " + getProperty(WindowAttributes.CLOSE);
		out += "\nVerschieben zulässig                       : " + getProperty(WindowAttributes.MOVE);
		out += "\nMaximieren zulässig                        : " + getProperty(WindowAttributes.MAXIMIZE);
		out += "\nMinimieren erlaubt                         : " + getProperty(WindowAttributes.MINIMIZE);
		out += "\nMinimierter Titel                          : " + getProperty(WindowAttributes.MIN_TITLE);
		out += "\nMenü vererben                              : " + getProperty(WindowAttributes.INHERIT_MENU);
		out += "\nX-Position                                 : " + getProperty(WindowAttributes.X);
		out += "\nY-Position                                 : " + getProperty(WindowAttributes.Y);
		out += "\nWidth                                      : " + getProperty(WindowAttributes.WIDTH);
		out += "\nHeight                                     : " + getProperty(WindowAttributes.HEIGHT);
		out += "\nUmriss                                     : " + getProperty(WindowAttributes.SHAPE);
		out += "\nHorizontale Bildlaufleiste anzeigen        : " + getProperty(WindowAttributes.SHOW_HSCROLLER);
		out += "\nVertikale Bildlaufleiste anzeigen          : " + getProperty(WindowAttributes.SHOW_VSCROLLER);

		VisualSubStruct vs = (VisualSubStruct) getProperty(WindowAttributes.VISUAL_STRUCT);

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

		out += "\nRichtung                                   : " + getProperty(WindowAttributes.DIRECTION);

		return out;
	}

}

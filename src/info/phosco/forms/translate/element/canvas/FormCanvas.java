package info.phosco.forms.translate.element.canvas;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;
import info.phosco.forms.translate.element.canvas.graphic.FormGroup;
import info.phosco.forms.translate.element.visual.substruct.VisualAttributes;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStruct;

import java.util.Properties;

public class FormCanvas implements FormElement<CanvasAttributes> {

	private final Properties props;

	FormCanvas(int offset) {
		this.props = new Properties();
		setProperty(CanvasAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(CanvasAttributes key, Object value) {
		this.props.put(key.toString(), value);

	}

	@Override
	public Object getProperty(CanvasAttributes key) {
		return this.props.get(key.toString());
	}

	@Override
	public String getName() {
		return (String) getProperty(CanvasAttributes.NAME);
	}

	@Override
	public ElementType getType() {
		return ElementType.CANVAS;
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(CanvasAttributes.OFFSET);
	}

	public boolean isScrollbar() {
		return (getProperty(CanvasAttributes.CANVAS_TYPE) == CanvasType.H_TOOLBAR)
				|| (getProperty(CanvasAttributes.CANVAS_TYPE) == CanvasType.V_TOOLBAR);
	}

	public boolean isHorizontalScrollbar() {
		return getProperty(CanvasAttributes.CANVAS_TYPE) == CanvasType.H_TOOLBAR;
	}

	public boolean isVerticalScrollbar() {
		return getProperty(CanvasAttributes.CANVAS_TYPE) == CanvasType.V_TOOLBAR;
	}

	public boolean isStacked() {
		return getProperty(CanvasAttributes.CANVAS_TYPE) == CanvasType.STACKED;
	}

	public boolean isRegister() {
		return getProperty(CanvasAttributes.CANVAS_TYPE) == CanvasType.TAB;
	}

	public boolean hasGraphicTree() {
		return getProperty(CanvasAttributes.GRAPHIC_TREE) != null;
	}

	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nName                                       : " + getName();

		out += "\nLeinwandtyp                                : " + getProperty(CanvasAttributes.CANVAS_TYPE);
		out += "\nThema im Hilfebuch                         : " + getProperty(CanvasAttributes.HELP);
		out += "\nAutomatisch anzeigen                       : " + getProperty(CanvasAttributes.AUTOMATIC);

		if (isStacked() || isRegister()) {
			out += "\nAusschnitt X-Position                      : " + getProperty(CanvasAttributes.VIEWPORT_X);
			out += "\nAusschnitt Y-Position                      : " + getProperty(CanvasAttributes.VIEWPORT_Y);
			out += "\nAusschnittbreite                           : " + getProperty(CanvasAttributes.VIEWPORT_WIDTH);
			out += "\nAusschnitthöhe                             : " + getProperty(CanvasAttributes.VIEWPORT_HEIGHT);
		}

		out += "\nSichtbar                                   : " + getProperty(CanvasAttributes.VISIBLE);
		out += "\nFenster                                    : " + Integer.toHexString((Integer) getProperty(CanvasAttributes.WINDOW));

		if (!isScrollbar() && !isRegister()) {
			out += "\nAusschnitt X-Position auf Leinwand         : " + getProperty(CanvasAttributes.VIEWPORT_X_ON_CANVAS);
			out += "\nAusschnitt Y-Position auf Leinwand         : " + getProperty(CanvasAttributes.VIEWPORT_Y_ON_CANVAS);
		}

		if (!isHorizontalScrollbar() && !isRegister()) {
			out += "\nBreite                                     : " + getProperty(CanvasAttributes.WIDTH);
		}

		if (!isVerticalScrollbar() && !isRegister()) {
			out += "\nHöhe                                       : " + getProperty(CanvasAttributes.HEIGHT);
		}
		out += "\nUmriss                                     : " + getProperty(CanvasAttributes.BEVEL);

		if (isRegister()) {
			out += "\nWinkelstil                                 : " + getProperty(CanvasAttributes.EDGE_STYLE);
			out += "\nStil Breite                                : " + getProperty(CanvasAttributes.STYLE_WIDTH);
			out += "\nAktiver Stil                               : " + getProperty(CanvasAttributes.ACTIVE_STYLE);
			out += "\nRegister-Zuordnungskante                   : " + getProperty(CanvasAttributes.REGISTER_EDGE);
		}

		if (isStacked()) {
			out += "\nHorizontale Bildlaufleiste anzeigen        : " + getProperty(CanvasAttributes.H_SCROLLBAR);
			out += "\nVertikale Bildlaufleiste anzeigen          : " + getProperty(CanvasAttributes.V_SCROLLBAR);
		}

		VisualSubStruct vs = (VisualSubStruct) getProperty(CanvasAttributes.VISUAL_STRUCT);

		out += "\nVisuelle Attributgruppe                    : " + Integer.toHexString(vs.getOffset());
		out += "\nLogisches Attribute Zeichenmodus           : " + vs.getProperty(VisualAttributes.LOGICAL_ATTRIBUTE);
		out += "\nWeiß auf Schwarz                           : " + vs.getProperty(VisualAttributes.WHITE_ON_BLACK);
		out += "\nVordergrundfarbe                           : " + vs.getProperty(VisualAttributes.FOREGROUND);
		out += "\nHintergrundfarbe                           : " + vs.getProperty(VisualAttributes.BACKGROUND);
		out += "\nFüllmuster                                 : " + vs.getProperty(VisualAttributes.FILL_PATTERN);

		if (isRegister()) {
			out += "\nSchriftartname                             : " + vs.getProperty(VisualAttributes.FONT_NAME);
			out += "\nSchriftgrad                                : " + vs.getProperty(VisualAttributes.FONT_SIZE);
			out += "\nSchriftstärke                              : " + vs.getProperty(VisualAttributes.FONT_WEIGHT);
			out += "\nSchriftstil                                : " + vs.getProperty(VisualAttributes.FONT_STYLE);
			out += "\nZeichenabstand                             : " + vs.getProperty(VisualAttributes.CHARACTER_SPACING);
		}

		out += "\nRichtung                                   : " + getProperty(CanvasAttributes.DIRECTION);

		if (hasGraphicTree()) {
			FormGroup node = (FormGroup) getProperty(CanvasAttributes.GRAPHIC_TREE);
			out += "\n" + node.toString();
		}

		return out;
	}
}

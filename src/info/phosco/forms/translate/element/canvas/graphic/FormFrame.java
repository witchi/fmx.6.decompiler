package info.phosco.forms.translate.element.canvas.graphic;

import info.phosco.forms.translate.element.ElementType;

public class FormFrame extends FormGraphic {

	FormFrame(int offset) {
		super(offset);
	}

	@Override
	public ElementType getType() {
		return ElementType.FRAME;
	}

	@Override
	public String toString() {
		String out = super.toString();
		return out;
	}
}

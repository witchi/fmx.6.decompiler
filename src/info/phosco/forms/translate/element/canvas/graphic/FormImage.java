package info.phosco.forms.translate.element.canvas.graphic;

import info.phosco.forms.translate.element.ElementType;

public class FormImage extends FormGraphic {

	FormImage(int offset) {
		super(offset);
	}

	@Override
	public ElementType getType() {
		return ElementType.IMAGE;
	}

	@Override
	public String toString() {
		String out = super.toString();
		
		out += "\nDisplay Quality                            : " + getProperty(GraphicAttributes.QUALITY);
		out += "\nDither                                     : " + getProperty(GraphicAttributes.DITHER);
		
		out += "\nClip X Position                            : " + getProperty(GraphicAttributes.CLIP_X);
		out += "\nClip Y Position                            : " + getProperty(GraphicAttributes.CLIP_Y);
		out += "\nClip Width                                 : " + getProperty(GraphicAttributes.CLIP_WIDTH);
		out += "\nClip Height                                : " + getProperty(GraphicAttributes.CLIP_HEIGHT);
		
		return out;
	}
}

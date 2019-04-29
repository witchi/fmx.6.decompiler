package info.phosco.forms.translate.element.canvas.graphic;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class FormImageFactory extends AbstractFactory {

	private static final int POS_SUBSTRUCT = 0x34;

	private static final int POS_IMAGE_INDEX = 0x3C;

	private static final int POS_CLIP_X = 0x40;

	private static final int POS_CLIP_Y = 0x44;

	private static final int POS_CLIP_WIDTH = 0x48;

	private static final int POS_CLIP_HEIGHT = 0x4c;

	private static final int POS_X = 0x50;

	private static final int POS_Y = 0x54;

	private static final int POS_WIDTH = 0x58;

	private static final int POS_HEIGHT = 0x5c;

	private static final int POS_QUALITY = 0x60;

	private static final int POS_DITHER = 0x62;

	private FormImageFactory() {
	}

	public static FormImage instance(Content content, int offset) throws FileStructureTypeException {

		FormImage res = new FormImage(offset);

		int substruct = content.getInt(offset, POS_SUBSTRUCT);
		res.setProperty(GraphicAttributes.NAME, NameFactory.getName(content, substruct));

		res.setProperty(GraphicAttributes.X, content.getInt(offset, POS_X));
		res.setProperty(GraphicAttributes.Y, content.getInt(offset, POS_Y));
		res.setProperty(GraphicAttributes.WIDTH, content.getInt(offset, POS_WIDTH));
		res.setProperty(GraphicAttributes.HEIGHT, content.getInt(offset, POS_HEIGHT));

		res.setProperty(GraphicAttributes.CLIP_X, content.getInt(offset, POS_CLIP_X));
		res.setProperty(GraphicAttributes.CLIP_Y, content.getInt(offset, POS_CLIP_Y));
		res.setProperty(GraphicAttributes.CLIP_WIDTH, content.getInt(offset, POS_CLIP_WIDTH));
		res.setProperty(GraphicAttributes.CLIP_HEIGHT, content.getInt(offset, POS_CLIP_HEIGHT));

		res.setProperty(GraphicAttributes.QUALITY, ImageQuality.lookup(content.getByte(offset, POS_QUALITY)));
		res.setProperty(GraphicAttributes.DITHER, !bool(content.getByte(offset, POS_DITHER)));

		res.setProperty(GraphicAttributes.IMAGE_INDEX, content.getInt(offset, POS_IMAGE_INDEX));

		// TODO: read properties
		return res;
	}
}

package info.phosco.forms.translate.element.canvas.graphic;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class FormFrameFactory extends AbstractFactory {

	private static final int POS_SUBSTRUCT = 0x34;

	private FormFrameFactory() {
	}

	public static FormFrame instance(Content content, int offset) throws FileStructureTypeException {

		FormFrame res = new FormFrame(offset);

		int substruct = content.getInt(offset, POS_SUBSTRUCT);
		res.setProperty(GraphicAttributes.NAME, NameFactory.getName(content, substruct));

		// TODO: read properties

		return res;
	}
}

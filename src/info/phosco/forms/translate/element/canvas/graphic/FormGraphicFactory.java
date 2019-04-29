package info.phosco.forms.translate.element.canvas.graphic;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.font.FormFont;
import info.phosco.forms.translate.util.FileStructureTypeException;
import info.phosco.forms.translate.util.FormElementTypeException;
import info.phosco.forms.translate.util.Log;

import java.util.logging.Logger;

public class FormGraphicFactory extends AbstractFactory {

	private final static Logger log = Log.getLogger(FormGraphicFactory.class);

	// TODO: this could be smaller than 4 bytes!
	private static final int POS_TYPE = 0x0;

	private static final int POS_PARENT = 0x4;

	private FormGraphicFactory() {
	}

	public static FormGroup instance(Content content, int offset, ElementList<FormFont> fontList) throws FileStructureTypeException,
			FormElementTypeException {

		FormGroup res;

		ElementType type = ElementType.lookup(content.getInt(offset, POS_TYPE));
		switch (type) {

		case GROUP:
			res = FormGroupFactory.get(content, offset, fontList);
			break;

		case RECTANGLE:
			res = FormRectangleFactory.instance(content, offset);
			break;

		case LINE:
			res = FormLineFactory.instance(content, offset);
			break;

		case ARC:
			res = FormArcFactory.instance(content, offset);
			break;

		case TEXT:
			res = FormTextFactory.instance(content, offset, fontList);
			break;

		case FRAME:
			res = FormFrameFactory.instance(content, offset);
			break;

		case IMAGE:
			res = FormImageFactory.instance(content, offset);
			break;

		default:
			throw new FormElementTypeException(type.hex(), offset);
		}

		res.setProperty(GraphicAttributes.PARENT_NODE, content.getInt(offset, POS_PARENT));

		// TODO: read properties

		return res;
	}
}

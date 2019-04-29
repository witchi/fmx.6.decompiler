package info.phosco.forms.translate.element.parameter;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class FormParameterFactory extends AbstractFactory {

	private static final int POS_NAME = 0x0;

	private static final int POS_DATATYPE = 0x8;

	private static final int POS_MAX_LENGTH = 0xC;

	private static final int POS_VALID_DEFAULT = 0x10;

	private static final int POS_DEFAULT_LEN = 0x14;

	private static final int POS_DEFAULT_VALUE = 0x18;

	private FormParameterFactory() {
	}

	public static FormParameter instance(Content content, int offset) throws FileStructureTypeException {
		FormParameter res = new FormParameter(offset);

		int ref = content.getInt(offset, POS_NAME);
		res.setProperty(ParameterAttributes.NAME, content.getString(ref, 2, content.getShort(ref, 0)));

		res.setProperty(ParameterAttributes.DATATYPE, ParameterDatatype.lookup(content.getInt(offset, POS_DATATYPE)));
		res.setProperty(ParameterAttributes.MAX_LENGTH, content.getInt(offset, POS_MAX_LENGTH));

		res.setProperty(ParameterAttributes.VALID_DEFAULT, !bool(content.getInt(offset, POS_VALID_DEFAULT) & 0x3));
		if (res.hasDefault()) {
			ref = content.getInt(offset, POS_DEFAULT_VALUE);
			int len = content.getInt(offset, POS_DEFAULT_LEN);
			res.setProperty(ParameterAttributes.DEFAULT_VALUE, (ref == 0x0 ? "" : content.getString(ref, 0, len)));
		}

		// TODO: read properties (Subclass-Information)

		return res;
	}
}

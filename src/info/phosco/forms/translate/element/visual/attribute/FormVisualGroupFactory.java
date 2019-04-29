package info.phosco.forms.translate.element.visual.attribute;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStructFactory;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class FormVisualGroupFactory extends AbstractFactory {

	private final static int POS_NAME = 0x4;

	private final static int POS_GROUP_TYPE = 0x4C;

	private FormVisualGroupFactory() {
	}

	public static FormVisualGroup instance(Content content, int offset) throws FileStructureTypeException {
		FormVisualGroup res = new FormVisualGroup(offset);
		res.setProperty(VisualGroupAttributes.NAME, content.getString(content.getInt(offset, POS_NAME), 0));

		res.setProperty(VisualGroupAttributes.GROUP_TYPE,
				VisualGroupType.lookup(content.getInt(offset, POS_GROUP_TYPE)));

		res.setProperty(VisualGroupAttributes.VISUAL_STRUCT, VisualSubStructFactory.instance(content, offset));

		// TODO: read properties

		return res;
	}

}

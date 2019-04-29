package info.phosco.forms.translate.element.canvas.graphic;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.font.FormFont;
import info.phosco.forms.translate.util.FileStructureTypeException;
import info.phosco.forms.translate.util.FormElementTypeException;

public class FormGroupFactory {

	private static final int POS_PARENT_NODE = 0x4;

	private static final int POS_CHILD_LIST = 0x3C;

	private static final int POS_CHILD_LIST_LEN = 0x40;

	private static int groupCounter = 0;

	private FormGroupFactory() {
	}

	private synchronized static int nextGroup() {
		return groupCounter++;
	}

	public static FormGroup get(Content content, int offset, ElementList<FormFont> fontList) throws FileStructureTypeException,
			FormElementTypeException {

		FormGroup res = new FormGroup(offset);

		int ref = content.getInt(offset, POS_PARENT_NODE);
		res.setProperty(GraphicAttributes.PARENT_NODE, ref);
		res.setProperty(GraphicAttributes.NAME, "GROUP" + nextGroup());

		int len = content.getInt(offset, POS_CHILD_LIST_LEN);
		res.setProperty(GraphicAttributes.CHILD_LIST_LEN, len);

		ref = content.getInt(offset, POS_CHILD_LIST);
		res.setProperty(GraphicAttributes.CHILD_LIST_OFFSET, ref);

		res.setProperty(GraphicAttributes.CHILD_LIST, GraphicListFactory.get(content, ref, len, fontList));

		// TODO: there are more attributes within the Node structure

		return res;
	}

}

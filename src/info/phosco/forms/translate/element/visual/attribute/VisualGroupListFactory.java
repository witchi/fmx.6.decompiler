package info.phosco.forms.translate.element.visual.attribute;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.util.Log;
import info.phosco.forms.translate.util.FileStructureTypeException;

import java.util.logging.Logger;

public class VisualGroupListFactory {

	private final static Logger log = Log.getLogger(VisualGroupListFactory.class);

	private final static int VISUAL_GROUP_LEN = 0x50;

	private VisualGroupListFactory() {
	}

	/**
	 * The offset contains the structure Id within the lowest byte, so we have
	 * to preserve this.
	 * 
	 * @param offset
	 *            The start address
	 * @param nbr
	 *            The nth structure after the offset. Every structure has a
	 *            length of VISUAL_GROUP_LEN.
	 * @return
	 */
	private static int getStartPos(int offset, int nbr) {
		return offset + ((nbr * VISUAL_GROUP_LEN) << 8);
	}

	/**
	 * Read the list of the VisualAttributes. It starts on offset within the
	 * content, it contains a number of structures stored in len.
	 * 
	 * @param content
	 *            The file content.
	 * @param offset
	 *            the address of the list start address within content
	 * @param len
	 *            Number of VisualAttribute structures within the list
	 * @return
	 * @throws FileStructureTypeException
	 */
	public static ElementList<FormVisualGroup> get(Content content, int offset, int length)
			throws FileStructureTypeException {

		ElementList<FormVisualGroup> res = new ElementList<FormVisualGroup>();

		for (int i = 0; i < length; i++) {
			res.add(FormVisualGroupFactory.instance(content, getStartPos(offset, i)));
		}

		return res;
	}
}

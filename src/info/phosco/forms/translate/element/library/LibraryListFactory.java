package info.phosco.forms.translate.element.library;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class LibraryListFactory {

	private static final int POS_NEXT_RECORD_REF = 0x8;

	private LibraryListFactory() {
	}

	public static ElementList<FormLibrary> get(Content content, int offset) throws FileStructureTypeException {

		ElementList<FormLibrary> res = new ElementList<FormLibrary>();

		int address = offset;
		while (address != 0x0) {
			res.add(FormLibraryFactory.instance(content, address));
			address = content.getInt(address, POS_NEXT_RECORD_REF);
		}

		return res;
	}

}

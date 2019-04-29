package info.phosco.forms.translate.element.library;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class FormLibraryFactory extends AbstractFactory {

	private static final int POS_LOCATION = 0x0;

	private static final int POS_NAME = 0x4;

	private FormLibraryFactory() {
	}

	public static FormLibrary instance(Content content, int offset) throws FileStructureTypeException {

		FormLibrary res = new FormLibrary(offset);

		int ref = content.getInt(offset, POS_NAME);
		res.setProperty(LibraryAttributes.NAME, content.getString(ref, 0));

		ref = content.getInt(offset, POS_LOCATION);
		res.setProperty(LibraryAttributes.LOCATION, content.getString(ref, 0));

		res.setProperty(LibraryAttributes.SOURCE, LibrarySource.FILE);  // TODO: what about databasse and either?
		
		return res;
	}
}

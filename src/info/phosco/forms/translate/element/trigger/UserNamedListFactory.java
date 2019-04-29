package info.phosco.forms.translate.element.trigger;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.util.FileStructureTypeException;

import java.util.ArrayList;
import java.util.List;

public class UserNamedListFactory {

	private static final int MAX_ORACLE_NAME_LEN = 31;

	private UserNamedListFactory() {
	}

	public static List<String> get(Content content, int offset, int length) throws FileStructureTypeException {

		List<String> res = new ArrayList<String>();
		int pos = 0;

		for (int i = 0; i < length; i++) {
			res.add(content.getString(offset, pos));
			pos += MAX_ORACLE_NAME_LEN;
		}

		return res;
	}

}

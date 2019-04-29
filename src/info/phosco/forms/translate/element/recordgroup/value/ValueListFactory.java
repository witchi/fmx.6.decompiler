package info.phosco.forms.translate.element.recordgroup.value;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.recordgroup.column.Column;
import info.phosco.forms.translate.util.ColumnDatatypeException;
import info.phosco.forms.translate.util.DateFormatException;
import info.phosco.forms.translate.util.FileStructureTypeException;

import java.util.ArrayList;
import java.util.List;

/**
 * The list is stored as double-linked list. Every entry contains the link to
 * the next entry and the previous entry. The last entry points to the first
 * entry (as next) and the first entry points to the last entry (as previous).
 * 
 * @author arothe
 *
 */
public class ValueListFactory {

	private static final int POS_NEXT_VALUE = 0x0;
	private static final int POS_PREV_VALUE = 0x4;

	private ValueListFactory() {
	}

	public static List<Value> get(Content content, int startListOffset, Column col) throws FileStructureTypeException,
			ColumnDatatypeException, DateFormatException {

		List<Value> res = new ArrayList<Value>();

		int curr = startListOffset;
		for (;;) {
			res.add(ValueFactory.get(content, curr, col));
			curr = content.getInt(curr, POS_NEXT_VALUE);
			if (curr == startListOffset) {
				break;
			}
		}
		return res;
	}
}

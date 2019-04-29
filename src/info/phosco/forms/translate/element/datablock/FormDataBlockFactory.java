package info.phosco.forms.translate.element.datablock;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.element.Direction;
import info.phosco.forms.translate.util.FileStructureTypeException;
import info.phosco.forms.translate.util.Log;

import java.util.logging.Logger;

public class FormDataBlockFactory extends AbstractFactory {

	private final static Logger log = Log.getLogger(FormDataBlockFactory.class);

	private static final int POS_NAME = 0x4;

	private static final int POS_BITMASK0 = 0xc;

	private static final int POS_BITMASK1 = 0xe;

	private static final int POS_DATA_BLOCK_DESCR = 0x14;

	private static final int POS_NUMBER_RECORDS_DISPLAYED = 0x2c;

	private static final int POS_QUERY_ARRAY_SIZE = 0x68;

	private static final int POS_NUMBER_RECORDS_BUFFERED = 0x6c;

	private static final int POS_WHERE_CLAUSE = 0x74;

	private static final int POS_ORDER_CLAUSE = 0x78;

	private static final int POS_NEXT_NAV_DATA_BLOCK = 0x88;

	private static final int POS_PREV_NAV_DATA_BLOCK = 0x8c;

	private static final int POS_NAVIGATION_STYLE = 0x90;

	private static final int POS_DIRECTION = 0x94;

	private static final int POS_KEY_MODE = 0xbc;

	private static final int POS_LOCKING_MODE = 0xc0;

	private static final int POS_MAX_QUERY_TIME = 0xc4;

	private static final int POS_MAX_RECORDS_FETCHED = 0xc8;

	private static final int POS_ALIAS = 0xac;

	private FormDataBlockFactory() {
	}

	public static FormDataBlock instance(Content content, int offset) throws FileStructureTypeException {

		FormDataBlock res = new FormDataBlock(offset);

		int ref = content.getInt(offset, POS_NAME);
		res.setProperty(DataBlockAttributes.NAME, content.getString(ref, 2, content.getShort(ref, 0)));

		// TODO: where is "Database Data Block", "Enforce Primary Key"?
		// TODO: where is "Query Data Source Type"?

		// The Query_Array_Size has no difference between 0 and 2 in the FMX
		res.setProperty(DataBlockAttributes.QUERY_ARRAY_SIZE, content.getShort(offset, POS_QUERY_ARRAY_SIZE));

		// The Number_Records_Buffered has no difference between 0 and 1 in the
		// FMX
		res.setProperty(DataBlockAttributes.NUMBER_RECORDS_BUFFERED, content.getShort(offset, POS_NUMBER_RECORDS_BUFFERED));

		res.setProperty(DataBlockAttributes.NUMBER_RECORDS_DISPLAYED, content.getShort(offset, POS_NUMBER_RECORDS_DISPLAYED));

		int bitmask = content.getShort(offset, POS_BITMASK0);
		res.setProperty(DataBlockAttributes.DATABASE_DATA_BLOCK, bool(bitmask & 0x1));
		res.setProperty(DataBlockAttributes.LIST_IN_DATA_BLOCK_MENU, bool(bitmask & 0x2));
		res.setProperty(DataBlockAttributes.RECORD_ORIENTATION, RecordOrientation.lookup(bitmask & 0x20));
		res.setProperty(DataBlockAttributes.INSERT_ALLOWED, bool(bitmask & 0x100));
		res.setProperty(DataBlockAttributes.UPDATE_ALLOWED, bool(bitmask & 0x200));
		res.setProperty(DataBlockAttributes.DELETE_ALLOWED, bool(bitmask & 0x400));
		res.setProperty(DataBlockAttributes.QUERY_ALLOWED, bool(bitmask & 0x1000));

		// TODO: 01->05 toggle on set WHERE clause (Marker for Database block or
		// only for valid WHERE clause)
		if ((bitmask & 0x4) != 0) {
			ref = content.getInt(offset, POS_WHERE_CLAUSE);
			if (ref != 0x0) {
				res.setProperty(DataBlockAttributes.WHERE_CLAUSE, content.getString(ref, 0));
			}

			ref = content.getInt(offset, POS_ORDER_CLAUSE);
			if (ref != 0x0) {
				res.setProperty(DataBlockAttributes.ORDER_CLAUSE, content.getString(ref, 0));
			}

			ref = content.getInt(offset, POS_ALIAS);
			if (ref != 0x0) {
				res.setProperty(DataBlockAttributes.ALIAS, content.getString(ref, 0));
			}
		}

		bitmask = content.getShort(offset, POS_BITMASK1);
		res.setProperty(DataBlockAttributes.QUERY_ALL_RECORDS, !bool(bitmask & 0x4));
		res.setProperty(DataBlockAttributes.SINGLE_RECORD, !bool(bitmask & 0x8));

		res.setProperty(DataBlockAttributes.NAVIGATION_STYLE, NavigationStyle.lookup(content.getByte(offset, POS_NAVIGATION_STYLE)));

		ref = content.getInt(offset, POS_PREV_NAV_DATA_BLOCK);
		if (ref != 0x0) {
			res.setProperty(DataBlockAttributes.PREV_NAV_DATA_BLOCK, ref);
		}

		ref = content.getInt(offset, POS_NEXT_NAV_DATA_BLOCK);
		if (ref != 0x0) {
			res.setProperty(DataBlockAttributes.NEXT_NAV_DATA_BLOCK, ref);
		}

		res.setProperty(DataBlockAttributes.KEY_MODE, KeyMode.lookup(content.getShort(offset, POS_KEY_MODE)));

		// TODO: where is "Update Changed Columns Only" and
		// "Enforce Column Security"?

		res.setProperty(DataBlockAttributes.LOCKING_MODE, LockingMode.lookup(content.getByte(offset, POS_LOCKING_MODE)));
		res.setProperty(DataBlockAttributes.MAX_QUERY_TIME, content.getInt(offset, POS_MAX_QUERY_TIME));
		res.setProperty(DataBlockAttributes.MAX_RECORDS_FETCHED, content.getInt(offset, POS_MAX_RECORDS_FETCHED));

		ref = content.getInt(offset, POS_DATA_BLOCK_DESCR);
		if (ref != 0x0) {
			res.setProperty(DataBlockAttributes.DATA_BLOCK_DESCR, content.getString(ref, 0));
		}

		res.setProperty(DataBlockAttributes.DIRECTION, Direction.lookup(content.getByte(offset, POS_DIRECTION)));

		// TODO: read properties

		return res;
	}
}

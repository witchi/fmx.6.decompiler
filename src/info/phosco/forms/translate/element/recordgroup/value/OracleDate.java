package info.phosco.forms.translate.element.recordgroup.value;

import info.phosco.forms.translate.util.DateFormatException;

import java.time.LocalDate;

public class OracleDate implements Value {

	private final LocalDate value;

	private OracleDate(LocalDate val) {
		this.value = val;
	}

	/**
	 * The date format contains 7 bytes:<br>
	 * 1. Byte: century + 100<br>
	 * 2. Byte: year + 100<br>
	 * 3. Byte: month<br>
	 * 4. Byte: day of the month<br>
	 * 5. Byte: hour<br>
	 * 6. Byte: minute<br>
	 * 7. Byte: second
	 * <p>
	 * The raw format is stable for every national language setting, It is the
	 * official internal format for Oracle's DATE datatype.
	 * <p>
	 * The offset of 100 could be a bitmask which differs between the base of
	 * the date, BC or AD.
	 * 
	 * @param array
	 * @return
	 * @see <a href="http://docs.oracle.com">http://docs.oracle.com</a>
	 * 
	 */
	public static OracleDate newInstance(int[] array) throws DateFormatException {
		if (array.length != 7) {
			throw new DateFormatException(array);
		}

		int century = array[0] - 100;
		int year = array[1] - 100;
		int month = array[2];
		int day = array[3];

		return new OracleDate(LocalDate.of(century * 100 + year, month, day));
	}

	@Override
	public String toString() {
		return this.value.toString();
	}

	@Override
	public LocalDate getValue() {
		return this.value; // immutable!
	}
}

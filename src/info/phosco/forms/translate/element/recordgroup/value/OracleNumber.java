package info.phosco.forms.translate.element.recordgroup.value;

import java.math.BigDecimal;
import java.util.Arrays;

public final class OracleNumber implements Value {

	private final BigDecimal value;

	public static final OracleNumber ZERO = new OracleNumber(BigDecimal.ZERO);
	public static final OracleNumber POSITIVE_INFINITY = new OracleNumber(new BigDecimal("1E200"));
	public static final OracleNumber NEGATIVE_INFINITY = new OracleNumber(new BigDecimal("-1E200"));

	OracleNumber(BigDecimal val) {
		this.value = val;
	}

	private OracleNumber(boolean negative, String mantissa, int exponent) {
		this.value = new BigDecimal((negative ? "-" : "") + mantissa + "0E" + exponent).stripTrailingZeros();
	}

	private static boolean isZero(int[] array) {
		return array.length == 1 && array[0] == 0x80;
	}

	private static boolean isNegative(int[] array) {
		return ((array[0] & 0x80) == 0);
	}

	private static boolean hasPositiveExponent(int[] array) {
		return (array[0] & 0x40) != 0;
	}

	private static boolean isPositiveInfinity(int[] array) {
		return (array.length == 2 && array[0] == 0xFF && array[1] == 0x65);
	}

	private static boolean isNegativeInfinity(int[] array) {
		return (array.length == 1 && array[0] == 0x0);
	}

	public static OracleNumber newInstance(int[] array) {

		int[] number = Arrays.copyOf(array, array.length);

		if (isZero(number)) {
			return OracleNumber.ZERO;
		}

		if (isNegativeInfinity(number)) {
			return OracleNumber.NEGATIVE_INFINITY;
		}

		if (isPositiveInfinity(number)) {
			return OracleNumber.POSITIVE_INFINITY;
		}

		if (isNegative(number)) {
			// convert exponent into the equivalent for positive numbers
			number[0] = (short) ((number[0] | 0x80) ^ 0x7F);
		}

		int exponent;

		if (hasPositiveExponent(number)) {
			exponent = ((number[0] & 0x3F) << 1) - 2;
		} else {
			exponent = -1 * (((number[0] ^ 0xBF) << 1) + 4);
		}

		// calculating mantissa
		String mantissa = "";
		for (int i = 1; i < number.length; i++) {
			if (isNegative(array)) {
				mantissa += (number[i] > 0x65) ? "" : (0x65 - number[i]);
			} else {
				mantissa += (number[i] - 1);
			}
			if (i == 1) {
				mantissa += ".";
			}
		}

		return new OracleNumber(isNegative(array), mantissa, exponent);
	}

	@Override
	public String toString() {
		if (this == POSITIVE_INFINITY) {
			return "+INFINITY";
		}
		if (this == NEGATIVE_INFINITY) {
			return "-INFINITY";
		}
		return value.toPlainString();
	}

	@Override
	public BigDecimal getValue() {
		return new BigDecimal(value.toString());
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof OracleNumber)) {
			return false;
		}
		OracleNumber nbr = (OracleNumber) o;
		return getValue().equals(nbr.getValue());
	}

	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
}

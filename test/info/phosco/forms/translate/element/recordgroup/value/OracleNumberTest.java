package info.phosco.forms.translate.element.recordgroup.value;

import static org.junit.Assert.assertEquals;
import info.phosco.forms.translate.util.NumberFormatException;

import java.math.BigDecimal;

import org.junit.Test;

public class OracleNumberTest {

	@Test
	public void testGetNumber_98_98() throws NumberFormatException {
		int[] array = new int[] { 0x3e, 0x03, 0x03, 0x66 };
		assertEquals("-98.98", new OracleNumber(new BigDecimal("-98.98")), OracleNumber.newInstance(array));
	}

	@Test
	public void testGetNumber_412() throws NumberFormatException {
		int[] array = new int[] { 0x3d, 0x61, 0x59, 0x66 };
		assertEquals("-412", new OracleNumber(new BigDecimal("-412")), OracleNumber.newInstance(array));
	}

	@Test
	public void testGetNumber412() throws NumberFormatException {
		int[] array = new int[] { 0xc2, 0x5, 0xd };
		assertEquals("412",new OracleNumber(new BigDecimal("412")), OracleNumber.newInstance(array));
	}

	@Test
	public void testGetNumber0_000000412() throws NumberFormatException {
		int[] array = new int[] { 0xbd, 0x2a, 0x15 };
		assertEquals("0.000000412", new OracleNumber(new BigDecimal("0.000000412")), OracleNumber.newInstance(array));
	}

	@Test
	public void testGetNumber0() throws NumberFormatException {
		int[] array = new int[] { 0x80 };
		assertEquals("Zero test", OracleNumber.ZERO, OracleNumber.newInstance(array));
	}

	@Test
	public void testGetNumber_0_00412() throws NumberFormatException {
		int[] array = new int[] { 0x40, 0x3c, 0x51, 0x66 };
		assertEquals("-0.00412", new OracleNumber(new BigDecimal("-0.00412")), OracleNumber.newInstance(array));
	}

	@Test
	public void testGetNumber9_9E125() throws NumberFormatException {
		int[] array = new int[] { 0xFF, 0x64 };
		assertEquals("9.9E125", new OracleNumber(new BigDecimal("9.9E125")), OracleNumber.newInstance(array));
	}

	@Test
	public void testGetNumber9_9E123() throws NumberFormatException {
		int[] array = new int[] { 0xFE, 0x64 };
		assertEquals("9.9E123", new OracleNumber(new BigDecimal("9.9E123")), OracleNumber.newInstance(array));
	}

	@Test
	public void testGetNumber1E_130() throws NumberFormatException {
		int[] array = new int[] { 0x80, 0x2 };
		assertEquals("1E-130", new OracleNumber(new BigDecimal("1E-130")), OracleNumber.newInstance(array));
	}

	@Test
	public void testGetNumberPositiveInfinity() throws NumberFormatException {
		int[] array = new int[] { 0xFF, 0x65 };
		assertEquals("+INFINITY", OracleNumber.POSITIVE_INFINITY, OracleNumber.newInstance(array));
	}

	@Test
	public void testGetNumberNegativInfinity() throws NumberFormatException {
		int[] array = new int[] { 0x0 };
		assertEquals("-INFINITY", OracleNumber.NEGATIVE_INFINITY, OracleNumber.newInstance(array));
	}

}

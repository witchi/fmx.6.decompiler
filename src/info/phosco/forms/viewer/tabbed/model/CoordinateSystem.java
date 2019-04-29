package info.phosco.forms.viewer.tabbed.model;

import info.phosco.forms.translate.element.application.CoordSystem;
import info.phosco.forms.translate.element.application.CoordSystemUnit;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CoordinateSystem {

	private final CoordSystemUnit unit;

	private final CoordSystem system;

	public CoordinateSystem(CoordSystem system, CoordSystemUnit unit) {
		this.system = system;
		this.unit = unit;
	}

	private String getNumberFormatPattern(int fraction) {
		String pattern = "";
		for (int i = 0; i < fraction; i++) {
			pattern += "0";
		}
		if (fraction > 0) {
			pattern = "." + pattern;
		}
		return "#0" + pattern;
	}

	// TODO: which influence has system to the conversion?
	public String toUnit(int value) {
		NumberFormat formatter = new DecimalFormat(getNumberFormatPattern(unit.significantFraction()));
		return formatter.format(unit.convert(value));
	}

	public Double toUnitDouble(int value) {
		return Double.valueOf(toUnit(value));
	}
	
	public int toScreen(int value) {
		// TODO: implement this
		return 1;
	}

	public String toPoint(int value) {
		NumberFormat formatter = new DecimalFormat(getNumberFormatPattern(2));
		return formatter.format(CoordSystemUnit.POINT.convert(value));
	}

}

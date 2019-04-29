package info.phosco.forms.translate.element.parameter;

public enum ParameterDatatype {

	CHARACTER(0x1), NUMBER(0x3), DATE(0x4);

	private final int datatype;

	private ParameterDatatype(int datatype) {
		this.datatype = datatype;
	}

	public static ParameterDatatype lookup(int datatype) {
		for (ParameterDatatype t : ParameterDatatype.values()) {
			if (t.datatype == datatype) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown ParameterDatatype " + datatype);
	}

}

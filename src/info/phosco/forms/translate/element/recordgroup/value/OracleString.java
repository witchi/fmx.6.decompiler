package info.phosco.forms.translate.element.recordgroup.value;

public class OracleString implements Value {

	private final String value;

	private OracleString(String val) {
		this.value = val;
	}

	public static OracleString newInstance(String val) {
		return new OracleString(val);
	}

	@Override
	public String toString() {
		return this.value.toString();
	}

	@Override
	public Object getValue() {
		return this.value;
	}

}

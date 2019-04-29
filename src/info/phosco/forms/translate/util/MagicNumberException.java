package info.phosco.forms.translate.util;

public class MagicNumberException extends DecompilerException {

	private static final long serialVersionUID = -7723416210618437902L;

	@Override
	public String getMessage() {
		return "The file has not been compiled by an Oracle FormsBuilder.";
	}
}

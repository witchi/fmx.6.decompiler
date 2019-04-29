package info.phosco.forms.translate.util;

import info.phosco.forms.translate.loader.FormsVersion;

public class FormsVersionException extends DecompilerException {

	private static final long serialVersionUID = -3192982050497484328L;

	private final FormsVersion version;

	public FormsVersionException(FormsVersion version) {
		this.version = version;
	}

	@Override
	public String getMessage() {
		return "The file has been built by an unsupported FormsBuilder version ("
				+ this.version.toString() + ").";
	}
}

package info.phosco.forms.translate.util;

import info.phosco.forms.translate.element.recordgroup.column.ColumnDatatype;

public class ColumnDatatypeException extends DecompilerException {

	private static final long serialVersionUID = 3150209310861513910L;
	private final String name;
	private final ColumnDatatype type;

	public ColumnDatatypeException(String name, ColumnDatatype type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String getMessage() {
		return "There is an unknown datatype (" + type + ") of a column (" + name + ").\n";
	}
}

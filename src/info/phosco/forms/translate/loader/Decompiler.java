package info.phosco.forms.translate.loader;

import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.util.DecompilerException;

public interface Decompiler {

	FormModule execute() throws DecompilerException;
}

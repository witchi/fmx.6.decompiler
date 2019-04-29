package info.phosco.forms.translate.element.program;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class ProgramUnitListFactory {

	// The entry has a length of 0x20
	private static final int POS_NEXT_RECORD_REF = 0x0;
	
	
	private ProgramUnitListFactory() {
	}

	public static ElementList<FormProgramUnit> get(Content content, int offset) throws FileStructureTypeException {

		ElementList<FormProgramUnit> res = new ElementList<FormProgramUnit>();

		int address = offset;
		while (address != 0x0) {
			res.add(FormProgramUnitFactory.instance(content, address));
			address = content.getInt(address, POS_NEXT_RECORD_REF);
		}

		return res;
	}

}

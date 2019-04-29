package info.phosco.forms.translate.element.program;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.util.FileStructureTypeException;

public class FormProgramUnitFactory extends AbstractFactory {

	private static final int POS_NAME = 0x4;

	private static final int POS_UNIT_TYPE = 0x14;

	private static final int POS_SOURCE = 0x18;

	private FormProgramUnitFactory() {
	}

	public static FormProgramUnit instance(Content content, int offset) throws FileStructureTypeException {

		FormProgramUnit res = new FormProgramUnit(offset);

		int ref = content.getInt(offset, POS_NAME);
		res.setProperty(ProgramUnitAttributes.NAME, content.getString(ref, 2, content.getShort(ref, 0)));

		res.setProperty(ProgramUnitAttributes.TYPE, ProgramUnitType.lookup(content.getInt(offset, POS_UNIT_TYPE)));

		ref = content.getInt(offset, POS_SOURCE);
		res.setProperty(ProgramUnitAttributes.SOURCE, SourceCodeFactory.instance(content, ref));

		return res;
	}
}

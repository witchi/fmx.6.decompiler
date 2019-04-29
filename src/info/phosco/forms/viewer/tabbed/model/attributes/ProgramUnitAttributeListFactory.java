package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.program.FormProgramUnit;
import info.phosco.forms.translate.element.program.ProgramUnitAttributes;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;

import java.util.ArrayList;
import java.util.List;

public class ProgramUnitAttributeListFactory {

	public static List<Attribute> getList(FormProgramUnit unit) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("program_unit.general")));
		res.add(new Attribute(Resource.getString("program_unit.general.name"), unit.getName()));
		res.add(new Attribute(Resource.getString("program_unit.general.offset"), "0x" + Integer.toHexString(unit.getOffset())));

		res.add(new CaptionAttribute(Resource.getString("program_unit.functional")));
		res.add(new Attribute(Resource.getString("program_unit.functional.unit_text"), unit.getProperty(ProgramUnitAttributes.SOURCE)));

		return res;
	}
}

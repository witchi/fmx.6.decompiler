package info.phosco.forms.viewer.tabbed.model.browser;

import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.application.ModuleAttributes;
import info.phosco.forms.translate.element.program.FormProgramUnit;
import info.phosco.forms.translate.element.program.ProgramUnitAttributes;
import info.phosco.forms.translate.element.program.ProgramUnitType;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.model.NodeType;

public class ProgramUnitTreeFactory {

	private ProgramUnitTreeFactory() {
	}

	private static String getProgramUnitType(FormProgramUnit program) {

		String type;
		switch ((ProgramUnitType) program.getProperty(ProgramUnitAttributes.TYPE)) {

		case PROCEDURE_OR_FUNCTION:
			type = Resource.getString("unit.type.body");
			break;

		case PACKAGE_SPEC:
			type = Resource.getString("unit.type.package_spec");
			break;

		case PACKAGE_BODY:
			type = Resource.getString("unit.type.package_body");
			break;

		default:
			type = Resource.getString("unit.type.unknown");
		}

		return " (" + type + ")";
	}

	@SuppressWarnings("unchecked")
	public static BrowserTreeNode build(FormModule module) {

		BrowserTreeNode program = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.program_units"));

		for (FormProgramUnit p : (ElementList<FormProgramUnit>) module.getProperty(ModuleAttributes.PROGRAM_UNIT_LIST)) {
			BrowserTreeNode pnode = new BrowserTreeNode(p.getOffset(), new NodeType[] { NodeType.SOURCECODE, NodeType.ATTRIBUTES }, p.getName()
					+ getProgramUnitType(p), null, ThumbnailFactory.get(p.getType()));
			program.add(pnode);
		}
		return program;
	}

}

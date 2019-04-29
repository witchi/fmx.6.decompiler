package info.phosco.forms.viewer.tabbed.model.browser;

import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.application.ModuleAttributes;
import info.phosco.forms.translate.element.parameter.FormParameter;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.model.NodeType;

public class ParameterTreeFactory {

	private ParameterTreeFactory() {
	}

	@SuppressWarnings("unchecked")
	public static BrowserTreeNode build(FormModule module) {

		BrowserTreeNode parameter = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.parameters"));

		for (FormParameter p : (ElementList<FormParameter>) module.getProperty(ModuleAttributes.PARAMETER_LIST)) {
			BrowserTreeNode pnode = new BrowserTreeNode(p.getOffset(), NodeType.ATTRIBUTES, p.getName(), null, ThumbnailFactory.get(p.getType()));
			parameter.add(pnode);
		}
		return parameter;
	}

}

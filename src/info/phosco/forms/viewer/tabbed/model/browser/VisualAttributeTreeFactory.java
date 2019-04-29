package info.phosco.forms.viewer.tabbed.model.browser;

import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.application.ModuleAttributes;
import info.phosco.forms.translate.element.visual.attribute.FormVisualGroup;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.model.NodeType;

public class VisualAttributeTreeFactory {

	private VisualAttributeTreeFactory() {
	}

	@SuppressWarnings("unchecked")
	public static BrowserTreeNode build(FormModule module) {

		BrowserTreeNode visual = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.visual_attributes"));

		for (FormVisualGroup vg : (ElementList<FormVisualGroup>) module.getProperty(ModuleAttributes.VISUAL_GROUP_LIST)) {
			if (!vg.isDefault()) {
				BrowserTreeNode vnode = new BrowserTreeNode(vg.getOffset(), NodeType.ATTRIBUTES, vg.getName(), null, ThumbnailFactory.get(vg
						.getType()));
				visual.add(vnode);
			}
		}
		return visual;
	}
}

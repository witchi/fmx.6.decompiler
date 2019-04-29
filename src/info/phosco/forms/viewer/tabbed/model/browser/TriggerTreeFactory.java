package info.phosco.forms.viewer.tabbed.model.browser;

import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.application.ModuleAttributes;
import info.phosco.forms.translate.element.trigger.FormTrigger;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.model.NodeType;

public class TriggerTreeFactory {

	private TriggerTreeFactory() {
	}

	@SuppressWarnings("unchecked")
	public static BrowserTreeNode build(FormModule module) {
		BrowserTreeNode trigger = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.triggers"));

		for (FormTrigger t : (ElementList<FormTrigger>) module.getProperty(ModuleAttributes.TRIGGER_LIST)) {
			BrowserTreeNode tnode = new BrowserTreeNode(t.getOffset(), new NodeType[] { NodeType.SOURCECODE, NodeType.ATTRIBUTES }, t.getName(),
					null, ThumbnailFactory.get(t.getType()));
			trigger.add(tnode);
		}

		return trigger;
	}

}

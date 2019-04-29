package info.phosco.forms.viewer.tabbed.model.browser;

import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.alert.FormAlert;
import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.application.ModuleAttributes;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.model.NodeType;

public class AlertTreeFactory {

	private AlertTreeFactory() {
	}

	@SuppressWarnings("unchecked")
	public static BrowserTreeNode build(FormModule module) {
		BrowserTreeNode alert = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.alerts"));

		for (FormAlert a : (ElementList<FormAlert>) module.getProperty(ModuleAttributes.WARNING_LIST)) {
			BrowserTreeNode anode = new BrowserTreeNode(a.getOffset(), NodeType.ATTRIBUTES, a.getName(), null, ThumbnailFactory.get(a.getType()));
			alert.add(anode);
		}

		return alert;
	}

}

package info.phosco.forms.viewer.tabbed.model.browser;

import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.application.ModuleAttributes;
import info.phosco.forms.translate.element.window.FormWindow;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.model.NodeType;

public class WindowTreeFactory {

	private WindowTreeFactory() {
	}

	@SuppressWarnings("unchecked")
	public static BrowserTreeNode build(FormModule module) {

		BrowserTreeNode window = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.windows"));

		for (FormWindow w : (ElementList<FormWindow>) module.getProperty(ModuleAttributes.WINDOW_LIST)) {
			BrowserTreeNode wnode = new BrowserTreeNode(w.getOffset(), NodeType.ATTRIBUTES, w.getName(), null, ThumbnailFactory.get(w.getType()));
			window.add(wnode);
		}

		return window;
	}
}

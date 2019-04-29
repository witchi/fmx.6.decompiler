package info.phosco.forms.viewer.tabbed.model.browser;

import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.application.ModuleAttributes;
import info.phosco.forms.translate.element.library.FormLibrary;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.model.NodeType;

public class LibraryTreeFactory {

	private LibraryTreeFactory() {
	}

	@SuppressWarnings("unchecked")
	public static BrowserTreeNode build(FormModule module) {
		BrowserTreeNode library = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.libraries"));

		for (FormLibrary l : (ElementList<FormLibrary>) module.getProperty(ModuleAttributes.LIBRARY_LIST)) {
			BrowserTreeNode lnode = new BrowserTreeNode(l.getOffset(), NodeType.ATTRIBUTES, l.getName(), null, ThumbnailFactory.get(l.getType()));
			library.add(lnode);
		}

		return library;
	}

}

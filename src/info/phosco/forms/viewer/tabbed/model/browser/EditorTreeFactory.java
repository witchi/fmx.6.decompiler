package info.phosco.forms.viewer.tabbed.model.browser;

import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.application.ModuleAttributes;
import info.phosco.forms.translate.element.editor.FormEditor;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.model.NodeType;

public class EditorTreeFactory {

	private EditorTreeFactory() {
	}

	@SuppressWarnings("unchecked")
	public static BrowserTreeNode build(FormModule module) {
		BrowserTreeNode editor = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.editors"));

		for (FormEditor e : (ElementList<FormEditor>) module.getProperty(ModuleAttributes.EDITOR_LIST)) {
			BrowserTreeNode enode = new BrowserTreeNode(e.getOffset(), NodeType.ATTRIBUTES, e.getName(), null, ThumbnailFactory.get(e.getType()));
			editor.add(enode);
		}
		return editor;
	}

}

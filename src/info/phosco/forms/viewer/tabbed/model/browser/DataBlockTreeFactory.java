package info.phosco.forms.viewer.tabbed.model.browser;

import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.application.ModuleAttributes;
import info.phosco.forms.translate.element.datablock.FormDataBlock;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.model.NodeType;

public class DataBlockTreeFactory {

	private DataBlockTreeFactory() {
	}

	@SuppressWarnings("unchecked")
	public static BrowserTreeNode build(FormModule module) {

		BrowserTreeNode dataBlock = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.data_blocks"));

		for (FormDataBlock d : (ElementList<FormDataBlock>) module.getProperty(ModuleAttributes.DATABLOCK_LIST)) {
			BrowserTreeNode dnode = new BrowserTreeNode(d.getOffset(), NodeType.ATTRIBUTES, d.getName(), null, ThumbnailFactory.get(d.getType()));
			dataBlock.add(dnode);

			BrowserTreeNode n = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.data_blocks.triggers"));
			dnode.add(n);

			n = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.data_blocks.items"));
			dnode.add(n);

			n = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.data_blocks.relations"));
			dnode.add(n);

			// TODO: add more subdata
		}
		return dataBlock;
	}
}

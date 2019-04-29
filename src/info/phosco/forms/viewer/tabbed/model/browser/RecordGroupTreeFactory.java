package info.phosco.forms.viewer.tabbed.model.browser;

import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.application.ModuleAttributes;
import info.phosco.forms.translate.element.recordgroup.FormRecordGroup;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.model.NodeType;

public class RecordGroupTreeFactory {

	private RecordGroupTreeFactory() {
	}

	@SuppressWarnings("unchecked")
	public static BrowserTreeNode build(FormModule module) {

		BrowserTreeNode record = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.record_groups"));

		for (FormRecordGroup rg : (ElementList<FormRecordGroup>) module.getProperty(ModuleAttributes.RECORD_GROUP_LIST)) {
			BrowserTreeNode rnode = new BrowserTreeNode(rg.getOffset(), NodeType.ATTRIBUTES, rg.getName(), null, ThumbnailFactory.get(rg.getType()));
			record.add(rnode);
		}
		return record;
	}

}

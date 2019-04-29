package info.phosco.forms.viewer.tabbed.model.browser;

import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.model.NodeType;

public class FormBrowserTreeFactory {

	public static BrowserTreeNode build(FormModule module) {
		BrowserTreeNode form = new BrowserTreeNode(module.getOffset(), NodeType.ATTRIBUTES, module.getName(), null, Resource.getImage("form.png"));

		BrowserTreeNode node = TriggerTreeFactory.build(module);
		form.add(node);

		node = AlertTreeFactory.build(module);
		form.add(node);

		node = LibraryTreeFactory.build(module);
		form.add(node);

		node = DataBlockTreeFactory.build(module);
		form.add(node);

		node = CanvasTreeFactory.build(module);
		form.add(node);

		node = EditorTreeFactory.build(module);
		form.add(node);

		node = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.lovs"));
		form.add(node);

		node = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.object_groups"));
		form.add(node);

		node = ParameterTreeFactory.build(module);
		form.add(node);

		node = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.popup_menus"));
		form.add(node);

		node = ProgramUnitTreeFactory.build(module);
		form.add(node);

		node = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.property_classes"));
		form.add(node);

		node = RecordGroupTreeFactory.build(module);
		form.add(node);

		node = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.reports"));
		form.add(node);

		node = VisualAttributeTreeFactory.build(module);
		form.add(node);

		node = WindowTreeFactory.build(module);
		form.add(node);

		return form;
	}

}

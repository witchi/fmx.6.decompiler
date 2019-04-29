package info.phosco.forms.viewer.tabbed.model.browser;

import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.application.ModuleAttributes;
import info.phosco.forms.translate.element.canvas.CanvasAttributes;
import info.phosco.forms.translate.element.canvas.FormCanvas;
import info.phosco.forms.translate.element.canvas.graphic.FormGroup;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.model.NodeType;

public class CanvasTreeFactory {

	private CanvasTreeFactory() {
	}

	private static void buildGraphicTree(FormGroup graphic, BrowserTreeNode node) {

		BrowserTreeNode elem = new BrowserTreeNode(graphic.getOffset(), NodeType.ATTRIBUTES, graphic.getName(), null, ThumbnailFactory.get(graphic
				.getType()));
		node.add(elem);

		if (graphic.getType() == ElementType.GROUP) {
			BrowserTreeNode folder = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.canvases.graphics"));
			elem.add(folder);

			for (FormGroup child : graphic.getChildren()) {
				buildGraphicTree(child, folder);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static BrowserTreeNode build(FormModule module) {
		BrowserTreeNode canvas = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.canvases"));

		for (FormCanvas c : (ElementList<FormCanvas>) module.getProperty(ModuleAttributes.CANVAS_LIST)) {
			BrowserTreeNode cnode = new BrowserTreeNode(c.getOffset(), new NodeType[] { NodeType.LAYOUT, NodeType.ATTRIBUTES }, c.getName(), null,
					ThumbnailFactory.get(c.getType()));
			canvas.add(cnode);

			BrowserTreeNode gnode = new BrowserTreeNode(0, NodeType.FOLDER, Resource.getString("node.name.forms.canvases.graphics"));
			cnode.add(gnode);

			if (c.hasGraphicTree()) {
				FormGroup ge = (FormGroup) c.getProperty(CanvasAttributes.GRAPHIC_TREE);
				for (FormGroup child : ge.getChildren()) {
					buildGraphicTree(child, gnode);
				}
			}
		}

		return canvas;
	}
}

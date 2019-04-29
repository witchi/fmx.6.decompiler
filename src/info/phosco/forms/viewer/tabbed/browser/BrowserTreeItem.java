package info.phosco.forms.viewer.tabbed.browser;

import info.phosco.forms.viewer.tabbed.model.NodeType;
import javafx.scene.control.TreeItem;

public class BrowserTreeItem extends TreeItem<BrowserTreeNode> {

	public BrowserTreeItem(BrowserTreeNode node) {
		super(node);
	}

	@Override
	public boolean isLeaf() {
		return (getValue().getTypes().contains(NodeType.FOLDER) && getValue().getChildren().size() == 0) ? false : super.isLeaf();
	}

}

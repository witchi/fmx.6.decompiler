package info.phosco.forms.viewer.tabbed.browser;

import javafx.event.EventHandler;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

public class BrowserTreeImpl implements BrowserTree {

	private TreeView<BrowserTreeNode> treeView;

	@Override
	public TreeView<BrowserTreeNode> getUI() {
		if (treeView == null) {
			treeView = new TreeView<BrowserTreeNode>();
			treeView.setShowRoot(false);
		}
		return treeView;
	}

	@Override
	public void setOnMouseClicked(EventHandler<MouseEvent> handler) {
		getUI().setOnMouseClicked(handler);
	}

	@Override
	public BrowserTreeItem getSelectedItem() {
		return (BrowserTreeItem) getUI().getSelectionModel().getSelectedItem();
	}

	@Override
	public void clear() {
		getUI().setRoot(null);
	}

	@Override
	public void setSelectedItem(BrowserTreeItem item) {
		getUI().getSelectionModel().select(item);
	}

}

package info.phosco.forms.viewer.tabbed.browser;

import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

public class BrowserTreeCellFactory implements Callback<TreeView<BrowserTreeNode>, TreeCell<BrowserTreeNode>> {

	private final TreeViewMouseEventHandler mouseHandler;

	public BrowserTreeCellFactory(TreeViewMouseEventHandler mouseHandler) {
		this.mouseHandler = mouseHandler;
	}

	@Override
	public TreeCell<BrowserTreeNode> call(TreeView<BrowserTreeNode> param) {
		return new BrowserTreeCell(mouseHandler);
	}
}

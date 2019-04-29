package info.phosco.forms.viewer.tabbed.browser;

import javafx.event.EventHandler;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

public interface BrowserTree {

	TreeView<BrowserTreeNode> getUI();

	BrowserTreeItem getSelectedItem();

	void setSelectedItem(BrowserTreeItem item);

	void setOnMouseClicked(EventHandler<MouseEvent> handler);

	void clear();
}

package info.phosco.forms.viewer.tabbed.browser;

import info.phosco.forms.viewer.tabbed.detail.DetailAreaController;
import info.phosco.forms.viewer.tabbed.model.ApplicationModel;
import info.phosco.forms.viewer.tabbed.model.ModelChangeEvent;
import info.phosco.forms.viewer.tabbed.model.ModelChangeListener;
import javafx.scene.control.TreeItem;

public class BrowserTreeController implements ModelChangeListener {

	private final ApplicationModel model;

	private final BrowserTree view;

	private final DetailAreaController control;

	public BrowserTreeController(ApplicationModel model, BrowserTree view, DetailAreaController control) {
		this.model = model;
		this.view = view;
		this.control = control;

		model.addModelChangeListener(this);

		view.getUI().setCellFactory(new BrowserTreeCellFactory(new TreeViewMouseEventHandler(model, view, control)));
		view.getUI().getSelectionModel().selectedItemProperty().addListener(new TreeViewSelectionChangeHandler(model));

		model.createEmptyTree();
	}

	private void buildSubtree(BrowserTreeNode node, BrowserTreeItem item) {
		for (BrowserTreeNode n : node.getChildren()) {
			BrowserTreeItem i = new BrowserTreeItem(n);
			item.getChildren().add(i);
			buildSubtree(n, i);
		}
	}

	private void addNode(BrowserTreeNode node) {
		BrowserTreeItem item = new BrowserTreeItem(node);
		item.setExpanded(true);

		buildSubtree(node, item);

		BrowserTreeItem parent = findTreeItem(node.getParent(), (BrowserTreeItem) view.getUI().getRoot());
		if (parent == null) {
			view.getUI().setRoot(item);
		} else {
			parent.getChildren().add(item);
			parent.setExpanded(true);
			view.setSelectedItem(item);
		}
	}

	private void removeNode(BrowserTreeNode node) {
		BrowserTreeItem item = findTreeItem(node, (BrowserTreeItem) view.getUI().getRoot());
		if (item != null) {
			view.setSelectedItem((BrowserTreeItem) item.getParent());
			item.getParent().getChildren().remove(item);
		}
	}

	@Override
	public void onChangeEvent(ModelChangeEvent e) {
		if (e instanceof TreeChangeAddEvent) {
			addNode(((TreeChangeAddEvent) e).getAddedNode());
		}

		if (e instanceof TreeChangeRemoveEvent) {
			removeNode(((TreeChangeRemoveEvent) e).getRemovedNode());
		}
	}

	private BrowserTreeItem findTreeItem(BrowserTreeNode node, BrowserTreeItem item) {
		if ((item == null) || (item.getValue() == node)) {
			return item;
		}
		for (TreeItem<BrowserTreeNode> i : item.getChildren()) {
			BrowserTreeItem res = findTreeItem(node, (BrowserTreeItem) i);
			if (res != null) {
				return res;
			}
		}
		return null;
	}

}

package info.phosco.forms.viewer.tabbed.browser;

import info.phosco.forms.translate.util.Log;
import info.phosco.forms.viewer.tabbed.model.ApplicationModel;

import java.util.logging.Logger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeItem;

public class TreeViewSelectionChangeHandler implements ChangeListener<TreeItem<BrowserTreeNode>> {

	private final static Logger log = Log.getLogger(TreeViewSelectionChangeHandler.class);

	private final ApplicationModel model;

	public TreeViewSelectionChangeHandler(ApplicationModel model) {
		this.model = model;
	}

	@Override
	public void changed(ObservableValue<? extends TreeItem<BrowserTreeNode>> observable, TreeItem<BrowserTreeNode> oldValue,
			TreeItem<BrowserTreeNode> newValue) {
		log.fine("TreeChangeEvent " + newValue);

		model.setSelectedTreeNode(newValue == null ? null : newValue.getValue());
	}

}

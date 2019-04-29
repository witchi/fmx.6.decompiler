package info.phosco.forms.viewer.tabbed.browser;

import info.phosco.forms.viewer.tabbed.model.ModelChangeEvent;

public class TreeSelectionChangeEvent extends ModelChangeEvent {

	private final BrowserTreeNode node;

	public TreeSelectionChangeEvent(BrowserTreeNode node) {
		this.node = node;
	}

	public BrowserTreeNode getSelectedNode() {
		return this.node;
	}
}

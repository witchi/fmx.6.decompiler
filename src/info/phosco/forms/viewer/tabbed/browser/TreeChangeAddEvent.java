package info.phosco.forms.viewer.tabbed.browser;

import info.phosco.forms.viewer.tabbed.model.ModelChangeEvent;

public class TreeChangeAddEvent extends ModelChangeEvent {

	private final BrowserTreeNode node;

	public TreeChangeAddEvent(BrowserTreeNode node) {
		this.node = node;
	}

	public BrowserTreeNode getAddedNode() {
		return this.node;
	}
}

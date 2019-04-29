package info.phosco.forms.viewer.tabbed.browser;

import info.phosco.forms.viewer.tabbed.model.ModelChangeEvent;

public class TreeChangeRemoveEvent extends ModelChangeEvent {

	private final BrowserTreeNode node;

	public TreeChangeRemoveEvent(BrowserTreeNode node) {
		this.node = node;
	}

	public BrowserTreeNode getRemovedNode() {
		return this.node;
	}
}

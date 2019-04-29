package info.phosco.forms.viewer.tabbed.detail;

import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.model.NodeType;

public class DetailAreaTabContent {

	private final BrowserTreeNode node;

	private final NodeType displayType;

	DetailAreaTabContent(BrowserTreeNode node, NodeType displayType) {
		this.node = node;
		this.displayType = displayType;
	}

	public BrowserTreeNode getNode() {
		return node;
	}

	public NodeType getDisplayType() {
		return displayType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((displayType == null) ? 0 : displayType.hashCode());
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailAreaTabContent other = (DetailAreaTabContent) obj;
		if (displayType != other.displayType)
			return false;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		return true;
	}
	
	
}

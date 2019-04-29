package info.phosco.forms.viewer.tabbed.browser;

import info.phosco.forms.viewer.tabbed.model.NodeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.scene.Node;
import javafx.scene.control.Tooltip;

public class BrowserTreeNode {

	private final String name;

	private final int offset;

	private final HashSet<NodeType> types;

	private BrowserTreeNode parent;

	private final ArrayList<BrowserTreeNode> children;

	private final Node thumbnail;

	private final Tooltip tooltip;

	public BrowserTreeNode(int offset, NodeType[] types, String name, Tooltip tooltip, Node thumbnail) {
		this.children = new ArrayList<BrowserTreeNode>();
		this.offset = offset;
		this.types = new HashSet<NodeType>(Arrays.asList(types));
		this.name = name;
		this.thumbnail = thumbnail;
		this.tooltip = tooltip;
	}

	public BrowserTreeNode(int offset, NodeType type, String name, Tooltip tooltip, Node thumbnail) {
		this(offset, new NodeType[] { type }, name, tooltip, thumbnail);
	}

	public BrowserTreeNode(int offset, NodeType type, String name) {
		this(offset, type, name, null, null);
	}

	public List<BrowserTreeNode> getChildren() {
		return children;
	}

	public BrowserTreeNode getParent() {
		return this.parent;
	}

	public Node getThumbnail() {
		return this.thumbnail;
	}

	public Tooltip getTooltip() {
		return this.tooltip;
	}

	public String getName() {
		return name;
	}

	public int getOffset() {
		return offset;
	}

	public Set<NodeType> getTypes() {
		return Collections.unmodifiableSet(types);
	}

	public boolean hasAttributes() {
		return types.contains(NodeType.ATTRIBUTES);
	}

	public boolean hasLayout() {
		return types.contains(NodeType.LAYOUT);
	}

	public boolean hasSourcecode() {
		return types.contains(NodeType.SOURCECODE);
	}

	public boolean isRoot() {
		return types.contains(NodeType.ROOT);
	}

	public boolean isFolder() {
		return types.contains(NodeType.FOLDER);
	}

	@Override
	public String toString() {
		return this.name;
	}

	public void add(BrowserTreeNode node) {
		this.children.add(node);
		node.parent = this;
	}

	public String getFullPath() {
		BrowserTreeNode p = getParent();
		if (p == null) {
			return "";
		}
		return p.getFullPath() + "/" + getName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + offset;
		result = prime * result + types.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof BrowserTreeNode)) {
			return false;
		}
		BrowserTreeNode other = (BrowserTreeNode) obj;

		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (offset != other.offset) {
			return false;
		}
		if (!types.equals(other.types)) {
			return false;
		}
		return true;
	}
}

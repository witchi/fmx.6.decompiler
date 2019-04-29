package info.phosco.forms.viewer.tabbed.model.browser;

import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.model.NodeType;

public class EmptyBrowserTreeFactory {

	public static final int OFFSET_ROOT_FOLDER = 0;
	public static final int OFFSET_FORM_FOLDER = -10;
	public static final int OFFSET_MENUE_FOLDER = -20;
	public static final int OFFSET_PLSQL_FOLDER = -30;
	public static final int OFFSET_OBJECT_FOLDER = -40;
	public static final int OFFSET_BUILTIN_FOLDER = -50;
	public static final int OFFSET_DATABASE_FOLDER = -60;

	private static BrowserTreeNode getTreeRoot() {
		return new BrowserTreeNode(OFFSET_ROOT_FOLDER, new NodeType[] { NodeType.ROOT }, Resource.getString("browser.tree.root.title"), null, null);
	}

	private static BrowserTreeNode getFormFolder() {
		return new BrowserTreeNode(OFFSET_FORM_FOLDER, new NodeType[] { NodeType.ROOT, NodeType.FOLDER },
				Resource.getString("browser.tree.forms.title"), null, null);
	}

	private static BrowserTreeNode getMenuFolder() {
		return new BrowserTreeNode(OFFSET_MENUE_FOLDER, new NodeType[] { NodeType.ROOT, NodeType.FOLDER },
				Resource.getString("browser.tree.menues.title"), null, null);
	}

	private static BrowserTreeNode getPlsqlFolder() {
		return new BrowserTreeNode(OFFSET_PLSQL_FOLDER, new NodeType[] { NodeType.ROOT, NodeType.FOLDER },
				Resource.getString("browser.tree.plsql_libraries.title"), null, null);
	}

	private static BrowserTreeNode getObjectFolder() {
		return new BrowserTreeNode(OFFSET_OBJECT_FOLDER, new NodeType[] { NodeType.ROOT, NodeType.FOLDER },
				Resource.getString("browser.tree.object_libraries.title"), null, null);
	}

	private static BrowserTreeNode getBuiltinFolder() {
		return new BrowserTreeNode(OFFSET_BUILTIN_FOLDER, new NodeType[] { NodeType.ROOT, NodeType.FOLDER },
				Resource.getString("browser.tree.builtin_packages.title"), null, null);
	}

	private static BrowserTreeNode getDatabaseFolder() {
		return new BrowserTreeNode(OFFSET_DATABASE_FOLDER, new NodeType[] { NodeType.ROOT, NodeType.FOLDER },
				Resource.getString("browser.tree.database_objects.title"), null, null);
	}

	public static BrowserTreeNode build() {
		BrowserTreeNode root = getTreeRoot();
		root.add(getFormFolder());
		root.add(getMenuFolder());
		root.add(getPlsqlFolder());
		root.add(getObjectFolder());
		root.add(getBuiltinFolder());
		root.add(getDatabaseFolder());
		return root;
	}

}

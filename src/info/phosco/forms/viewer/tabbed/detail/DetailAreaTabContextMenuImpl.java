package info.phosco.forms.viewer.tabbed.detail;

import info.phosco.forms.viewer.resource.Resource;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class DetailAreaTabContextMenuImpl implements DetailAreaTabContextMenu {

	private ContextMenu contextMenu;

	private MenuItem closeItem;

	private MenuItem closeAllItem;

	private MenuItem closeOthersItem;

	public MenuItem getCloseAllMenuItem() {
		if (closeAllItem == null) {
			closeAllItem = new MenuItem(Resource.getString("tab.context.close_all"));
		}
		return closeAllItem;
	}

	public MenuItem getCloseOthersMenuItem() {
		if (closeOthersItem == null) {
			closeOthersItem = new MenuItem(Resource.getString("tab.context.close_others"));
		}
		return closeOthersItem;
	}

	public MenuItem getCloseMenuItem() {
		if (closeItem == null) {
			closeItem = new MenuItem(Resource.getString("tab.context.close"));
		}
		return closeItem;
	}

	@Override
	public ContextMenu getUI() {
		if (contextMenu == null) {
			contextMenu = new ContextMenu();
			contextMenu.getItems().addAll(getCloseMenuItem(), getCloseOthersMenuItem(), new SeparatorMenuItem(), getCloseAllMenuItem());
		}
		return contextMenu;
	}

}

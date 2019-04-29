package info.phosco.forms.viewer.tabbed.detail;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public interface DetailAreaTabContextMenu {

	ContextMenu getUI();

	MenuItem getCloseAllMenuItem();

	MenuItem getCloseOthersMenuItem();

	MenuItem getCloseMenuItem();
}

package info.phosco.forms.viewer.tabbed.detail;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;

public class SourceTab implements DetailAreaTab {

	private Tab tab;

	private DetailAreaTabContextMenu contextMenu;

	@Override
	public Tab getUI() {
		if (tab == null) {
			tab = TabFactory.newInstance();
			tab.setContextMenu(getContextMenu().getUI());
		}
		return tab;
	}

	@Override
	public DetailAreaTabContextMenu getContextMenu() {
		if (contextMenu == null) {
			contextMenu = new DetailAreaTabContextMenuImpl();
		}
		return contextMenu;
	}

	@Override
	public void setText(String text) {
		getUI().setText(text);
	}

	@Override
	public void setTooltip(Tooltip tip) {
		getUI().setTooltip(tip);
	}

	@Override
	public void setOnClosed(EventHandler<Event> handler) {
		getUI().setOnClosed(handler);
	}

	@Override
	public void setGraphic(Node node) {
		getUI().setGraphic(node);
	}

}

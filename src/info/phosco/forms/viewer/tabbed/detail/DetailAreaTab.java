package info.phosco.forms.viewer.tabbed.detail;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;

public interface DetailAreaTab {

	Tab getUI();

	DetailAreaTabContextMenu getContextMenu();

	void setText(String text);

	void setTooltip(Tooltip tip);

	void setGraphic(Node node);

	void setOnClosed(EventHandler<Event> handler);
}

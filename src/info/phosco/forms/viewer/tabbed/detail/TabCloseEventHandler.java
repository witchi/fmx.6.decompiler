package info.phosco.forms.viewer.tabbed.detail;

import javafx.event.Event;
import javafx.event.EventHandler;

public class TabCloseEventHandler implements EventHandler<Event> {

	private final DetailAreaController control;

	private final DetailAreaTabContent content;

	public TabCloseEventHandler(DetailAreaController control, DetailAreaTabContent content) {
		this.control = control;
		this.content = content;
	}

	@Override
	public void handle(Event event) {
		control.closeTab(content);
	}
}

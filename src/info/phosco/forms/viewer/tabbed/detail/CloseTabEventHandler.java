package info.phosco.forms.viewer.tabbed.detail;

import info.phosco.forms.translate.util.Log;

import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CloseTabEventHandler implements EventHandler<ActionEvent> {

	private final static Logger log = Log.getLogger(CloseTabEventHandler.class);

	private final DetailAreaController control;

	private final DetailAreaTabContent content;

	public CloseTabEventHandler(DetailAreaController control, DetailAreaTabContent content) {
		this.control = control;
		this.content = content;
		log.fine("Constructor CloseTabEventHandler");
	}

	@Override
	public void handle(ActionEvent e) {
		control.closeTab(content);
	}

}

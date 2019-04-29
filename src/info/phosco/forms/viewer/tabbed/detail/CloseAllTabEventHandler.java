package info.phosco.forms.viewer.tabbed.detail;

import info.phosco.forms.translate.util.Log;

import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CloseAllTabEventHandler implements EventHandler<ActionEvent> {

	private final static Logger log = Log.getLogger(CloseAllTabEventHandler.class);

	private final DetailAreaController control;

	public CloseAllTabEventHandler(DetailAreaController control) {
		this.control = control;
		log.fine("Constructor CloseTabEventHandler");
	}

	@Override
	public void handle(ActionEvent e) {
		control.closeAllTabs();
	}

}

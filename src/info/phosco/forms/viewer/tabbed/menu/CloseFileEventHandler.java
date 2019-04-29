package info.phosco.forms.viewer.tabbed.menu;

import info.phosco.forms.translate.util.Log;
import info.phosco.forms.viewer.tabbed.model.ApplicationModel;

import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CloseFileEventHandler implements EventHandler<ActionEvent> {

	private final static Logger log = Log.getLogger(CloseFileEventHandler.class);

	private final ApplicationModel model;

	private final ApplicationMenuBar view;

	public CloseFileEventHandler(ApplicationModel model, ApplicationMenuBar view) {
		this.model = model;
		this.view = view;
		log.fine("Constructor CloseFileEventHandler");
	}

	@Override
	public void handle(ActionEvent t) {
		log.fine("handle CloseFile event");
		model.closeFile(model.getSelectedTreeNode());
	}

}

package info.phosco.forms.viewer.tabbed.menu;

import info.phosco.forms.translate.util.Log;
import info.phosco.forms.viewer.tabbed.util.AbstractExitEventHandler;

import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AboutEventHandler extends AbstractExitEventHandler implements EventHandler<ActionEvent> {

	private final static Logger log = Log.getLogger(AboutEventHandler.class);

	private final ApplicationMenuBar view;

	public AboutEventHandler(ApplicationMenuBar view) {
		this.view = view;
	}

	@Override
	public void handle(ActionEvent t) {
		log.fine("handle About event");
		view.getAboutDialog().showAndWait();
	}

}

package info.phosco.forms.viewer.tabbed.desktop;

import info.phosco.forms.translate.util.Log;
import info.phosco.forms.viewer.tabbed.util.AbstractExitEventHandler;

import java.util.logging.Logger;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class ExitWindowEventHandler extends AbstractExitEventHandler implements EventHandler<WindowEvent> {

	private final static Logger log = Log.getLogger(ExitWindowEventHandler.class);

	@Override
	public void handle(WindowEvent event) {
		log.fine("handle exit window request");
		handleExitRequest();
	}

}

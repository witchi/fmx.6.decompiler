package info.phosco.forms.viewer.tabbed.util;

public abstract class AbstractExitEventHandler {

	protected void handleExitRequest() {
		// TODO: security check
		System.exit(0);
	}

}

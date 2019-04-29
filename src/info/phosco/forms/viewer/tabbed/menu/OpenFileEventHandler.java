package info.phosco.forms.viewer.tabbed.menu;

import info.phosco.forms.translate.util.FormsVersionException;
import info.phosco.forms.translate.util.Log;
import info.phosco.forms.translate.util.MagicNumberException;
import info.phosco.forms.viewer.tabbed.model.ApplicationModel;
import info.phosco.forms.viewer.tabbed.util.StageManager;

import java.io.File;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

public class OpenFileEventHandler implements EventHandler<ActionEvent> {

	private final static Logger log = Log.getLogger(OpenFileEventHandler.class);
	
	private final ApplicationModel model;

	private final ApplicationMenuBar view;

	public OpenFileEventHandler(ApplicationModel model, ApplicationMenuBar view) {
		this.model = model;
		this.view = view;
		log.fine("Constructor OpenFileEventHandler");
	}

	@Override
	public void handle(ActionEvent t) {
		log.fine("handle OpenFile event");
		
		FileChooser fc = view.getFileChooser();
		fc.setInitialDirectory(model.getLastDir());
		
		File file = fc.showOpenDialog(StageManager.getInstance().getPrimaryStage());
		if (file != null) {
			try {
				model.openFile(file);
			} catch (Exception e) {
				handleException(e);
			}
		}
	}

	private void handleException(Exception e) {
		if (e instanceof MagicNumberException) {
			view.getMagicNumberAlert().showAndWait();
			model.clearStatus();
			return;
		}

		if (e instanceof FormsVersionException) {
			view.getFormsVersionAlert().showAndWait();
			model.clearStatus();
			return;
		}

		view.getExceptionAlert(e).showAndWait();
		model.clearStatus();
	}

}

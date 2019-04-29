package info.phosco.forms.viewer.tabbed;

import info.phosco.forms.translate.util.Log;
import info.phosco.forms.translate.util.LogHandler;
import info.phosco.forms.viewer.tabbed.desktop.ApplicationController;
import info.phosco.forms.viewer.tabbed.desktop.ApplicationDesktop;
import info.phosco.forms.viewer.tabbed.model.ApplicationModel;
import info.phosco.forms.viewer.tabbed.util.StageManager;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.stage.Stage;

public class Desktop extends Application {
	private final static Logger log = Log.getLogger(Desktop.class);

	@Override
	public void start(Stage primaryStage) {
				
		log.fine("start application");

		StageManager.getInstance().setPrimaryStage(primaryStage);
		setUserAgentStylesheet(STYLESHEET_MODENA);
		
		ApplicationModel model = new ApplicationModel();
		ApplicationDesktop desktop = new ApplicationDesktop();
		ApplicationController control = new ApplicationController(model, desktop);
		control.showView();
	}

	public static void main(String[] args) {
		System.out.println("Forms-Decompiler Viewer v0.1");
		System.out.println("André Rothe <arothe@phosco.info>\n");
		
		LogHandler.init(Level.FINE);
		launch(args);
	}
}

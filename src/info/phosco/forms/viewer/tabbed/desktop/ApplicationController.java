package info.phosco.forms.viewer.tabbed.desktop;

import info.phosco.forms.translate.util.Log;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeController;
import info.phosco.forms.viewer.tabbed.detail.DetailAreaController;
import info.phosco.forms.viewer.tabbed.menu.ApplicationMenuController;
import info.phosco.forms.viewer.tabbed.model.ApplicationModel;
import info.phosco.forms.viewer.tabbed.util.StageManager;

import java.util.logging.Logger;

public class ApplicationController {

	private final static Logger log = Log.getLogger(ApplicationController.class);

	private final ApplicationModel model;

	private final ApplicationDesktop view;

	private final ApplicationMenuController menuController;

	private final BrowserTreeController treeController;

	private final DetailAreaController detailController;

	public ApplicationController(ApplicationModel model, ApplicationDesktop view) {
		this.view = view;
		this.model = model;

		log.fine("Constructor ApplicationController");
		
		detailController = new DetailAreaController(model, view.getDetailPane());
		treeController = new BrowserTreeController(model, view.getTreeView(), detailController);
		menuController = new ApplicationMenuController(model, view.getMenuBar(), treeController, detailController);

		view.getStatusBar().textProperty().bind(model.statusProperty());
		StageManager.getInstance().getPrimaryStage().setOnCloseRequest(new ExitWindowEventHandler());
		
		view.getScene().getStylesheets().add(Resource.getCSS("treeview.css"));
		view.getScene().getStylesheets().add(Resource.getCSS("tableview.css"));
	}

	public void showView() {
		view.show(StageManager.getInstance().getPrimaryStage());
	}

}

package info.phosco.forms.viewer.tabbed.menu;

import info.phosco.forms.translate.util.Log;
import info.phosco.forms.viewer.tabbed.detail.DetailAreaController;
import info.phosco.forms.viewer.tabbed.model.ApplicationModel;

import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PropertyViewerEventHandler implements EventHandler<ActionEvent> {

	private final static Logger log = Log.getLogger(PropertyViewerEventHandler.class);

	private final ApplicationModel model;

	private final DetailAreaController detailControl;

	public PropertyViewerEventHandler(ApplicationModel model, DetailAreaController detailControl) {
		this.model = model;
		this.detailControl = detailControl;
		log.fine("Constructor PropertyViewerEventHandler");
	}

	@Override
	public void handle(ActionEvent t) {
		log.fine("handle PropertyViewer event");
		detailControl.openAttributeTab(model.getSelectedTreeNode());
	}
}

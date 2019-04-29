package info.phosco.forms.viewer.tabbed.browser;

import info.phosco.forms.viewer.tabbed.detail.DetailAreaController;
import info.phosco.forms.viewer.tabbed.model.ApplicationModel;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

public class TreeViewMouseEventHandler {

	private final ApplicationModel model;

	private final BrowserTree source;

	private final DetailAreaController control;

	public TreeViewMouseEventHandler(ApplicationModel model, BrowserTree source, DetailAreaController control) {
		this.model = model;
		this.source = source;
		this.control = control;
	}

	private boolean isMouseEventOnGraphic(Node icon, Point2D coords) {
		if (icon == null) {
			return false;
		}
		return icon.localToScene(icon.getBoundsInLocal()).contains(coords);
	}

	public void handle(MouseEvent mouseEvent, TreeCell<BrowserTreeNode> cell) {

		if (!(mouseEvent.getSource() instanceof TreeView)) {
			return;
		}

		TreeItem<BrowserTreeNode> item = source.getSelectedItem();
		if (isMouseEventOnGraphic(cell.getGraphic(), new Point2D(mouseEvent.getSceneX(), mouseEvent.getSceneY()))) {

			if (item.getValue().hasLayout()) {
				control.openLayoutTab(item.getValue());
				return;
			}

			if (item.getValue().hasSourcecode()) {
				control.openSourceTab(item.getValue());
				return;
			}
			
		}
		
		if (item.getValue().hasAttributes()) {
			control.openAttributeTab(item.getValue());
			return;
		}
	}
}

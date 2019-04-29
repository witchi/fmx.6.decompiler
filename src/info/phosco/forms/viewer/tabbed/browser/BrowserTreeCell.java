package info.phosco.forms.viewer.tabbed.browser;

import info.phosco.forms.viewer.tabbed.model.NodeType;
import javafx.css.PseudoClass;
import javafx.event.EventDispatcher;
import javafx.scene.control.TreeCell;

public class BrowserTreeCell extends TreeCell<BrowserTreeNode> {

	private final PseudoClass folder = PseudoClass.getPseudoClass("browser-folder");

	private final PseudoClass childless = PseudoClass.getPseudoClass("browser-folder-childless");

	private final TreeViewMouseEventHandler mouseHandler;

	public BrowserTreeCell(TreeViewMouseEventHandler mouseHandler) {
		this.mouseHandler = mouseHandler;
	}

	@Override
	protected void updateItem(BrowserTreeNode item, boolean empty) {
		super.updateItem(item, empty);

		if (!empty && item != null) {

			setText(item.getName());
			setGraphic(item.getThumbnail());
			setTooltip(item.getTooltip());

			EventDispatcher originalDispatcher = getEventDispatcher();
			setEventDispatcher(new TreeViewEventDispatcher(originalDispatcher, this, mouseHandler));

		} else {

			setText("");
			setGraphic(null);
			setTooltip(null);
		}

		pseudoClassStateChanged(childless, !empty && item != null && item.getTypes().contains(NodeType.FOLDER) && item.getChildren().size() == 0);
		pseudoClassStateChanged(folder, !empty && item != null && item.getTypes().contains(NodeType.FOLDER));

	}

}

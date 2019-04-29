package info.phosco.forms.viewer.tabbed.browser;

import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.scene.control.TreeCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class TreeViewEventDispatcher implements EventDispatcher {

	private final EventDispatcher originalDispatcher;

	private final TreeViewMouseEventHandler handler;

	private final TreeCell<BrowserTreeNode> cell;

	public TreeViewEventDispatcher(EventDispatcher originalDispatcher, TreeCell<BrowserTreeNode> cell, TreeViewMouseEventHandler handler) {
		this.originalDispatcher = originalDispatcher;
		this.handler = handler;
		this.cell = cell;
	}

	@Override
	public Event dispatchEvent(Event event, EventDispatchChain tail) {
		if (event instanceof MouseEvent) {
			MouseEvent me = (MouseEvent) event;

			if (me.getButton() == MouseButton.PRIMARY && (me.getClickCount() >= 2)) {
				if (!me.isConsumed()) {
					handler.handle(me, cell);
				}
				me.consume();
			}
		}
		return originalDispatcher.dispatchEvent(event, tail);
	}
}

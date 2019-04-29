package info.phosco.forms.viewer.mdi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jfxtras.scene.control.window.Window;

public class WindowEventHandler implements EventHandler<ActionEvent> {

	private final WindowList list;
	private final Window window;
	
	public WindowEventHandler(WindowList list, Window w) {
		this.list = list;
		this.window = w;
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.list.remove(this.window);
	}

}

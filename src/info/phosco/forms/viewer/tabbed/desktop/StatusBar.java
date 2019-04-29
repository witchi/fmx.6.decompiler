package info.phosco.forms.viewer.tabbed.desktop;

import javafx.beans.property.StringProperty;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class StatusBar extends HBox {

	private final Text line;

	public StatusBar() {
		this.line = new Text();
		getChildren().add(this.line);
	}

	public StringProperty textProperty() {
		return line.textProperty();
	}

}

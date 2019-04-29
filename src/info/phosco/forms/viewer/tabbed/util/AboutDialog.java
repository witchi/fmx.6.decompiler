package info.phosco.forms.viewer.tabbed.util;

import info.phosco.forms.viewer.resource.Resource;
import javafx.beans.NamedArg;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class AboutDialog extends Alert implements ChangeListener<Boolean> {

	private TextArea productTextArea;

	private GridPane expContent;

	public AboutDialog(@NamedArg("alertType")
	AlertType alertType) {
		super(alertType);

		getDialogPane().setExpandableContent(getExpandable());
		getDialogPane().expandedProperty().addListener(this);

		Stage stage = (Stage) getDialogPane().getScene().getWindow();
		stage.getIcons().add(Resource.getImage("app.png").getImage());
	}

	public void setProducts(String productlist) {
		getProductTextArea().setText(productlist);
	}

	private TextArea getProductTextArea() {
		if (productTextArea == null) {
			productTextArea = new TextArea();
			productTextArea.setEditable(false);
			productTextArea.setWrapText(false);
			productTextArea.setMaxWidth(Double.MAX_VALUE);
			productTextArea.setMaxHeight(Double.MAX_VALUE);
		}
		return productTextArea;
	}

	private GridPane getExpandable() {
		if (expContent == null) {
			Label label = new Label(Resource.getString("viewer.about.dialog.using.title"));
			
			expContent = new GridPane();
			expContent.setMaxWidth(Double.MAX_VALUE);
			expContent.add(label, 0, 0);
			expContent.add(getProductTextArea(), 0, 1);
			
			GridPane.setVgrow(getProductTextArea(), Priority.ALWAYS);
			GridPane.setHgrow(getProductTextArea(), Priority.ALWAYS);
		}
		return expContent;
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		if (!newValue) {
			setWidth(getExpandable().getWidth());
			setHeight(getExpandable().getHeight());
		} else {
			setWidth(getDialogPane().getWidth());
			setHeight(getDialogPane().getHeight());
		}
	}

}

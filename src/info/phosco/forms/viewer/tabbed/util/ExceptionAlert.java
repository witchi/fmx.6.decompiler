package info.phosco.forms.viewer.tabbed.util;

import info.phosco.forms.viewer.resource.Resource;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.beans.NamedArg;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class ExceptionAlert extends Alert implements ChangeListener<Boolean> {

	private TextArea stackTraceTextArea;

	private GridPane expContent;

	public ExceptionAlert(@NamedArg("alertType") AlertType alertType) {
		super(alertType);

		getDialogPane().setExpandableContent(getExpandable());
		getDialogPane().expandedProperty().addListener(this);
		
		Stage stage = (Stage) getDialogPane().getScene().getWindow();
		stage.getIcons().add(Resource.getImage("app.png").getImage());
	}

	private GridPane getExpandable() {
		if (expContent == null) {
			Label label = new Label(Resource.getString("viewer.exception.dialog.stacktrace"));
			
			expContent = new GridPane();
			expContent.setMaxWidth(Double.MAX_VALUE);
			expContent.add(label, 0, 0);
			expContent.add(getStackTraceTextArea(), 0, 1);
			
			GridPane.setVgrow(getStackTraceTextArea(), Priority.ALWAYS);
			GridPane.setHgrow(getStackTraceTextArea(), Priority.ALWAYS);
		}
		return expContent;
	}

	private TextArea getStackTraceTextArea() {
		if (stackTraceTextArea == null) {
			stackTraceTextArea = new TextArea();
			stackTraceTextArea.setEditable(false);
			stackTraceTextArea.setWrapText(false);
			stackTraceTextArea.setMaxWidth(Double.MAX_VALUE);
			stackTraceTextArea.setMaxHeight(Double.MAX_VALUE);
		}
		return stackTraceTextArea;
	}

	public void setException(Exception e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		getStackTraceTextArea().setText(sw.toString());
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

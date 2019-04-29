package info.phosco.forms.viewer.mdi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jfxtras.scene.control.window.Window;

public class Desktop extends Application {

	@Override
	public void start(Stage primaryStage) {

		// create the canvas where the windows will be added to
		Pane canvas = new Pane();

		// create a scrollpane
		ScrollPane scrollPane = new ScrollPane();

		// define the scrollpane content
		scrollPane.setContent(canvas);

		// create a scene that displays the scrollpane (resolution 1200, 1200)
		Scene scene = new Scene(scrollPane, 800, 800);

		Window w = WindowFactory.newInstance("Sample 0x1", 10, 10);
		canvas.getChildren().add(w);

		w = WindowFactory.newInstance("Sample 0x2", 20, 20);
		canvas.getChildren().add(w);

		w = WindowFactory.newInstance("Sample 0x3", 30, 30);
		canvas.getChildren().add(w);

		// init and show the stage
		primaryStage.setTitle("FMX.Viewer Test");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package info.phosco.forms.viewer.tabbed.desktop;

import info.phosco.forms.translate.util.Log;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTree;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeImpl;
import info.phosco.forms.viewer.tabbed.detail.DetailArea;
import info.phosco.forms.viewer.tabbed.detail.DetailAreaImpl;
import info.phosco.forms.viewer.tabbed.menu.ApplicationMenuBar;
import info.phosco.forms.viewer.tabbed.menu.ApplicationMenuBarImpl;

import java.util.logging.Logger;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ApplicationDesktop {

	private final static Logger log = Log.getLogger(ApplicationDesktop.class);

	private BrowserTree treeView;

	private SplitPane splitPane;

	private DetailArea detailPane;

	private Scene scene;

	private ApplicationMenuBar menuBar;

	private BorderPane borderPane;

	private StatusBar statusBar;

	public ApplicationDesktop() {
		log.fine("Constructor ApplicationDesktop");
	}

	public BrowserTree getTreeView() {
		if (treeView == null) {
			treeView = new BrowserTreeImpl();
		}
		return treeView;
	}

	private SplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new SplitPane();
			splitPane.setDividerPositions(0.2f);
			
			VBox vbox = new VBox();
			vbox.setPadding(new Insets(10));
			vbox.getChildren().add(getTreeView().getUI());
			VBox.setVgrow(getTreeView().getUI(), Priority.ALWAYS);
			
			splitPane.getItems().addAll(vbox, getDetailPane().getUI());
		}
		return splitPane;
	}

	private BorderPane getBorderPane() {
		if (borderPane == null) {
			borderPane = new BorderPane();

			VBox menuBox = new VBox();
			menuBox.getChildren().add(getMenuBar().getBar());

			VBox statusBox = new VBox();
			statusBox.getChildren().add(getStatusBar());

			borderPane.setTop(menuBox);
			borderPane.setCenter(getSplitPane());
			borderPane.setBottom(statusBox);

			getSplitPane().prefWidthProperty().bind(borderPane.widthProperty());
			getSplitPane().prefHeightProperty().bind(borderPane.heightProperty());
		}
		return borderPane;
	}

	public ApplicationMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new ApplicationMenuBarImpl();
		}
		return menuBar;
	}

	public Scene getScene() {
		if (scene == null) {
			scene = new Scene(getBorderPane(), 1024, 768);
		}
		return scene;
	}

	public StatusBar getStatusBar() {
		if (statusBar == null) {
			statusBar = new StatusBar();
		}
		return statusBar;
	}

	public void show(Stage stage) {
		stage.setTitle(Resource.getString("viewer.title"));
		stage.setScene(getScene());
		stage.getIcons().add(Resource.getImage("app.png").getImage());
		stage.show();
	}

	public DetailArea getDetailPane() {
		if (detailPane == null) {
			detailPane = new DetailAreaImpl();
		}
		return detailPane;
	}

}

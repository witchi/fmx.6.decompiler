package info.phosco.forms.viewer.tabbed.menu;

import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.util.AboutDialog;
import info.phosco.forms.viewer.tabbed.util.ExceptionAlert;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ApplicationMenuBarImpl implements ApplicationMenuBar {

	private MenuBar menuBar;

	private MenuItem itemExit;

	private MenuItem itemOpen;

	private MenuItem itemClose;
	
	private MenuItem itemLayout;

	private MenuItem itemProperty;

	private MenuItem itemAbout;

	private Menu menuFile;

	private Menu menuTools;

	private Menu menuHelp;

	private FileChooser fileChooser;

	@Override
	public MenuItem getLayoutViewerMenuItem() {
		if (itemLayout == null) {
			itemLayout = new MenuItem(Resource.getString("viewer.tools.layout.title"));
			itemLayout.setAccelerator(KeyCombination.keyCombination(Resource
					.getString("viewer.tools.layout.accelerator")));
			itemLayout.setDisable(true);
		}
		return itemLayout;
	}

	@Override
	public MenuItem getPropertyViewerMenuItem() {
		if (itemProperty == null) {
			itemProperty = new MenuItem(Resource.getString("viewer.tools.property.title"));
			itemProperty.setAccelerator(KeyCombination.keyCombination(Resource
					.getString("viewer.tools.property.accelerator")));
			itemProperty.setDisable(true);
		}
		return itemProperty;
	}

	@Override
	public MenuItem getExitMenuItem() {
		if (itemExit == null) {
			itemExit = new MenuItem(Resource.getString("viewer.file.exit.title"));
			itemExit.setAccelerator(KeyCombination.keyCombination(Resource.getString("viewer.file.exit.accelerator")));
		}
		return itemExit;
	}

	@Override
	public MenuItem getAboutMenuItem() {
		if (itemAbout == null) {
			itemAbout = new MenuItem(Resource.getString("viewer.help.about.title"));
		}
		return itemAbout;
	}

	@Override
	public MenuItem getOpenFileMenuItem() {
		if (itemOpen == null) {
			itemOpen = new MenuItem(Resource.getString("viewer.file.open.title"));
			itemOpen.setAccelerator(KeyCombination.keyCombination(Resource.getString("viewer.file.open.accelerator")));
		}
		return itemOpen;
	}

	@Override
	public MenuItem getCloseFileMenuItem() {
		if (itemClose == null) {
			itemClose = new MenuItem(Resource.getString("viewer.file.close.title"));
			itemClose.setAccelerator(KeyCombination.keyCombination(Resource.getString("viewer.file.close.accelerator")));
		}
		return itemClose;
	}

	public MenuBar getBar() {
		if (menuBar == null) {
			menuBar = new MenuBar();
			menuBar.getMenus().addAll(getFileMenu(), getToolsMenu(), getHelpMenu());
		}
		return menuBar;
	}

	@Override
	public FileChooser getFileChooser() {
		if (fileChooser == null) {
			fileChooser = new FileChooser();
			fileChooser.setTitle(Resource.getString("viewer.filechooser.title"));
			fileChooser.getExtensionFilters().add(
					new FileChooser.ExtensionFilter(Resource.getString("viewer.filechooser.filter.fmx"), "*.fmx"));
		}
		return fileChooser;
	}

	@Override
	public Alert getMagicNumberAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(Resource.getString("viewer.error.dialog.title"));
		alert.setHeaderText(null);
		alert.setContentText(Resource.getString("viewer.error.magic_number"));
		alert.initStyle(StageStyle.UTILITY);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(Resource.getImage("app.png").getImage());
		return alert;
	}

	@Override
	public Alert getFormsVersionAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(Resource.getString("viewer.error.dialog.title"));
		alert.setHeaderText(null);
		alert.setContentText(Resource.getString("viewer.error.forms_version"));
		alert.initStyle(StageStyle.UTILITY);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(Resource.getImage("app.png").getImage());
		return alert;
	}

	public ExceptionAlert getExceptionAlert(Exception e) {
		ExceptionAlert alert = new ExceptionAlert(AlertType.ERROR);
		alert.setTitle(Resource.getString("viewer.exception.dialog.title"));
		alert.setHeaderText(null);
		alert.setContentText(e.getMessage() == null ? e.getClass().getName() : e.getLocalizedMessage());
		alert.setException(e);
		alert.initStyle(StageStyle.UTILITY);
		return alert;
	}

	@Override
	public Alert getAboutDialog() {
		AboutDialog alert = new AboutDialog(AlertType.INFORMATION);
		alert.setTitle(Resource.getString("viewer.about.dialog.title"));
		alert.setHeaderText(null);
		alert.setContentText(Resource.getString("viewer.about.dialog"));
		alert.setProducts(Resource.getString("viewer.about.dialog.using"));
		alert.initStyle(StageStyle.UTILITY);
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(Resource.getImage("app.png").getImage());
		return alert;
	}

	private Menu getFileMenu() {
		if (menuFile == null) {
			menuFile = new Menu(Resource.getString("viewer.file.title"));
			menuFile.getItems().addAll(getOpenFileMenuItem(), getCloseFileMenuItem(), new SeparatorMenuItem(), getExitMenuItem());
		}
		return menuFile;
	}

	private Menu getToolsMenu() {
		if (menuTools == null) {
			menuTools = new Menu(Resource.getString("viewer.tools.title"));
			menuTools.getItems().addAll(getLayoutViewerMenuItem(), getPropertyViewerMenuItem());
		}
		return menuTools;
	}

	private Menu getHelpMenu() {
		if (menuHelp == null) {
			menuHelp = new Menu(Resource.getString("viewer.help.title"));
			menuHelp.getItems().addAll(getAboutMenuItem());
		}
		return menuHelp;
	}

}

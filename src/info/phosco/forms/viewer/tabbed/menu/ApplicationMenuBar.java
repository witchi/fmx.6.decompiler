package info.phosco.forms.viewer.tabbed.menu;

import info.phosco.forms.viewer.tabbed.util.ExceptionAlert;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

public interface ApplicationMenuBar {

	MenuBar getBar();

	MenuItem getOpenFileMenuItem();

	MenuItem getExitMenuItem();

	MenuItem getLayoutViewerMenuItem();

	MenuItem getPropertyViewerMenuItem();
	
	MenuItem getAboutMenuItem();

	FileChooser getFileChooser();

	Alert getMagicNumberAlert();

	Alert getFormsVersionAlert();
	
	Alert getAboutDialog();

	ExceptionAlert getExceptionAlert(Exception e);

	MenuItem getCloseFileMenuItem();
}

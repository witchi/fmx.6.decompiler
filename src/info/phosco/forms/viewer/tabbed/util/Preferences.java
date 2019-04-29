package info.phosco.forms.viewer.tabbed.util;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class Preferences {

	
	private Preferences() {
	}
	
	public static double getScreenX() {
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		return primaryScreenBounds.getMinX();
	}
	
	public static double getScreenY() {
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		return primaryScreenBounds.getMinY();
	}
	
	public static double getScreenWidth() {
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		return primaryScreenBounds.getWidth();
	}
	
	public static double getScreenHeight() {
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		return primaryScreenBounds.getHeight();
	}
	
	public static String getUserHomeDir() {
		return System.getProperty("user.home");
	}
}

package info.phosco.forms.viewer.resource;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Resource {

	private static final ResourceBundle rs = ResourceBundle.getBundle("info.phosco.forms.viewer.resource.viewer");

	public static String getString(String key) {
		String res;
		try {
			res = rs.getString(key);
		} catch (MissingResourceException e) {
			res = "unknown key " + key;
		}
		return res;
	}

	public static String getCSS(String cssName) {
		String p = Resource.class.getPackage().getName().replace(".", "/");
		return Resource.class.getResource("/" + p + "/" + cssName).toExternalForm();
	}

	public static ImageView getImage(String image) {
		return new ImageView(new Image(getCSS(image)));
	}
}

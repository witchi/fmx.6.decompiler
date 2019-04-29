package info.phosco.forms.viewer.tabbed.model.browser;

import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.viewer.resource.Resource;
import javafx.scene.image.ImageView;

public class ThumbnailFactory {
	
	private ThumbnailFactory() {
	}

	public static ImageView get(ElementType type) {

		switch (type) {
		case TRIGGER:
			return Resource.getImage("trigger.png");

		case ALERT:
			return Resource.getImage("alert.png");

		case LIBRARY:
			return Resource.getImage("library.png");

		case ARC:
			break;

		case CANVAS:
			return Resource.getImage("canvas.png");

		case DATA_BLOCK:
			return Resource.getImage("datablock.png");

		case EDITOR:
			return Resource.getImage("editor.png");

		case FRAME:
			break;

		case LINE:
			return Resource.getImage("line.png");

		case MODULE:
			return Resource.getImage("form.png");

		case PARAMETER:
			return Resource.getImage("parameter.png");

		case PROGRAM_UNIT:
			return Resource.getImage("program-unit.png");

		case RECORD_GROUP:
			return Resource.getImage("record.png");

		case RECTANGLE:
			return Resource.getImage("rectangle.png");

		case TEXT:
			return Resource.getImage("text.png");

		case IMAGE:
			return Resource.getImage("image.png");

		case VISUAL_GROUP:
			return Resource.getImage("visual.png");

		case WINDOW:
			return Resource.getImage("window.png");

		case GROUP:
			return Resource.getImage("group.png");

		default:
			break;
		}
		return null;
	}

}

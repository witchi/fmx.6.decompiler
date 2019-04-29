package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.FormElement;
import info.phosco.forms.translate.element.alert.FormAlert;
import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.canvas.FormCanvas;
import info.phosco.forms.translate.element.canvas.graphic.FormGroup;
import info.phosco.forms.translate.element.canvas.graphic.FormImage;
import info.phosco.forms.translate.element.canvas.graphic.FormLine;
import info.phosco.forms.translate.element.canvas.graphic.FormRectangle;
import info.phosco.forms.translate.element.canvas.graphic.FormText;
import info.phosco.forms.translate.element.editor.FormEditor;
import info.phosco.forms.translate.element.library.FormLibrary;
import info.phosco.forms.translate.element.parameter.FormParameter;
import info.phosco.forms.translate.element.program.FormProgramUnit;
import info.phosco.forms.translate.element.recordgroup.FormRecordGroup;
import info.phosco.forms.translate.element.trigger.FormTrigger;
import info.phosco.forms.translate.element.visual.attribute.FormVisualGroup;
import info.phosco.forms.translate.element.window.FormWindow;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.model.CoordinateSystem;

import java.util.ArrayList;
import java.util.List;

public class AttributeListFactory {

	public static List<Attribute> getList(FormElement<?> elem, CoordinateSystem coords) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		if (elem == null) {
			return res;
		}

		switch (elem.getType()) {
		case TRIGGER:
			return TriggerAttributeListFactory.getList((FormTrigger) elem);

		case ALERT:
			return AlertAttributeListFactory.getList((FormAlert) elem);

		case LIBRARY:
			return LibraryAttributeListFactory.getList((FormLibrary) elem);

		case ARC:
			break;

		case CANVAS:
			return CanvasAttributeListFactory.getList((FormCanvas) elem);

		case DATA_BLOCK:
			break;

		case EDITOR:
			return EditorAttributeListFactory.getList((FormEditor) elem);

		case FRAME:
			break;

		case LINE:
			return LineAttributeListFactory.getList((FormLine) elem, coords);

		case MODULE:
			return FormAttributeListFactory.getList((FormModule) elem);

		case PARAMETER:
			return ParameterAttributeListFactory.getList((FormParameter) elem);

		case PROGRAM_UNIT:
			return ProgramUnitAttributeListFactory.getList((FormProgramUnit) elem);

		case RECORD_GROUP:
			return RecordGroupAttributeListFactory.getList((FormRecordGroup) elem);

		case RECORD_GROUP_COLUMN:
			break;

		case RECTANGLE:
			return RectangleAttributeListFactory.getList((FormRectangle) elem, coords);

		case TEXT:
			return TextAttributeListFactory.getList((FormText) elem, coords);

		case IMAGE:
			return ImageAttributeListFactory.getList((FormImage) elem, coords);

		case GROUP:
			return GroupAttributeListFactory.getList((FormGroup) elem);

		case VISUAL_GROUP:
			return VisualAttributeListFactory.getList((FormVisualGroup) elem);

		case WINDOW:
			return WindowAttributeListFactory.getList((FormWindow) elem);

		default:
			break;
		}

		return res;
	}

}

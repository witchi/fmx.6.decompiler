package info.phosco.forms.translate.element.application;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.bytes.FileStructureType;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.element.Direction;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.alert.AlertListFactory;
import info.phosco.forms.translate.element.canvas.CanvasListFactory;
import info.phosco.forms.translate.element.datablock.DataBlockListFactory;
import info.phosco.forms.translate.element.editor.EditorListFactory;
import info.phosco.forms.translate.element.font.FontListFactory;
import info.phosco.forms.translate.element.font.FormFont;
import info.phosco.forms.translate.element.library.LibraryListFactory;
import info.phosco.forms.translate.element.parameter.ParameterListFactory;
import info.phosco.forms.translate.element.program.ProgramUnitListFactory;
import info.phosco.forms.translate.element.recordgroup.RecordGroupListFactory;
import info.phosco.forms.translate.element.trigger.TriggerListFactory;
import info.phosco.forms.translate.element.trigger.UserNamedListFactory;
import info.phosco.forms.translate.element.visual.attribute.VisualGroupListFactory;
import info.phosco.forms.translate.element.window.WindowListFactory;
import info.phosco.forms.translate.util.ColumnDatatypeException;
import info.phosco.forms.translate.util.DateFormatException;
import info.phosco.forms.translate.util.FileStructureTypeException;
import info.phosco.forms.translate.util.FormElementTypeException;

import java.util.List;

public class FormModuleFactory extends AbstractFactory {

	private static final int POS_NAME = 0x0;

	private static final int POS_TITLE = 0x8;

	private static final int POS_MENU_MODULE = 0x10;

	private static final int POS_TRIGGER_LIST = 0x28;
	
	private static final int POS_TRIGGER_LIST_LEN = 0x2C;
	
	private static final int POS_PROGRAM_UNIT_LIST = 0x30;
	
	// TODO: 0x34 ?
	
	private static final int POS_DATABLOCK_LIST = 0x38;

	private static final int POS_WINDOW_LIST = 0x3c;

	private static final int POS_CANVAS_LIST = 0x40;

	private static final int POS_WARNING_LIST = 0x44;

	private static final int POS_EDITOR_LIST = 0x48;

	// TODO: 0x4c ?

	private static final int POS_PARAMETER_LIST = 0x50;

	// TODO: 0x54 ?	

	private static final int POS_DATABLOCK_LIST_LEN = 0x58;

	private static final int POS_WINDOW_LIST_LEN = 0x5C;

	private static final int POS_CANVAS_LIST_LEN = 0x60;

	private static final int POS_WARNING_LIST_LEN = 0x64;

	private static final int POS_EDITOR_LIST_LEN = 0x68;

	// TODO: 0x6C ?

	private static final int POS_PARAMETER_LIST_LEN = 0x70;

	// TODO: 0x74 ?

	private static final int POS_VALIDATION_UNIT = 0x7C;

	private static final int POS_MOUSE_NAVIGATION = 0x80;

	private static final int POS_VISUAL_GROUP_LIST = 0x84;

	private static final int POS_VISUAL_GROUP_LIST_LEN = 0x88;

	// TODO: 0x8C ?
	
	private static final int POS_USER_NAMED_LIST = 0x90;
	
	private static final int POS_USER_NAMED_LIST_LEN = 0x94;
	
	// TODO: 0x98 ?
	
	private static final int POS_FONT_LIST = 0x9c;

	private static final int POS_MENU_SOURCE = 0xAC;

	private static final int POS_LIBRARY_LIST = 0xB0;
	
	// TODO: 0xB4 ?

	private static final int POS_CHARACTERSET = 0xB8;

	private static final int POS_USE_3D_CONTROLS = 0xC8;

	private static final int POS_VISUAL_GROUP_RECORD = 0xCC;

	private static final int POS_COORD_SYSTEM = 0xD4;

	private static final int POS_COORD_SYSTEM_UNIT = 0xD8;

	private static final int POS_UNIT_WIDTH = 0xE0;

	private static final int POS_UNIT_HEIGHT = 0xE4;

	private static final int POS_RECORD_GROUP_LIST = 0xF4;

	private static final int POS_FONT_LIST_LEN = 0xFC;

	private static final int POS_DIRECTION = 0x108;

	private static final int POS_DEFER_REQUIRED = 0x120;

	private static final int POS_RUNTIME_COMPATIBILITY = 0x124;

	private static final int POS_ISOLATION_MODE = 0x140;

	private static final int POS_INTERACTION_MODE = 0x144;

	private static final int POS_MAX_QUERY_TIME = 0x148;

	private static final int POS_MAX_QUERIED_RECORDS = 0x14C;

	private FormModuleFactory() {
	}

	public static FormModule instance(Content content) throws FileStructureTypeException, ColumnDatatypeException, DateFormatException,
			FormElementTypeException {

		// starts always on AttributeStruct
		int offset = FileStructureType.ATTRIBUTES.id();
		FormModule res = new FormModule(offset);

		int ref = content.getInt(offset, POS_NAME);
		res.setProperty(ModuleAttributes.NAME, content.getString(ref, 0));

		ref = content.getInt(offset, POS_TITLE);
		if (ref != 0x0) {
			res.setProperty(ModuleAttributes.TITLE, content.getString(ref, 0));
		}

		ref = content.getInt(offset, POS_MENU_MODULE);
		res.setProperty(ModuleAttributes.MENU_MODULE, content.getString(ref, 0));

		ref = content.getInt(offset, POS_DATABLOCK_LIST);
		int len = content.getInt(offset, POS_DATABLOCK_LIST_LEN);
		res.setProperty(ModuleAttributes.DATABLOCK_LIST, DataBlockListFactory.get(content, ref, len));

		ref = content.getInt(offset, POS_WINDOW_LIST);
		len = content.getInt(offset, POS_WINDOW_LIST_LEN);
		res.setProperty(ModuleAttributes.WINDOW_LIST, WindowListFactory.get(content, ref, len));

		ref = content.getInt(offset, POS_FONT_LIST);
		len = content.getInt(offset, POS_FONT_LIST_LEN);
		ElementList<FormFont> fontList = FontListFactory.get(content, ref, len);
		res.setProperty(ModuleAttributes.FONT_LIST, fontList);

		ref = content.getInt(offset, POS_CANVAS_LIST);
		len = content.getInt(offset, POS_CANVAS_LIST_LEN);
		res.setProperty(ModuleAttributes.CANVAS_LIST, CanvasListFactory.get(content, ref, len, fontList));

		ref = content.getInt(offset, POS_EDITOR_LIST);
		len = content.getInt(offset, POS_EDITOR_LIST_LEN);
		res.setProperty(ModuleAttributes.EDITOR_LIST, EditorListFactory.get(content, ref, len));

		ref = content.getInt(offset, POS_PARAMETER_LIST);
		len = content.getInt(offset, POS_PARAMETER_LIST_LEN);
		res.setProperty(ModuleAttributes.PARAMETER_LIST, ParameterListFactory.get(content, ref, len));

		ref = content.getInt(offset, POS_WARNING_LIST);
		len = content.getInt(offset, POS_WARNING_LIST_LEN);
		res.setProperty(ModuleAttributes.WARNING_LIST, AlertListFactory.get(content, ref, len));

		ref = content.getInt(offset, POS_VISUAL_GROUP_LIST);
		len = content.getInt(offset, POS_VISUAL_GROUP_LIST_LEN);
		res.setProperty(ModuleAttributes.VISUAL_GROUP_LIST, VisualGroupListFactory.get(content, ref, len));

		res.setProperty(ModuleAttributes.VISUAL_GROUP_RECORD, content.getInt(offset, POS_VISUAL_GROUP_RECORD));

		ref = content.getInt(offset, POS_RECORD_GROUP_LIST);
		res.setProperty(ModuleAttributes.RECORD_GROUP_LIST, RecordGroupListFactory.get(content, ref));

		res.setProperty(ModuleAttributes.VALIDATION_UNIT, ValidationUnit.lookup(content.getInt(offset, POS_VALIDATION_UNIT)));

		res.setProperty(ModuleAttributes.MOUSE_NAVIGATION_LIMIT, MouseNavigation.lookup(content.getInt(offset, POS_MOUSE_NAVIGATION)));

		res.setProperty(ModuleAttributes.MENU_SOURCE, MenuSource.lookup(content.getShort(offset, POS_MENU_SOURCE)));

		res.setProperty(ModuleAttributes.CHARACTERSET, content.getString(content.getInt(offset, POS_CHARACTERSET), 0));
		res.setProperty(ModuleAttributes.USE_3D_CONTROLS, !bool(content.getShort(offset, POS_USE_3D_CONTROLS)));

		res.setProperty(ModuleAttributes.DIRECTION, Direction.lookup(content.getShort(offset, POS_DIRECTION)));

		res.setProperty(ModuleAttributes.DEFER_REQUIRED, DeferRequired.lookup(content.getShort(offset, POS_DEFER_REQUIRED)));
		res.setProperty(ModuleAttributes.ISOLATION_MODE, IsolationMode.lookup(content.getShort(offset, POS_ISOLATION_MODE)));
		res.setProperty(ModuleAttributes.INTERCATION_MODE, InteractionMode.lookup(content.getShort(offset, POS_INTERACTION_MODE)));

		res.setProperty(ModuleAttributes.RUNTIME_COMPATIBILITY, (float) content.getShort(offset, POS_RUNTIME_COMPATIBILITY) / 10);

		res.setProperty(ModuleAttributes.MAX_QUERY_TIME, content.getInt(offset, POS_MAX_QUERY_TIME));
		res.setProperty(ModuleAttributes.MAX_RECORDS_FETCHED, content.getInt(offset, POS_MAX_QUERIED_RECORDS));

		res.setProperty(ModuleAttributes.COORD_SYSTEM, CoordSystem.lookup(content.getInt(offset, POS_COORD_SYSTEM)));

		res.setProperty(ModuleAttributes.COORD_SYSTEM_UNIT, CoordSystemUnit.lookup(content.getInt(offset, POS_COORD_SYSTEM_UNIT)));

		res.setProperty(ModuleAttributes.UNIT_WIDTH, content.getInt(offset, POS_UNIT_WIDTH));
		res.setProperty(ModuleAttributes.UNIT_HEIGHT, content.getInt(offset, POS_UNIT_HEIGHT));

		ref = content.getInt(offset, POS_LIBRARY_LIST);
		res.setProperty(ModuleAttributes.LIBRARY_LIST, LibraryListFactory.get(content, ref));
		
		ref = content.getInt(offset, POS_USER_NAMED_LIST);
		len = content.getInt(offset, POS_USER_NAMED_LIST_LEN);
		List<String> userNames = UserNamedListFactory.get(content, ref, len);
		
		ref = content.getInt(offset, POS_TRIGGER_LIST);
		len = content.getInt(offset, POS_TRIGGER_LIST_LEN);
		res.setProperty(ModuleAttributes.TRIGGER_LIST, TriggerListFactory.get(content, ref, len, userNames));

		ref = content.getInt(offset, POS_PROGRAM_UNIT_LIST);
		res.setProperty(ModuleAttributes.PROGRAM_UNIT_LIST, ProgramUnitListFactory.get(content, ref));

		
		// TODO: read properties

		return res;
	}
}

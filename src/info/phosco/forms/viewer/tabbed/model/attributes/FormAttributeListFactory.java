package info.phosco.forms.viewer.tabbed.model.attributes;

import java.util.ArrayList;
import java.util.List;

import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.application.ModuleAttributes;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;

public class FormAttributeListFactory {

	public static List<Attribute> getList(FormModule form) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("form.general")));
		res.add(new Attribute(Resource.getString("form.general.name"), form.getName()));
		res.add(new Attribute(Resource.getString("form.general.offset"), "0x" + Integer.toHexString(form.getOffset())));
		res.add(new Attribute(Resource.getString("form.general.characterset"), form.getCharacterSet()));
		res.add(new Attribute(Resource.getString("form.general.help"), form.getProperty(ModuleAttributes.HELP)));

		res.add(new CaptionAttribute(Resource.getString("form.functional")));
		res.add(new Attribute(Resource.getString("form.functional.title"), form.getProperty(ModuleAttributes.TITLE)));
		res.add(new Attribute(Resource.getString("form.functional.window"), form.getProperty(ModuleAttributes.CONSOLE_WINDOW)));
		res.add(new Attribute(Resource.getString("form.functional.menu_source"), form.getProperty(ModuleAttributes.MENU_SOURCE)));
		res.add(new Attribute(Resource.getString("form.functional.menu_module"), form.getProperty(ModuleAttributes.MENU_MODULE)));
		res.add(new Attribute(Resource.getString("form.functional.initial_menu"), form.getProperty(ModuleAttributes.INITIAL_MENU)));
		res.add(new Attribute(Resource.getString("form.functional.defer"), form.getProperty(ModuleAttributes.DEFER_REQUIRED)));

		res.add(new CaptionAttribute(Resource.getString("form.menu")));
		res.add(new Attribute(Resource.getString("form.menu.role"), form.getProperty(ModuleAttributes.MENU_ROLE)));

		res.add(new CaptionAttribute(Resource.getString("form.navigation")));
		res.add(new Attribute(Resource.getString("form.navigation.limit"), form.getProperty(ModuleAttributes.MOUSE_NAVIGATION_LIMIT)));
		res.add(new Attribute(Resource.getString("form.navigation.first"), form.getProperty(ModuleAttributes.FIRST_DATA_BLOCK)));

		res.add(new CaptionAttribute(Resource.getString("form.records")));
		res.add(new Attribute(Resource.getString("form.records.visual"), form.getProperty(ModuleAttributes.RECORD_VISUAL_ATTRIBUTES)));

		res.add(new CaptionAttribute(Resource.getString("form.database")));
		res.add(new Attribute(Resource.getString("form.database.validation_unit"), form.getProperty(ModuleAttributes.VALIDATION_UNIT)));
		res.add(new Attribute(Resource.getString("form.database.interaction_mode"), form.getProperty(ModuleAttributes.INTERCATION_MODE)));
		res.add(new Attribute(Resource.getString("form.database.max_query_time"), form.getProperty(ModuleAttributes.MAX_QUERY_TIME)));
		res.add(new Attribute(Resource.getString("form.database.max_records_fetched"), form.getProperty(ModuleAttributes.MAX_RECORDS_FETCHED)));
		res.add(new Attribute(Resource.getString("form.database.isolation_mode"), form.getProperty(ModuleAttributes.ISOLATION_MODE)));

		res.add(new CaptionAttribute(Resource.getString("form.physical")));
		res.add(new Attribute(Resource.getString("form.physical.coordinate_system"), form.getProperty(ModuleAttributes.COORD_SYSTEM)));
		res.add(new Attribute(Resource.getString("form.physical.coordinate_system_unit"), form.getProperty(ModuleAttributes.COORD_SYSTEM_UNIT)));
		res.add(new Attribute(Resource.getString("form.physical.use_3d_controls"), form.getProperty(ModuleAttributes.USE_3D_CONTROLS)));
		res.add(new Attribute(Resource.getString("form.physical.horizontal_toolbar"), form.getProperty(ModuleAttributes.H_TOOLBAR)));
		res.add(new Attribute(Resource.getString("form.physical.vertical_toolbar"), form.getProperty(ModuleAttributes.V_TOOLBAR)));

		res.add(new CaptionAttribute(Resource.getString("form.international")));
		res.add(new Attribute(Resource.getString("form.international.direction"), form.getProperty(ModuleAttributes.DIRECTION)));

		res.add(new CaptionAttribute(Resource.getString("form.compatibility")));
		res.add(new Attribute(Resource.getString("form.compatibility.runtime"), form.getProperty(ModuleAttributes.RUNTIME_COMPATIBILITY)));

		return res;
	}
}

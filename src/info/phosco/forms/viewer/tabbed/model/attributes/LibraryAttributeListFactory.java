package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.library.FormLibrary;
import info.phosco.forms.translate.element.library.LibraryAttributes;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;

import java.util.ArrayList;
import java.util.List;

public class LibraryAttributeListFactory {

	public static List<Attribute> getList(FormLibrary library) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("library.general")));
		res.add(new Attribute(Resource.getString("library.general.name"), library.getName()));
		res.add(new Attribute(Resource.getString("library.general.offset"), "0x" + Integer.toHexString(library.getOffset())));

		res.add(new CaptionAttribute(Resource.getString("library.functional")));
		res.add(new Attribute(Resource.getString("library.functional.source"), library.getProperty(LibraryAttributes.SOURCE)));
		res.add(new Attribute(Resource.getString("library.functional.location"), library.getProperty(LibraryAttributes.LOCATION)));
		res.add(new Attribute(Resource.getString("library.functional.filter"), ".pll | .plx"));
		
		return res;
	}
}

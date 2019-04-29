package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.canvas.graphic.FormGroup;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;

import java.util.ArrayList;
import java.util.List;

public class GroupAttributeListFactory {

	public static List<Attribute> getList(FormGroup group) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("group.general")));
		res.add(new Attribute(Resource.getString("group.general.name"), group.getName()));
		res.add(new Attribute(Resource.getString("group.general.type"), group.getType()));
		res.add(new Attribute(Resource.getString("group.general.offset"), "0x" + Integer.toHexString(group.getOffset())));

		return res;
	}
}

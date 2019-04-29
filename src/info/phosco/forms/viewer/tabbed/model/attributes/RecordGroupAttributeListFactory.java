package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.recordgroup.FormRecordGroup;
import info.phosco.forms.translate.element.recordgroup.RecordGroupAttributes;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;

import java.util.ArrayList;
import java.util.List;

public class RecordGroupAttributeListFactory {

	public static List<Attribute> getList(FormRecordGroup record) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("recordgroup.general")));
		res.add(new Attribute(Resource.getString("recordgroup.general.name"), record.getName()));
		res.add(new Attribute(Resource.getString("recordgroup.general.offset"), "0x" + Integer.toHexString(record.getOffset())));

		res.add(new CaptionAttribute(Resource.getString("recordgroup.functional")));
		res.add(new Attribute(Resource.getString("recordgroup.functional.type"), record.getProperty(RecordGroupAttributes.RECORD_GROUP_TYPE)));
		if (record.isQuery()) {
			res.add(new Attribute(Resource.getString("recordgroup.functional.query"), record.getProperty(RecordGroupAttributes.QUERY)));
			res.add(new Attribute(Resource.getString("recordgroup.functional.fetch"), record.getProperty(RecordGroupAttributes.QUERY_SIZE)));
		}
		res.add(new Attribute(Resource.getString("recordgroup.functional.columnspec"), record.getProperty(RecordGroupAttributes.COLUMN_COUNT)));

		return res;
	}
}

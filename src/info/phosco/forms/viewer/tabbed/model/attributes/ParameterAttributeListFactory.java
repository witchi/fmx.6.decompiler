package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.parameter.FormParameter;
import info.phosco.forms.translate.element.parameter.ParameterAttributes;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;

import java.util.ArrayList;
import java.util.List;

public class ParameterAttributeListFactory {

	public static List<Attribute> getList(FormParameter param) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("parameter.general")));
		res.add(new Attribute(Resource.getString("parameter.general.name"), param.getName()));
		res.add(new Attribute(Resource.getString("parameter.general.offset"), "0x" + Integer.toHexString(param.getOffset())));

		res.add(new CaptionAttribute(Resource.getString("parameter.data")));
		res.add(new Attribute(Resource.getString("parameter.data.data_type"), param.getProperty(ParameterAttributes.DATATYPE)));
		res.add(new Attribute(Resource.getString("parameter.data.max_length"), param.getProperty(ParameterAttributes.MAX_LENGTH)));
		res.add(new Attribute(Resource.getString("parameter.data.initial_value"), param.getProperty(ParameterAttributes.DEFAULT_VALUE)));

		return res;
	}
}

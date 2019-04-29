package info.phosco.forms.translate.element.trigger;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.util.FileStructureTypeException;

import java.util.List;

public class TriggerListFactory {

	private TriggerListFactory() {
	}

	public static ElementList<FormTrigger> get(Content content, int offset, int length, List<String> userNames) throws FileStructureTypeException {

		ElementList<FormTrigger> res = new ElementList<FormTrigger>();

		for (int i = 0; i < length; i++) {
			res.add(FormTriggerFactory.instance(content, content.getInt(offset, i * 4), userNames));
		}

		return res;
	}

}

package info.phosco.forms.translate.element.canvas.graphic;

import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;

import java.util.Properties;

public class FormGroup implements FormElement<GraphicAttributes> {

	private final Properties props;

	FormGroup(int offset) {
		this.props = new Properties();
		setProperty(GraphicAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(GraphicAttributes key, Object value) {
		this.props.put(key.toString(), value);

	}

	@Override
	public Object getProperty(GraphicAttributes key) {
		return this.props.get(key.toString());
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(GraphicAttributes.OFFSET);
	}

	public Integer getParent() {
		return (Integer) getProperty(GraphicAttributes.PARENT_NODE);
	}

	@SuppressWarnings("unchecked")
	public ElementList<FormGroup> getChildren() {
		return (ElementList<FormGroup>) getProperty(GraphicAttributes.CHILD_LIST);
	}

	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nParent Node                                : " + Integer.toHexString(getParent());

		if (getType() == ElementType.GROUP) {

			out += "\nChild List at                              : "
					+ Integer.toHexString((int) getProperty(GraphicAttributes.CHILD_LIST_OFFSET));
			out += "\nChild List Length                          : "
					+ Integer.toHexString((int) getProperty(GraphicAttributes.CHILD_LIST_LEN));

			for (FormGroup node : getChildren()) {
				out += "\n" + node.toString();
			}
		}

		return out;
	}

	@Override
	public ElementType getType() {
		return ElementType.GROUP;
	}

	public FormElement<?> getElementAtOffset(int offset) {
		if (getOffset() == offset) {
			return this;
		}
		if (getType() != ElementType.GROUP) {
			return null;
		}
		for (FormGroup node : getChildren()) {
			FormElement<?> e = node.getElementAtOffset(offset);
			if (e != null) {
				return e;
			}
		}
		return null;
	}

	@Override
	public String getName() {
		return (String) getProperty(GraphicAttributes.NAME);
	}
}

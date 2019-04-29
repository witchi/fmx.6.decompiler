package info.phosco.forms.viewer.tabbed.detail;

public class Attribute {

	private final String name;

	private final Object value;

	private final AttributeType type;

	public Attribute(String name, Object value, AttributeType type) {
		this.name = name;
		this.value = value;
		this.type = type;
	}

	public Attribute(String name, Object value) {
		this(name, value, AttributeType.PROPERTY);
	}
	
	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public AttributeType getType() {
		return type;
	}

}

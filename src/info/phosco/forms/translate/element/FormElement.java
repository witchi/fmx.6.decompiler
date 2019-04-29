package info.phosco.forms.translate.element;

public interface FormElement<T extends Enum<T> & FormProperties> {

	void setProperty(T key, Object value);

	Object getProperty(T key);
	
	String getName();
	
	ElementType getType();
	
	int getOffset();
}

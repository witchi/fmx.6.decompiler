package info.phosco.forms.translate.element;

import java.util.ArrayList;
import java.util.Iterator;

public class ElementList<K extends FormElement<?>> implements Iterable<K> {

	private final ArrayList<K> list;

	public ElementList() {
		this.list = new ArrayList<K>();
	}

	public int size() {
		return this.list.size();
	}

	public void add(K element) {
		this.list.add(element);
	}

	public K get(int i) {
		return this.list.get(i);
	}

	@Override
	public Iterator<K> iterator() {
		return list.iterator();
	}
}

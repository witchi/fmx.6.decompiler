package info.phosco.forms.translate.element.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextLine {

	private final ArrayList<TextLinePart> parts;

	private final int offset;

	public TextLine(int offset) {
		this.parts = new ArrayList<TextLinePart>();
		this.offset = offset;
	}

	public void add(TextLinePart part) {
		parts.add(part);
	}

	public int getOffset() {
		return offset;
	}

	public List<TextLinePart> getParts() {
		return Collections.unmodifiableList(parts);
	}
}

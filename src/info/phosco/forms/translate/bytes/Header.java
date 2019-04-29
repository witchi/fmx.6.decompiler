package info.phosco.forms.translate.bytes;

public class Header extends AbstractFileStructure {

	public Header(Footer footer, Element elem, Text text, UnsignedByteBuffer buf) {
		super(buf, 0, buf.getLength() - text.getLength() - elem.getLength() - footer.getLength());
	}
}

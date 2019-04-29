package info.phosco.forms.translate.bytes;

public class Element extends AbstractFileStructure {

	private static final int POS_STRUCTURE_LENGTH = 0x20;

	public Element(Footer footer, UnsignedByteBuffer buf) {
		super(buf, buf.getLength() - buf.getInt(POS_STRUCTURE_LENGTH) - (footer.getLength() + 4), buf
				.getInt(POS_STRUCTURE_LENGTH) + 4);
	}
}

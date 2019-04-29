package info.phosco.forms.translate.bytes;

public class Text extends AbstractFileStructure {

	private static final int POS_STRUCTURE_LENGTH = 0x1c;

	public Text(Footer footer, Element elem, UnsignedByteBuffer buf) {
		super(buf, buf.getLength() - buf.getInt(POS_STRUCTURE_LENGTH) - footer.getLength() - elem.getLength(), buf
				.getInt(POS_STRUCTURE_LENGTH));
	}

}

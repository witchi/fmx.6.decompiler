package info.phosco.forms.translate.element.program;

import info.phosco.forms.translate.bytes.AbstractFileStructure;
import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.bytes.UnsignedByteBuffer;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.util.FileStructureTypeException;
import info.phosco.forms.translate.util.Log;

import java.util.logging.Logger;

public class SourceCodeFactory extends AbstractFactory {

	private final static Logger log = Log.getLogger(SourceCodeFactory.class);

	private static final int POS_SIZEOF = 0x14;

	private SourceCodeFactory() {
	}

	private static int getLength(Content content, int offset) throws FileStructureTypeException {

		int len = content.getByte(offset, POS_SIZEOF) << 24;
		len |= (content.getByte(offset, POS_SIZEOF + 1) << 16);
		len |= (content.getByte(offset, POS_SIZEOF + 2) << 8);
		len |= content.getByte(offset, POS_SIZEOF + 3);

		return len;
	}

	public static SourceCode instance(Content content, int offset) throws FileStructureTypeException {

		// TODO: for tests only

		UnsignedByteBuffer bf = UnsignedByteBuffer.wrap(content.getByteArray(offset, 0, getLength(content, offset)));
		AbstractFileStructure fs = new AbstractFileStructure(bf, 0, getLength(content, offset)) {
		};
		log.finest("\n" + fs.formatHex(true, true, false, 24));

		SourceCode res = new SourceCode(offset);
		res.setProperty(ProgramUnitAttributes.LENGTH, getLength(content, offset));

		return res;
	}
}

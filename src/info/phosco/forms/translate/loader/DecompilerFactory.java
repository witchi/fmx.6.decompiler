package info.phosco.forms.translate.loader;

import info.phosco.forms.translate.bytes.UnsignedByteBuffer;
import info.phosco.forms.translate.decompiler.Forms6Decompiler;
import info.phosco.forms.translate.util.MagicNumberException;
import info.phosco.forms.translate.util.FormsVersionException;

public class DecompilerFactory {

	private static final int POS_MAGIC_NUMBER = 0x0;
	private static final int POS_VERSION = 0x8;

	private static final int MAGIC_NUMBER = 0x1b27;

	private DecompilerFactory() {
	}

	public static Decompiler instance(UnsignedByteBuffer file)
			throws MagicNumberException,
			FormsVersionException {

		if (file.getInt(POS_MAGIC_NUMBER) != MAGIC_NUMBER) {
			throw new MagicNumberException();
		}

		FormsVersion version = FormsVersion.lookup(file.getInt(POS_VERSION));
		switch (version) {

		case FORMS_6:
			return new Forms6Decompiler(file);

		case FORMS_9:
		case FORMS_11:
		default:
			throw new FormsVersionException(version);
		}
	}
}

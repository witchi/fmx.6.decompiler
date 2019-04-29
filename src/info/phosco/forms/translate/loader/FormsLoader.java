package info.phosco.forms.translate.loader;

import info.phosco.forms.translate.bytes.UnsignedByteBuffer;
import info.phosco.forms.translate.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;

public class FormsLoader {

	private final static Logger log = Log.getLogger(FormsLoader.class);

	public static final UnsignedByteBuffer load(String fileName) {
		return load(new File(fileName));
	}
	
	public static final UnsignedByteBuffer load(File file) {
		return readContentIntoByteArray(file);
	}

	private static UnsignedByteBuffer readContentIntoByteArray(File file) {

		FileInputStream fileInputStream = null;
		byte[] bFile = new byte[(int) file.length()];
		try {
			// convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("\nLength of file: " + Integer.toHexString(bFile.length) + "\n");
		return UnsignedByteBuffer.wrap(bFile);
	}
}

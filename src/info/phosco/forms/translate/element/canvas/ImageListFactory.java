package info.phosco.forms.translate.element.canvas;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.util.FileStructureTypeException;
import info.phosco.forms.translate.util.Log;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class ImageListFactory {

	private final static Logger log = Log.getLogger(ImageListFactory.class);

	private final static int IMAGE_CHUNK_LEN = 0xFA00;

	private ImageListFactory() {
	}

	private static byte[] concate(byte[] a, byte[] b) {
		int aLen = a.length;
		int bLen = b.length;

		byte[] res = new byte[aLen + bLen];

		System.arraycopy(a, 0, res, 0, aLen);
		System.arraycopy(b, 0, res, aLen, bLen);

		return res;
	}

	private static BufferedImage readImage(byte[] array) {
		ByteArrayInputStream in = new ByteArrayInputStream(array);
		BufferedImage image = null;

		try {
			image = ImageIO.read(in);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage());
		}

		return image;
	}

	private static String getMagicNumber(byte[] array) {
		String res = "";

		int len = (array.length > 10 ? 10 : array.length);
		for (int i = 0; i < len; i++) {
			int val = array[i] & 0xFF;
			if (val < 0x10) {
				res += "0";
			}
			res += Integer.toHexString(val) + " ";
		}

		return res;
	}

	public static List<BufferedImage> get(Content content, int offset, int lengthRef, int count) throws FileStructureTypeException {

		List<BufferedImage> res = new ArrayList<BufferedImage>();

		int ref = 0;
		int pos = 0;

		for (int i = 0; i < count; i++) {

			int length = content.getInt(lengthRef, i * 4);
			int nbrPointer = (length / IMAGE_CHUNK_LEN);

			byte[] imageArray = new byte[0];

			for (int j = 0; j < nbrPointer; j++) {

				ref = content.getInt(offset, pos);
				imageArray = concate(imageArray, content.getByteArray(ref, 0, 0xFA00));
				pos += 4;
			}

			int lastPointer = length % IMAGE_CHUNK_LEN;
			if (lastPointer > 0) {

				ref = content.getInt(offset, pos);
				imageArray = concate(imageArray, content.getByteArray(ref, 0, lastPointer));
				pos += 4;
			}

			BufferedImage image = readImage(imageArray);

			if (image == null) {
				log.warning("cannot read image format of image " + i + ", magic bytes " + getMagicNumber(imageArray));
			}

			res.add(image);
		}

		return res;
	}

}

package info.phosco.forms.translate;

import info.phosco.forms.translate.loader.Decompiler;
import info.phosco.forms.translate.loader.DecompilerFactory;
import info.phosco.forms.translate.loader.FormsLoader;
import info.phosco.forms.translate.util.DecompilerException;
import info.phosco.forms.translate.util.Log;
import info.phosco.forms.translate.util.LogHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class OracleHacker {

	private final static Logger log = Log.getLogger(OracleHacker.class);

	private static void usableImageIOReaders() {

		// ImageIO-Plugins from https://github.com/haraldk/TwelveMonkeys

		StringBuffer buf = new StringBuffer();
		for (String name : ImageIO.getReaderFormatNames()) {
			buf.append(name + "\n");
		}
		log.info(buf.toString());
	}

	public static void main(String[] args) {

		if (args.length < 1) {
			System.out.println("Forms-Decompiler v0.1");
			System.out.println("André Rothe <arothe@phosco.info>");
			System.out.println("Usage: java -jar decompiler.jar file.fmx <debug|info|warn|off>");
			System.exit(1);
		}

		Level level = Level.OFF;
		if (args.length == 2) {
			if ("debug".equalsIgnoreCase(args[1])) {
				level = Level.FINEST;
			}
			if ("warn".equalsIgnoreCase(args[1])) {
				level = Level.WARNING;
			}
			if ("info".equalsIgnoreCase(args[1])) {
				level = Level.INFO;
			}
		}

		LogHandler.init(level);

		usableImageIOReaders();

		try {
			log.info("\nName of file: " + args[0]);

			long start = System.currentTimeMillis();
			Decompiler dc = DecompilerFactory.instance(FormsLoader.load(args[0]));
			dc.execute();
			long stop = System.currentTimeMillis();

			log.info("Decompiled in " + (double) (stop - start) / 1000 + " seconds.");

		} catch (DecompilerException e) {
			log.severe("\nError: " + e.getMessage());
			System.exit(5);
		}
	}

}

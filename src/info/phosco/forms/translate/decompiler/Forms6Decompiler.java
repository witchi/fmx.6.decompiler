package info.phosco.forms.translate.decompiler;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.bytes.Element;
import info.phosco.forms.translate.bytes.Footer;
import info.phosco.forms.translate.bytes.Header;
import info.phosco.forms.translate.bytes.Text;
import info.phosco.forms.translate.bytes.UnsignedByteBuffer;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.alert.FormAlert;
import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.application.FormModuleFactory;
import info.phosco.forms.translate.element.application.ModuleAttributes;
import info.phosco.forms.translate.element.canvas.FormCanvas;
import info.phosco.forms.translate.element.datablock.FormDataBlock;
import info.phosco.forms.translate.element.editor.FormEditor;
import info.phosco.forms.translate.element.font.FormFont;
import info.phosco.forms.translate.element.library.FormLibrary;
import info.phosco.forms.translate.element.parameter.FormParameter;
import info.phosco.forms.translate.element.program.FormProgramUnit;
import info.phosco.forms.translate.element.recordgroup.FormRecordGroup;
import info.phosco.forms.translate.element.trigger.FormTrigger;
import info.phosco.forms.translate.element.visual.attribute.FormVisualGroup;
import info.phosco.forms.translate.element.window.FormWindow;
import info.phosco.forms.translate.loader.Decompiler;
import info.phosco.forms.translate.util.DecompilerException;
import info.phosco.forms.translate.util.Log;

import java.util.logging.Logger;

public class Forms6Decompiler extends AbstractDecompiler implements Decompiler {

	private final static Logger log = Log.getLogger(Forms6Decompiler.class);

	public Forms6Decompiler(UnsignedByteBuffer array) {
		super(array);
	}

	@SuppressWarnings("unchecked")
	private String getContent(FormModule app) {

		String output = "\n" + app.toString();

		for (FormTrigger t : (ElementList<FormTrigger>) app.getProperty(ModuleAttributes.TRIGGER_LIST)) {
			output += "\n" + t.toString();
		}

		for (FormAlert w : (ElementList<FormAlert>) app.getProperty(ModuleAttributes.WARNING_LIST)) {
			output += "\n" + w.toString();
		}

		for (FormLibrary l : (ElementList<FormLibrary>) app.getProperty(ModuleAttributes.LIBRARY_LIST)) {
			output += "\n" + l.toString();
		}

		for (FormDataBlock d : (ElementList<FormDataBlock>) app.getProperty(ModuleAttributes.DATABLOCK_LIST)) {
			output += "\n" + d.toString();
		}

		for (FormCanvas v : (ElementList<FormCanvas>) app.getProperty(ModuleAttributes.CANVAS_LIST)) {
			output += "\n" + v.toString();
		}

		for (FormFont font : (ElementList<FormFont>) app.getProperty(ModuleAttributes.FONT_LIST)) {
			output += "\n" + (font == null ? "DEFAULT FONT" : font.toString());
		}

		for (FormEditor e : (ElementList<FormEditor>) app.getProperty(ModuleAttributes.EDITOR_LIST)) {
			output += "\n" + e.toString();
		}

		for (FormParameter p : (ElementList<FormParameter>) app.getProperty(ModuleAttributes.PARAMETER_LIST)) {
			output += "\n" + p.toString();
		}

		for (FormProgramUnit p : (ElementList<FormProgramUnit>) app.getProperty(ModuleAttributes.PROGRAM_UNIT_LIST)) {
			output += "\n" + p.toString();
		}

		for (FormRecordGroup rg : (ElementList<FormRecordGroup>) app.getProperty(ModuleAttributes.RECORD_GROUP_LIST)) {
			output += "\n" + rg.toString();
		}

		for (FormVisualGroup vg : (ElementList<FormVisualGroup>) app.getProperty(ModuleAttributes.VISUAL_GROUP_LIST)) {
			output += "\n" + vg.toString();
		}

		for (FormWindow w : (ElementList<FormWindow>) app.getProperty(ModuleAttributes.WINDOW_LIST)) {
			output += "\n" + w.toString();
		}

		return output;
	}

	@Override
	public FormModule execute() throws DecompilerException {

		Footer f = new Footer(this.array);
		Element a = new Element(f, this.array);
		Text t = new Text(f, a, this.array);
		Header h = new Header(f, a, t, this.array);
		Content c = new Content(f, a, t, h, this.array);

		log.warning("Header starts at : " + Integer.toHexString(h.getAbsolutePosition()));
		log.warning("Text starts at : " + Integer.toHexString(t.getAbsolutePosition()));
		log.warning("Element starts at : " + Integer.toHexString(a.getAbsolutePosition()));
		log.warning("Footer starts at : " + Integer.toHexString(f.getAbsolutePosition()));

		log.finest("\n" + h.formatHex(true, true, true, 24));
		log.finest("\n" + t.formatHex(true, true, true, 24));
		log.finest("\n" + a.formatHex(true, true, true, 24));
		log.finest("\n" + f.formatHex(true, true, true, 24));

		FormModule app = FormModuleFactory.instance(c);
		log.info(getContent(app) + "\n");

		return app;
	}
}

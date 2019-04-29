package info.phosco.forms.translate.element.application;

import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.FormElement;
import info.phosco.forms.translate.element.alert.FormAlert;
import info.phosco.forms.translate.element.canvas.CanvasAttributes;
import info.phosco.forms.translate.element.canvas.FormCanvas;
import info.phosco.forms.translate.element.canvas.graphic.FormGroup;
import info.phosco.forms.translate.element.datablock.FormDataBlock;
import info.phosco.forms.translate.element.editor.FormEditor;
import info.phosco.forms.translate.element.library.FormLibrary;
import info.phosco.forms.translate.element.parameter.FormParameter;
import info.phosco.forms.translate.element.program.FormProgramUnit;
import info.phosco.forms.translate.element.recordgroup.FormRecordGroup;
import info.phosco.forms.translate.element.trigger.FormTrigger;
import info.phosco.forms.translate.element.visual.attribute.FormVisualGroup;
import info.phosco.forms.translate.element.window.FormWindow;

import java.util.Properties;

public class FormModule implements FormElement<ModuleAttributes> {

	private final Properties props;

	FormModule(int offset) {
		this.props = new Properties();
		setProperty(ModuleAttributes.OFFSET, offset);
	}

	@Override
	public void setProperty(ModuleAttributes key, Object value) {
		this.props.put(key.toString(), value);

	}

	@Override
	public Object getProperty(ModuleAttributes key) {
		return this.props.get(key.toString());
	}

	@Override
	public String getName() {
		return (String) getProperty(ModuleAttributes.NAME);
	}

	@Override
	public ElementType getType() {
		return ElementType.MODULE;
	}

	@Override
	public int getOffset() {
		return (Integer) getProperty(ModuleAttributes.OFFSET);
	}

	public String getCharacterSet() {
		return (String) getProperty(ModuleAttributes.CHARACTERSET);
	}

	@Override
	public String toString() {
		String out = "";
		out += "\nType                                       : " + getType();
		out += "\nOffset                                     : " + Integer.toHexString(getOffset());
		out += "\nCharacterset                               : " + getCharacterSet();
		out += "\nName                                       : " + getName();
		out += "\nTitel                                      : " + getProperty(ModuleAttributes.TITLE);
		out += "\nMenüquelle                                 : " + getProperty(ModuleAttributes.MENU_SOURCE);
		out += "\nMenümodule                                 : " + getProperty(ModuleAttributes.MENU_MODULE);

		out += "\nDefer Required-Durchsetzung                : " + getProperty(ModuleAttributes.DEFER_REQUIRED);

		out += "\nMausnavigation                             : " + getProperty(ModuleAttributes.MOUSE_NAVIGATION_LIMIT);

		out += "\nVisuelle Attributgruppe Aktueller Datensatz: " + Integer.toHexString((Integer) getProperty(ModuleAttributes.VISUAL_GROUP_RECORD));

		out += "\nValidierungseinheit                        : " + getProperty(ModuleAttributes.VALIDATION_UNIT);
		out += "\nInteraktionsmodus                          : " + getProperty(ModuleAttributes.INTERCATION_MODE);
		out += "\nMaximale Abfragezeit                       : " + getProperty(ModuleAttributes.MAX_QUERY_TIME);
		out += "\nMaximal abgerufene Datensätze              : " + getProperty(ModuleAttributes.MAX_RECORDS_FETCHED);
		out += "\nIsolationsmodus                            : " + getProperty(ModuleAttributes.ISOLATION_MODE);

		out += "\nKoordinatensystem                          : " + getProperty(ModuleAttributes.COORD_SYSTEM);
		out += "\nKoordinatensystem-Einheit                  : " + getProperty(ModuleAttributes.COORD_SYSTEM_UNIT);
		out += "\n3D-Steuerelemente verwenden                : " + getProperty(ModuleAttributes.USE_3D_CONTROLS);
		out += "\nZeicheneinheit Breite                      : " + getProperty(ModuleAttributes.UNIT_WIDTH);
		out += "\nZeicheneinheit Höhe                        : " + getProperty(ModuleAttributes.UNIT_HEIGHT);

		out += "\nRichtung                                   : " + getProperty(ModuleAttributes.DIRECTION);
		out += "\nLaufzeit-Kompatibilitätsmodus              : " + getProperty(ModuleAttributes.RUNTIME_COMPATIBILITY);
		return out;

	}

	@SuppressWarnings("unchecked")
	public FormElement<?> getElementAtOffset(int offset) {
		if (offset == getOffset()) {
			return this;
		}

		for (FormTrigger t : (ElementList<FormTrigger>) getProperty(ModuleAttributes.TRIGGER_LIST)) {
			if (t.getOffset() == offset) {
				return t;
			}
		}

		for (FormAlert w : (ElementList<FormAlert>) getProperty(ModuleAttributes.WARNING_LIST)) {
			if (w.getOffset() == offset) {
				return w;
			}
		}

		for (FormLibrary l : (ElementList<FormLibrary>) getProperty(ModuleAttributes.LIBRARY_LIST)) {
			if (l.getOffset() == offset) {
				return l;
			}
		}

		for (FormDataBlock d : (ElementList<FormDataBlock>) getProperty(ModuleAttributes.DATABLOCK_LIST)) {
			if (d.getOffset() == offset) {
				return d;
			}
			// TODO: check sub tree
		}

		for (FormCanvas v : (ElementList<FormCanvas>) getProperty(ModuleAttributes.CANVAS_LIST)) {
			if (v.getOffset() == offset) {
				return v;
			}
			if (v.hasGraphicTree()) {
				FormGroup node = (FormGroup) v.getProperty(CanvasAttributes.GRAPHIC_TREE);
				FormElement<?> e = node.getElementAtOffset(offset);
				if (e != null) {
					return e;
				}
			}
		}

		for (FormEditor e : (ElementList<FormEditor>) getProperty(ModuleAttributes.EDITOR_LIST)) {
			if (e.getOffset() == offset) {
				return e;
			}
		}

		for (FormParameter p : (ElementList<FormParameter>) getProperty(ModuleAttributes.PARAMETER_LIST)) {
			if (p.getOffset() == offset) {
				return p;
			}
		}

		for (FormProgramUnit u : (ElementList<FormProgramUnit>) getProperty(ModuleAttributes.PROGRAM_UNIT_LIST)) {
			if (u.getOffset() == offset) {
				return u;
			}
		}

		for (FormRecordGroup rg : (ElementList<FormRecordGroup>) getProperty(ModuleAttributes.RECORD_GROUP_LIST)) {
			if (rg.getOffset() == offset) {
				return rg;
			}
		}

		for (FormVisualGroup vg : (ElementList<FormVisualGroup>) getProperty(ModuleAttributes.VISUAL_GROUP_LIST)) {
			if (vg.getOffset() == offset) {
				return vg;
			}
		}

		for (FormWindow w : (ElementList<FormWindow>) getProperty(ModuleAttributes.WINDOW_LIST)) {
			if (w.getOffset() == offset) {
				return w;
			}
		}
		return null;
	}

}

package info.phosco.forms.translate.element.canvas;

import info.phosco.forms.translate.bytes.Content;
import info.phosco.forms.translate.element.AbstractFactory;
import info.phosco.forms.translate.element.Direction;
import info.phosco.forms.translate.element.ElementList;
import info.phosco.forms.translate.element.ElementType;
import info.phosco.forms.translate.element.canvas.graphic.FormGroup;
import info.phosco.forms.translate.element.canvas.graphic.FormGroupFactory;
import info.phosco.forms.translate.element.canvas.graphic.GraphicAttributes;
import info.phosco.forms.translate.element.font.FormFont;
import info.phosco.forms.translate.element.visual.substruct.VisualSubStructFactory;
import info.phosco.forms.translate.util.FileStructureTypeException;
import info.phosco.forms.translate.util.FormElementTypeException;

import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.List;

public class FormCanvasFactory extends AbstractFactory {

	private static final int POS_NAME = 0x0;

	private static final int POS_WINDOW = 0x4;

	private static final int POS_VISUAL_SUBSTRUCT = 0xC;

	private static final int POS_SHAPE = 0x14;

	private static final int POS_GRAPHIC_TREE_ROOT = 0x18;

	private static final int POS_IMAGE_LEN_REF = 0x24;
	
	private static final int POS_IMAGE_REF = 0x28;

	private static final int POS_CANVAS_TYPE = 0x38;

	private static final int POS_VIEWPORT_X = 0x40;

	private static final int POS_VIEWPORT_Y = 0x44;

	private static final int POS_VIEWPORT_WIDTH = 0x48;

	private static final int POS_VIEWPORT_HEIGHT = 0x4C;

	private static final int POS_WIDTH = 0x50;

	private static final int POS_HEIGHT = 0x54;

	private static final int POS_VIEWPORT_X_ON_CANVAS = 0x58;

	private static final int POS_VIEWPORT_Y_ON_CANVAS = 0x5C;

	private static final int POS_BITMASK = 0x60;

	private static final int POS_IMAGE_COUNT = 0x64;

	private static final int POS_DIRECTION = 0x68;

	private static final int POS_REGISTER_EDGE = 0x78;

	private static final int POS_EDGE_STYLE = 0x7c;

	private static final int POS_HELP_THEME = 0x80;

	private FormCanvasFactory() {
	}

	public static FormCanvas instance(Content content, int offset, ElementList<FormFont> fontList) throws FileStructureTypeException,
			FormElementTypeException {

		FormCanvas res = new FormCanvas(offset);

		int ref = content.getInt(offset, POS_NAME);
		res.setProperty(CanvasAttributes.NAME, content.getString(ref, 2, content.getShort(ref, 0)));

		res.setProperty(CanvasAttributes.CANVAS_TYPE, CanvasType.lookup(content.getInt(offset, POS_CANVAS_TYPE)));

		ref = content.getInt(offset, POS_HELP_THEME);
		res.setProperty(CanvasAttributes.HELP, (ref == 0 ? "" : content.getString(ref, 0)));

		res.setProperty(CanvasAttributes.WINDOW, content.getInt(offset, POS_WINDOW));
		res.setProperty(CanvasAttributes.BEVEL, CanvasBevel.lookup(content.getInt(offset, POS_SHAPE)));
		res.setProperty(CanvasAttributes.DIRECTION, Direction.lookup(content.getShort(offset, POS_DIRECTION)));

		// it points also to a global visual group, if there is inheritance
		// TODO: we have to look for known visual group instances to build the
		// graph
		ref = content.getInt(offset, POS_VISUAL_SUBSTRUCT);
		res.setProperty(CanvasAttributes.VISUAL_STRUCT, VisualSubStructFactory.instance(content, ref));

		int bitmask = content.getInt(offset, POS_BITMASK);
		res.setProperty(CanvasAttributes.VISIBLE, !bool(bitmask & 0x4));
		res.setProperty(CanvasAttributes.AUTOMATIC, !bool(bitmask & 0x8));

		if (!res.isVerticalScrollbar()) {
			// Height of Canvas, starts always on x=0
			res.setProperty(CanvasAttributes.HEIGHT, content.getInt(offset, POS_HEIGHT));
		}

		if (!res.isHorizontalScrollbar()) {
			// Width of Canvas, starts always on y=0
			res.setProperty(CanvasAttributes.WIDTH, content.getInt(offset, POS_WIDTH));
		}

		if (!res.isScrollbar() && !res.isRegister()) {
			// ViewPort X and Y (black rectangle in Layout Editor)
			// TODO: where is viewport height and width?
			res.setProperty(CanvasAttributes.VIEWPORT_X_ON_CANVAS, content.getInt(offset, POS_VIEWPORT_X_ON_CANVAS));
			res.setProperty(CanvasAttributes.VIEWPORT_Y_ON_CANVAS, content.getInt(offset, POS_VIEWPORT_Y_ON_CANVAS));
		}

		if (res.isStacked() || res.isRegister()) {
			res.setProperty(CanvasAttributes.VIEWPORT_X, content.getShort(offset, POS_VIEWPORT_X));
			res.setProperty(CanvasAttributes.VIEWPORT_Y, content.getShort(offset, POS_VIEWPORT_Y));
			res.setProperty(CanvasAttributes.VIEWPORT_WIDTH, content.getShort(offset, POS_VIEWPORT_WIDTH));
			res.setProperty(CanvasAttributes.VIEWPORT_HEIGHT, content.getShort(offset, POS_VIEWPORT_HEIGHT));
		}

		if (res.isStacked()) {
			bitmask = content.getInt(offset, POS_BITMASK);
			res.setProperty(CanvasAttributes.SCROLLBAR_POSSIBLE, !bool(bitmask & 0x10));
			res.setProperty(CanvasAttributes.H_SCROLLBAR, !bool(bitmask & 0x40));
			res.setProperty(CanvasAttributes.V_SCROLLBAR, !bool(bitmask & 0x80));
		}

		if (res.isRegister()) {
			res.setProperty(CanvasAttributes.EDGE_STYLE, EdgeStyle.lookup(content.getShort(offset, POS_EDGE_STYLE)));
			res.setProperty(CanvasAttributes.REGISTER_EDGE, RegisterEdge.lookup(content.getShort(offset, POS_REGISTER_EDGE)));
			bitmask = content.getInt(offset, POS_BITMASK);
			res.setProperty(CanvasAttributes.STYLE_WIDTH, StyleWidth.lookup(bitmask & 0x8000));
			res.setProperty(CanvasAttributes.ACTIVE_STYLE, ActiveStyle.lookup(bitmask & 0x10000));
		}

		List<BufferedImage> imageList = Collections.emptyList();

		int referenceList = content.getInt(offset, POS_IMAGE_REF);
		int lengthList = content.getInt(offset, POS_IMAGE_LEN_REF);
		if (referenceList != 0) {
			imageList = ImageListFactory.get(content, referenceList, lengthList, content.getInt(offset, POS_IMAGE_COUNT));
		}

		ref = content.getInt(offset, POS_GRAPHIC_TREE_ROOT);
		if (ref != 0) {
			FormGroup group = FormGroupFactory.get(content, ref, fontList);
			res.setProperty(CanvasAttributes.GRAPHIC_TREE, group);
			mapImageContent(group, imageList);
		}

		// TODO: read properties POPUP_MENU,
		// SUBCLASS_INFORMATION

		// TODO: there is some more on this reference, except the LIST and LEN
		// every Structure of Type 18 02 02 02 is a structure node, which builds
		// a tree of elements

		return res;
	}

	private static void mapImageContent(FormGroup group, List<BufferedImage> imageList) {

		if (group.getType() == ElementType.GROUP) {
			for (FormGroup elem : group.getChildren()) {
				mapImageContent(elem, imageList);
			}
		}

		if (group.getType() == ElementType.IMAGE) {
			int idx = (int) group.getProperty(GraphicAttributes.IMAGE_INDEX);
			group.setProperty(GraphicAttributes.CONTENT, imageList.get(idx));
		}
	}
}

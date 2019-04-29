package info.phosco.forms.viewer.tabbed.model.attributes;

import info.phosco.forms.translate.element.canvas.graphic.FormImage;
import info.phosco.forms.translate.element.canvas.graphic.GraphicAttributes;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.detail.CaptionAttribute;
import info.phosco.forms.viewer.tabbed.model.CoordinateSystem;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

public class ImageAttributeListFactory {

	private static ImageView getImageContent(BufferedImage image) {
		ImageView res = new ImageView();
		res.setImage(SwingFXUtils.toFXImage(image, null));
		return res;
	}

	public static List<Attribute> getList(FormImage image, CoordinateSystem coords) {
		ArrayList<Attribute> res = new ArrayList<Attribute>();

		res.add(new CaptionAttribute(Resource.getString("image.general")));
		res.add(new Attribute(Resource.getString("image.general.name"), image.getName()));
		res.add(new Attribute(Resource.getString("image.general.type"), image.getType()));
		res.add(new Attribute(Resource.getString("image.general.offset"), "0x" + Integer.toHexString(image.getOffset())));
		res.add(new Attribute(Resource.getString("image.general.content"), getImageContent((BufferedImage) image
				.getProperty(GraphicAttributes.CONTENT))));

		res.add(new CaptionAttribute(Resource.getString("image.functional")));
		res.add(new Attribute(Resource.getString("image.functional.quality"), image.getProperty(GraphicAttributes.QUALITY)));

		res.add(new CaptionAttribute(Resource.getString("image.physical")));
		res.add(new Attribute(Resource.getString("image.physical.x"), coords.toUnit((int) image.getProperty(GraphicAttributes.X))));
		res.add(new Attribute(Resource.getString("image.physical.y"), coords.toUnit((int) image.getProperty(GraphicAttributes.Y))));
		res.add(new Attribute(Resource.getString("image.physical.width"), coords.toUnit((int) image.getProperty(GraphicAttributes.WIDTH))));
		res.add(new Attribute(Resource.getString("image.physical.height"), coords.toUnit((int) image.getProperty(GraphicAttributes.HEIGHT))));
		res.add(new Attribute(Resource.getString("image.physical.dither"), image.getProperty(GraphicAttributes.DITHER)));
		res.add(new Attribute(Resource.getString("image.physical.clip_x"), coords.toUnit((int) image.getProperty(GraphicAttributes.CLIP_X))));
		res.add(new Attribute(Resource.getString("image.physical.clip_y"), coords.toUnit((int) image.getProperty(GraphicAttributes.CLIP_Y))));
		res.add(new Attribute(Resource.getString("image.physical.clip_width"), coords.toUnit((int) image.getProperty(GraphicAttributes.CLIP_WIDTH))));
		res.add(new Attribute(Resource.getString("image.physical.clip_height"), coords.toUnit((int) image.getProperty(GraphicAttributes.CLIP_HEIGHT))));

		res.add(new CaptionAttribute(Resource.getString("image.visual")));
		res.add(new Attribute(Resource.getString("image.visual.visual_attribute_group"), Resource.getString("image.visual.not_included")));

		return res;
	}
}

package info.phosco.forms.viewer.tabbed.model.layout;

import info.phosco.forms.translate.element.canvas.graphic.FormImage;
import info.phosco.forms.translate.element.canvas.graphic.GraphicAttributes;
import info.phosco.forms.viewer.tabbed.model.CoordinateSystem;

import java.awt.image.BufferedImage;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;

public class ImageFactory {

	private static WritableImage getImageContent(BufferedImage image) {
		return SwingFXUtils.toFXImage(image, null);
	}

	public static ImageLayoutElement newInstance(FormImage image, CoordinateSystem coords) {

		double x = coords.toUnitDouble((int) image.getProperty(GraphicAttributes.X));
		double y = coords.toUnitDouble((int) image.getProperty(GraphicAttributes.Y));
		double width = coords.toUnitDouble((int) image.getProperty(GraphicAttributes.WIDTH));
		double height = coords.toUnitDouble((int) image.getProperty(GraphicAttributes.HEIGHT));

		int clipX = coords.toScreen((int) image.getProperty(GraphicAttributes.CLIP_X));
		int clipY = coords.toScreen((int) image.getProperty(GraphicAttributes.CLIP_Y));
		int clipWidth = coords.toScreen((int) image.getProperty(GraphicAttributes.CLIP_WIDTH));
		int clipHeight = coords.toScreen((int) image.getProperty(GraphicAttributes.CLIP_HEIGHT));

		ImageLayoutElement res = new ImageLayoutElement();
		res.setX(x);
		res.setY(y);
		res.setWidth(width);
		res.setHeight(height);
		res.setClipX(clipX);
		res.setClipY(clipY);
		res.setClipWidth(clipWidth);
		res.setClipHeight(clipHeight);
		res.setImage(getImageContent((BufferedImage) image.getProperty(GraphicAttributes.CONTENT)));

		return res;
	}
}
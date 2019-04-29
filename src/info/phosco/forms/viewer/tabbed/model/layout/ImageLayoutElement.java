package info.phosco.forms.viewer.tabbed.model.layout;

import info.phosco.forms.viewer.tabbed.model.LayoutElement;
import javafx.scene.image.Image;

public class ImageLayoutElement implements LayoutElement {

	private double x, y, width, height, border;

	private int clipX, clipY, clipWidth, clipHeight;

	private Image image;

	ImageLayoutElement() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
		clipX = 0;
		clipY = 0;
		clipWidth = 0;
		clipHeight = 0;
		image = null;
	}

	void setX(double x) {
		this.x = x;
	}

	void setY(double y) {
		this.y = y;
	}

	void setWidth(double width) {
		this.width = width;
	}

	void setHeight(double height) {
		this.height = height;
	}

	void setClipX(int x) {
		this.x = x;
	}

	void setClipY(int y) {
		this.y = y;
	}

	void setClipWidth(int width) {
		this.width = width;
	}

	void setClipHeight(int height) {
		this.height = height;
	}

	void setImage(Image image) {
		this.image = image;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public int getClipX() {
		return clipX;
	}

	public int getClipY() {
		return clipY;
	}

	public int getClipWidth() {
		return clipWidth;
	}

	public int getClipHeight() {
		return clipHeight;
	}

	public Image getImage() {
		return this.image;
	}

}

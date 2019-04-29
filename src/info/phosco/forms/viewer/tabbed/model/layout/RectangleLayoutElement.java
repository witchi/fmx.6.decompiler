package info.phosco.forms.viewer.tabbed.model.layout;

import info.phosco.forms.translate.element.canvas.CanvasBevel;
import info.phosco.forms.viewer.tabbed.model.LayoutElement;
import javafx.scene.paint.Color;

public class RectangleLayoutElement implements LayoutElement {

	private double x, y, width, height, border;

	private Color backgroundColor;

	private Color foregroundColor;

	private CanvasBevel bevel;

	RectangleLayoutElement() {
		x = 0;
		y = 0;
		width = 0;
		height = 0;
		foregroundColor = Color.TRANSPARENT;
		backgroundColor = Color.TRANSPARENT;
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

	void setBorderWidth(double border) {
		this.border = border;
	}

	void setBevel(CanvasBevel bevel) {
		this.bevel = bevel;
	}

	void setBackgroundColor(Color color) {
		this.backgroundColor = color;
	}

	void setForegroundColor(Color color) {
		this.foregroundColor = color;
	}

	public double getBorder() {
		return border;
	}

	public void setBorder(double border) {
		this.border = border;
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

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public Color getForegroundColor() {
		return foregroundColor;
	}

	public CanvasBevel getBevel() {
		return bevel;
	}

}

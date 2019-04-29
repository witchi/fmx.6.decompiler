package info.phosco.forms.viewer.tabbed.detail;

import info.phosco.forms.viewer.tabbed.model.LayoutElement;
import info.phosco.forms.viewer.tabbed.model.layout.ImageLayoutElement;
import info.phosco.forms.viewer.tabbed.model.layout.RectangleLayoutElement;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class LayoutTab implements DetailAreaTab {

	private static final int INSETS = 10;

	private Tab tab;

	private Pane pane;

	private DetailAreaTabContextMenu contextMenu;

	@Override
	public Tab getUI() {
		if (tab == null) {

			ScrollPane sp = new ScrollPane();
			sp.setFitToHeight(true);
			sp.setFitToWidth(true);

			tab = new Tab();
			tab.setContent(sp);
			tab.setContextMenu(getContextMenu().getUI());

			sp.setContent(getCanvasPane());
		}
		return tab;
	}

	private Pane getCanvasPane() {
		if (pane == null) {
			pane = new Pane();
		}
		return pane;
	}

	@Override
	public void setText(String text) {
		getUI().setText(text);
	}

	@Override
	public void setTooltip(Tooltip tip) {
		getUI().setTooltip(tip);
	}

	@Override
	public void setOnClosed(EventHandler<Event> handler) {
		getUI().setOnClosed(handler);
	}

	@Override
	public void setGraphic(Node node) {
		getUI().setGraphic(node);
	}

	@Override
	public DetailAreaTabContextMenu getContextMenu() {
		if (contextMenu == null) {
			contextMenu = new DetailAreaTabContextMenuImpl();
		}
		return contextMenu;
	}

	public void drawElement(LayoutElement e) {
		if (e instanceof RectangleLayoutElement) {

			RectangleLayoutElement l = (RectangleLayoutElement) e;

			Rectangle r = new Rectangle(INSETS + l.getX(), INSETS + l.getY(), l.getWidth(), l.getHeight());
			r.setFill(l.getBackgroundColor());
			r.setStroke(l.getForegroundColor());
			r.setStrokeWidth(l.getBorder());
			r.setStrokeType(StrokeType.OUTSIDE);

			getCanvasPane().getChildren().add(r);
		}
		
		if (e instanceof ImageLayoutElement) {
			
			ImageLayoutElement l = (ImageLayoutElement) e;
			
			PixelReader reader = l.getImage().getPixelReader();
			WritableImage clipImage = new WritableImage(reader, l.getClipX(), l.getClipY(), l.getClipWidth(), l.getClipHeight());

			ImageView iv = new ImageView();
			iv.setImage(clipImage);
			iv.setX(l.getX());
			iv.setY(l.getY());
			
			getCanvasPane().getChildren().add(iv);
		}
		
		// TODO: add more elements
	}

}

package info.phosco.forms.viewer.tabbed.detail;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TabFactory {

	// DUMMY CLASS
	private TabFactory() {
	}

	public static Tab newInstance() {

		int defWidth = 540;
		int defHeight = 324;

		ScrollPane sp = new ScrollPane();
		sp.setFitToHeight(true);
		sp.setFitToWidth(true);

		Tab tab = new Tab();
		tab.setText("Mappe");
		tab.setContent(sp);

		Pane p = new Pane();

		int strokeWidth = 3;
		p.setMinSize(defWidth + strokeWidth, defHeight + strokeWidth);
		p.setPrefSize(defWidth + strokeWidth, defHeight + strokeWidth);
		p.setMaxSize(defWidth + strokeWidth, defHeight + strokeWidth);

		p.setBackground(new Background(new BackgroundFill(Color.rgb(0xce, 0xcf, 0xce), CornerRadii.EMPTY, Insets.EMPTY)));
		p.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,
				new BorderWidths(strokeWidth, strokeWidth, strokeWidth, strokeWidth), Insets.EMPTY)));

		Text text1 = new Text(100, 100, "Test");
		text1.setFont(Font.font("Verdana", 20));
		text1.setRotate(20);

		strokeWidth = 1;
		Rectangle rectangle0 = new Rectangle(strokeWidth, strokeWidth, defWidth + strokeWidth, defHeight + strokeWidth);
		rectangle0.setFill(Color.TRANSPARENT);
		rectangle0.setStroke(Color.BLACK);
		rectangle0.setStrokeWidth(strokeWidth); // half of stroke width is

		strokeWidth = 10;
		Rectangle rectangle1 = new Rectangle(70 - strokeWidth / 2, 70 - strokeWidth / 2, 100 + strokeWidth,
				100 + strokeWidth);
		rectangle1.setFill(Color.DARKGRAY);
		rectangle1.setStroke(Color.RED);
		rectangle1.setStrokeWidth(strokeWidth); // half of stroke width is
												// inside the rectangle,
												// increase size!

		strokeWidth = 1;
		Rectangle rectangle2 = new Rectangle(70 - strokeWidth / 2, 70 - strokeWidth / 2, 100 + strokeWidth,
				100 + strokeWidth);
		rectangle2.setFill(Color.TRANSPARENT);
		rectangle2.setStroke(Color.BLACK);
		rectangle2.setStrokeWidth(strokeWidth);

		strokeWidth = 0;
		Rectangle rectangle3 = new Rectangle(70 - strokeWidth / 2, 70 - strokeWidth / 2, 50 + strokeWidth,
				50 + strokeWidth);
		rectangle3.setFill(Color.GREEN);
		rectangle3.setStrokeWidth(strokeWidth);

		p.getChildren().addAll(rectangle0, rectangle1, rectangle2, rectangle3, text1);

		StackPane background = new StackPane();
		background.setBackground(new Background(new BackgroundFill(Color.rgb(0xd6, 0xd3, 0xce), CornerRadii.EMPTY,
				Insets.EMPTY)));
		background.setMinSize(p.getPrefWidth(), p.getPrefHeight());
		background.getChildren().add(p);

		sp.setContent(background);
		return tab;
	}
}

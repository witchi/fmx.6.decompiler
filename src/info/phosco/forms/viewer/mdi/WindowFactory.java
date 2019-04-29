package info.phosco.forms.viewer.mdi;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import jfxtras.scene.control.window.CloseIcon;
import jfxtras.scene.control.window.MinimizeIcon;
import jfxtras.scene.control.window.Window;

public class WindowFactory {

	private static final WindowList list = new WindowList();

	private WindowFactory() {
	}

	public static Window newInstance(String title, int x, int y) {

		Window w = new Window(title);
		w.getRightIcons().add(new MinimizeIcon(w));
		w.getRightIcons().add(new CloseIcon(w));

		w.setPrefSize(600, 400);

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(new PieChart.Data("Grapefruit",
				13), new PieChart.Data("Oranges", 25), new PieChart.Data("Plums", 10), new PieChart.Data("Pears", 22),
				new PieChart.Data("Apples", 30));
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Imported Fruits");

		w.getContentPane().getChildren().add(chart);
		w.setLayoutX(x);
		w.setLayoutY(y);

		w.setOnCloseAction(new WindowEventHandler(list, w));
		list.put(title, w);
		return w;
	}
}

package info.phosco.forms.viewer.tabbed.detail;

import javafx.beans.binding.Bindings;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class ValueTableCellFactory implements Callback<TableColumn<Attribute, Object>, TableCell<Attribute, Object>> {

	@Override
	public TableCell<Attribute, Object> call(TableColumn<Attribute, Object> param) {
		return new ValueTableCell(param);
	}

	class ValueTableCell extends TableCell<Attribute, Object> {

		private final TableColumn<Attribute, Object> col;

		public ValueTableCell(TableColumn<Attribute, Object> col) {
			this.col = col;
		}

		@Override
		protected void updateItem(Object item, boolean empty) {
			super.updateItem(item, empty);

			setText("");
			if (item != null) {
				if (item instanceof ImageView) {

					ImageView image = (ImageView) item;
					image.setPreserveRatio(true);
					image.setSmooth(true);
					image.setCache(true);

					image.fitWidthProperty().bind(
							Bindings.when(image.getImage().widthProperty().greaterThan(col.widthProperty().getValue() - 40))
									.then(col.widthProperty().subtract(40)).otherwise(image.getImage().getWidth()));
					setGraphic(image);

				} else {

					Text text = new Text(item.toString());
					text.wrappingWidthProperty().bind(col.widthProperty().subtract(40));
					setGraphic(text);
				}
			} else {
				setGraphic(null);
			}
		};

	}

}

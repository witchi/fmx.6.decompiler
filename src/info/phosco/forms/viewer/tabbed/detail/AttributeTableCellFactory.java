package info.phosco.forms.viewer.tabbed.detail;

import javafx.css.PseudoClass;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class AttributeTableCellFactory implements
		Callback<TableColumn<Attribute, Attribute>, TableCell<Attribute, Attribute>> {

	private final PseudoClass caption = PseudoClass.getPseudoClass("attribute-caption");

	@Override
	public TableCell<Attribute, Attribute> call(TableColumn<Attribute, Attribute> param) {

		return new TableCell<Attribute, Attribute>() {

			@Override
			protected void updateItem(Attribute item, boolean empty) {
				super.updateItem(item, empty);

				if (item != null) {
					setText(item.getName());
					setGraphic(null);
				} else {
					setText("");
					setGraphic(null);
				}

				pseudoClassStateChanged(caption, !empty && item != null && item.getType() == AttributeType.CAPTION);
			};

		};
	}
}

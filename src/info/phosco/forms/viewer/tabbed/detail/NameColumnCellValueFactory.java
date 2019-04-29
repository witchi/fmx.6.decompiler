package info.phosco.forms.viewer.tabbed.detail;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class NameColumnCellValueFactory implements
		Callback<CellDataFeatures<Attribute, Attribute>, ObservableValue<Attribute>> {

	@Override
	public ObservableValue<Attribute> call(CellDataFeatures<Attribute, Attribute> p) {
		return new ReadOnlyObjectWrapper<Attribute>(p.getValue());
	}
}

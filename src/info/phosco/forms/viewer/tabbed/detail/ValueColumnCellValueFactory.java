package info.phosco.forms.viewer.tabbed.detail;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

public class ValueColumnCellValueFactory implements
		Callback<CellDataFeatures<Attribute, Object>, ObservableValue<Object>> {

	@Override
	public ObservableValue<Object> call(CellDataFeatures<Attribute, Object> p) {
		return new ReadOnlyObjectWrapper<Object>(p.getValue().getValue() == null ? "" : p.getValue().getValue());
	}
}

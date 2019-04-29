package info.phosco.forms.viewer.tabbed.detail;

import info.phosco.forms.viewer.resource.Resource;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AttributeTab implements DetailAreaTab {

	private Tab tab;

	private TableView<Attribute> table;

	private DetailAreaTabContextMenu contextMenu;

	public AttributeTab() {

		ScrollPane sp = new ScrollPane();
		sp.setFitToHeight(true);
		sp.setFitToWidth(true);

		getUI().setContent(sp);

		VBox v = new VBox();
		v.setPadding(new Insets(10));

		sp.setContent(v);

		getTable().setEditable(false);
		getTable().setPlaceholder(new Text(Resource.getString("property.placeholder")));
		v.getChildren().add(getTable());

		TableColumn<Attribute, Attribute> name = new TableColumn<>(Resource.getString("property.column.1"));
		name.setCellValueFactory(new NameColumnCellValueFactory());
		name.setCellFactory(new AttributeTableCellFactory());
		name.setSortable(false);

		TableColumn<Attribute, Object> value = new TableColumn<>(Resource.getString("property.column.2"));
		value.setCellValueFactory(new ValueColumnCellValueFactory());
		value.setCellFactory(new ValueTableCellFactory());
		value.setSortable(false);

		getTable().getColumns().add(name);
		getTable().getColumns().add(value);
		VBox.setVgrow(getTable(), Priority.ALWAYS);

		name.prefWidthProperty().bind(getTable().widthProperty().multiply(0.4));
		value.prefWidthProperty().bind(getTable().widthProperty().multiply(0.6));

		getUI().setContextMenu(getContextMenu().getUI());
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
	public DetailAreaTabContextMenu getContextMenu() {
		if (contextMenu == null) {
			contextMenu = new DetailAreaTabContextMenuImpl();
		}
		return contextMenu;
	}

	@Override
	public Tab getUI() {
		if (tab == null) {
			tab = new Tab();
		}
		return tab;
	}

	private TableView<Attribute> getTable() {
		if (table == null) {
			table = new TableView<Attribute>();
		}
		return table;
	}

	public void addAttribute(Attribute a) {
		getTable().getItems().add(a);
	}

	@Override
	public void setOnClosed(EventHandler<Event> handler) {
		getUI().setOnClosed(handler);
	}

	@Override
	public void setGraphic(Node node) {
		getUI().setGraphic(node);
	}

}

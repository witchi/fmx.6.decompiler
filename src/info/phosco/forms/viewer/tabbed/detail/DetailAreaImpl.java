package info.phosco.forms.viewer.tabbed.detail;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class DetailAreaImpl implements DetailArea {

	private TabPane tabPane;

	@Override
	public TabPane getUI() {
		if (tabPane == null) {
			tabPane = new TabPane();
		}
		return tabPane;
	}

	@Override
	public void select(Tab tab) {
		tabPane.getSelectionModel().select(tab);
	}

	@Override
	public void closeTab(Tab tab) {
		getUI().getTabs().remove(tab);
	}

	@Override
	public AttributeTab openAttributeTab() {
		AttributeTab tab = new AttributeTab();
		getUI().getTabs().add(tab.getUI());
		return tab;
	}

	@Override
	public LayoutTab openLayoutTab() {
		LayoutTab tab = new LayoutTab();
		getUI().getTabs().add(tab.getUI());
		return tab;
	}

	@Override
	public SourceTab openSourceTab() {
		SourceTab tab = new SourceTab();
		getUI().getTabs().add(tab.getUI());
		return tab;
	}

}

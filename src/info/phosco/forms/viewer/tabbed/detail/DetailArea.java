package info.phosco.forms.viewer.tabbed.detail;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public interface DetailArea {

	TabPane getUI();

	AttributeTab openAttributeTab();

	LayoutTab openLayoutTab();

	SourceTab openSourceTab();

	void select(Tab tab);

	void closeTab(Tab tab);

}

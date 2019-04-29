package info.phosco.forms.viewer.tabbed.detail;

import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.browser.TreeChangeRemoveEvent;
import info.phosco.forms.viewer.tabbed.model.ApplicationModel;
import info.phosco.forms.viewer.tabbed.model.LayoutElement;
import info.phosco.forms.viewer.tabbed.model.ModelChangeEvent;
import info.phosco.forms.viewer.tabbed.model.ModelChangeListener;
import info.phosco.forms.viewer.tabbed.model.NodeType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.scene.control.Tooltip;

public class DetailAreaController implements ModelChangeListener {

	private final ApplicationModel model;

	private final DetailArea view;

	private final HashMap<DetailAreaTabContent, DetailAreaTab> openTabs;

	public DetailAreaController(ApplicationModel model, DetailArea view) {
		this.model = model;
		this.view = view;
		this.openTabs = new HashMap<DetailAreaTabContent, DetailAreaTab>();

		model.addModelChangeListener(this);
	}

	public void openAttributeTab(BrowserTreeNode node) {
		if (!node.hasAttributes()) {
			return;
		}

		DetailAreaTabContent content = new DetailAreaTabContent(node, NodeType.ATTRIBUTES);
		if (!openTabs.containsKey(content)) {

			DetailAreaTab tab = view.openAttributeTab();
			tab.setText(node.getName());
			tab.setGraphic(Resource.getImage("property-viewer.png"));
			tab.setTooltip(new Tooltip(node.getFullPath()));

			tab.getContextMenu().getCloseAllMenuItem().setOnAction(new CloseAllTabEventHandler(this));
			tab.getContextMenu().getCloseOthersMenuItem().setOnAction(new CloseOthersTabEventHandler(this, content));
			tab.getContextMenu().getCloseMenuItem().setOnAction(new CloseTabEventHandler(this, content));

			List<Attribute> attr = model.getAttributeList(node);
			for (Attribute a : attr) {
				((AttributeTab) tab).addAttribute(a);
			}

			openTabs.put(content, tab);
			tab.setOnClosed(new TabCloseEventHandler(this, content));
		}
		selectTab(content);
		model.clearStatus();
	}

	public void openLayoutTab(BrowserTreeNode node) {
		if (!node.hasLayout()) {
			return;
		}

		DetailAreaTabContent content = new DetailAreaTabContent(node, NodeType.LAYOUT);
		if (!openTabs.containsKey(content)) {

			DetailAreaTab tab = view.openLayoutTab();
			tab.setText(node.getName());
			tab.setGraphic(Resource.getImage("layout-viewer.png"));
			tab.setTooltip(new Tooltip(node.getFullPath()));

			tab.getContextMenu().getCloseAllMenuItem().setOnAction(new CloseAllTabEventHandler(this));
			tab.getContextMenu().getCloseOthersMenuItem().setOnAction(new CloseOthersTabEventHandler(this, content));
			tab.getContextMenu().getCloseMenuItem().setOnAction(new CloseTabEventHandler(this, content));

			List<LayoutElement> list = model.getLayoutList(node);
			for (LayoutElement e : list) {
				((LayoutTab) tab).drawElement(e);
			}

			openTabs.put(content, tab);
			tab.setOnClosed(new TabCloseEventHandler(this, content));
		}
		selectTab(content);
		model.clearStatus();
	}

	public void openSourceTab(BrowserTreeNode node) {
		if (!node.hasSourcecode()) {
			return;
		}

		DetailAreaTabContent content = new DetailAreaTabContent(node, NodeType.SOURCECODE);
		if (!openTabs.containsKey(content)) {

			DetailAreaTab tab = view.openSourceTab();
			tab.setText(node.getName());
			tab.setGraphic(Resource.getImage("source-viewer.png"));
			tab.setTooltip(new Tooltip(node.getFullPath()));
			// TODO: set sourcecode

			tab.getContextMenu().getCloseAllMenuItem().setOnAction(new CloseAllTabEventHandler(this));
			tab.getContextMenu().getCloseOthersMenuItem().setOnAction(new CloseOthersTabEventHandler(this, content));
			tab.getContextMenu().getCloseMenuItem().setOnAction(new CloseTabEventHandler(this, content));

			openTabs.put(content, tab);
			tab.setOnClosed(new TabCloseEventHandler(this, content));
		}
		selectTab(content);
		model.clearStatus();
	}

	public void selectTab(DetailAreaTabContent content) {
		DetailAreaTab tab = openTabs.get(content);
		if (tab == null) {
			return;
		}
		view.select(tab.getUI());
	}

	public void closeTab(DetailAreaTabContent content) {
		DetailAreaTab tab = openTabs.get(content);
		if (tab == null) {
			return;
		}
		openTabs.remove(content);
		view.closeTab(tab.getUI());
	}

	public void closeOtherTabs(DetailAreaTabContent content) {
		for (DetailAreaTabContent c : new ArrayList<DetailAreaTabContent>(openTabs.keySet())) {
			if (c != content) {
				closeTab(c);
			}
		}
	}

	public void closeAllTabs() {
		for (DetailAreaTabContent c : new ArrayList<DetailAreaTabContent>(openTabs.keySet())) {
			closeTab(c);
		}
	}

	private void closeTab(BrowserTreeNode node) {
		for (DetailAreaTabContent c : new ArrayList<DetailAreaTabContent>(openTabs.keySet())) {
			if (c.getNode().equals(node)) {
				closeTab(c);
			}
		}
	}

	@Override
	public void onChangeEvent(ModelChangeEvent e) {
		if (e instanceof TreeChangeRemoveEvent) {
			closeTab(((TreeChangeRemoveEvent) e).getRemovedNode());
		}
	}
}

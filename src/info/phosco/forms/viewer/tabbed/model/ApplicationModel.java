package info.phosco.forms.viewer.tabbed.model;

import info.phosco.forms.translate.element.FormElement;
import info.phosco.forms.translate.element.application.CoordSystem;
import info.phosco.forms.translate.element.application.CoordSystemUnit;
import info.phosco.forms.translate.element.application.FormModule;
import info.phosco.forms.translate.element.application.ModuleAttributes;
import info.phosco.forms.translate.loader.Decompiler;
import info.phosco.forms.translate.loader.DecompilerFactory;
import info.phosco.forms.translate.loader.FormsLoader;
import info.phosco.forms.translate.util.DecompilerException;
import info.phosco.forms.translate.util.Log;
import info.phosco.forms.viewer.resource.Resource;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.browser.TreeChangeAddEvent;
import info.phosco.forms.viewer.tabbed.browser.TreeChangeRemoveEvent;
import info.phosco.forms.viewer.tabbed.browser.TreeSelectionChangeEvent;
import info.phosco.forms.viewer.tabbed.detail.Attribute;
import info.phosco.forms.viewer.tabbed.model.attributes.AttributeListFactory;
import info.phosco.forms.viewer.tabbed.model.browser.EmptyBrowserTreeFactory;
import info.phosco.forms.viewer.tabbed.model.browser.FormBrowserTreeFactory;
import info.phosco.forms.viewer.tabbed.util.Preferences;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;

public class ApplicationModel {
	private final static Logger log = Log.getLogger(ApplicationModel.class);

	private final List<ModelChangeListener> listeners;

	private final Map<BrowserTreeNode, FormModule> files;

	private File lastDir;

	private ReadOnlyStringWrapper status;

	private BrowserTreeNode root;

	private BrowserTreeNode selected;

	public ApplicationModel() {
		listeners = new ArrayList<ModelChangeListener>();
		files = new HashMap<BrowserTreeNode, FormModule>();
		status = new ReadOnlyStringWrapper(Resource.getString("viewer.statusbar.empty"));

		log.fine("Constructor ApplicationModel");
	}

	private void notifyListeners(ModelChangeEvent e) {
		for (ModelChangeListener l : listeners) {
			l.onChangeEvent(e);
		}
	}

	public void addModelChangeListener(ModelChangeListener l) {
		this.listeners.add(l);
	}

	public void removeModelChangeListener(ModelChangeListener l) {
		this.listeners.remove(l);
	}

	public void createEmptyTree() {
		this.root = EmptyBrowserTreeFactory.build();
		notifyListeners(new TreeChangeAddEvent(this.root));
	}

	private BrowserTreeNode getFormFolder() {
		for (BrowserTreeNode child : this.root.getChildren()) {
			if (child.getOffset() == EmptyBrowserTreeFactory.OFFSET_FORM_FOLDER) {
				return child;
			}
		}
		return null;
	}

	private BrowserTreeNode getFormRootOfNode(BrowserTreeNode node) {
		if (node == null) {
			return null;
		}
		if (files.get(node) == null) {
			return getFormRootOfNode(node.getParent());
		}
		return node;
	}

	private FormModule getFormModuleOfNode(BrowserTreeNode node) {
		if (node == null) {
			return null;
		}
		return files.get(getFormRootOfNode(node));
	}

	private void createFormTree(FormModule module) {
		BrowserTreeNode node = FormBrowserTreeFactory.build(module);
		getFormFolder().add(node);
		files.put(node, module);
		notifyListeners(new TreeChangeAddEvent(node));
	}

	public File getLastDir() {
		if (lastDir == null) {
			return new File(Preferences.getUserHomeDir());
		}
		return lastDir;
	}

	private void setLastDir(File path) {
		if (!path.isDirectory()) {
			lastDir = path.getParentFile();
		} else {
			lastDir = path;
		}
	}

	public void setStatus(String text, Object... values) {
		MessageFormat formatter = new MessageFormat("");
		formatter.setLocale(Locale.getDefault());
		formatter.applyPattern(text);
		status.setValue(formatter.format(values));
	}

	public String getStatus() {
		return status.getValue();
	}

	public ReadOnlyStringProperty statusProperty() {
		return status.getReadOnlyProperty();
	}

	public void clearStatus() {
		setStatus(Resource.getString("viewer.statusbar.empty"));
	}

	public void openFile(File file) throws DecompilerException {

		setLastDir(new File(file.getPath()));
		setStatus(Resource.getString("viewer.statusbar.loading"), file.getName());

		long start = System.currentTimeMillis();
		Decompiler dc = DecompilerFactory.instance(FormsLoader.load(file));
		FormModule module = dc.execute();

		createFormTree(module);

		long stop = System.currentTimeMillis();
		setStatus(Resource.getString("viewer.statusbar.loaded"), (double) (stop - start) / 1000);
	}

	private void dropFormTree(BrowserTreeNode node) {
		for (BrowserTreeNode n : new ArrayList<BrowserTreeNode>(node.getChildren())) {
			dropFormTree(n);
		}
		node.getParent().getChildren().remove(node);
		notifyListeners(new TreeChangeRemoveEvent(node));
	}

	public void closeFile(BrowserTreeNode node) {
		BrowserTreeNode root = getFormRootOfNode(node);
		dropFormTree(root);
		files.remove(root);
		notifyListeners(new TreeChangeRemoveEvent(root));
	}

	public List<Attribute> getAttributeList(BrowserTreeNode node) {
		FormModule form = getFormModuleOfNode(node);
		if (form == null) {
			return new ArrayList<Attribute>();
		}

		FormElement<?> elem = form.getElementAtOffset(node.getOffset());
		CoordinateSystem coords = new CoordinateSystem((CoordSystem) form.getProperty(ModuleAttributes.COORD_SYSTEM),
				(CoordSystemUnit) form.getProperty(ModuleAttributes.COORD_SYSTEM_UNIT));
		return AttributeListFactory.getList(elem, coords);
	}

	public List<LayoutElement> getLayoutList(BrowserTreeNode node) {
		FormModule form = getFormModuleOfNode(node);
		if (form == null) {
			return new ArrayList<LayoutElement>();
		}

		FormElement<?> elem = form.getElementAtOffset(node.getOffset());
		CoordinateSystem coords = new CoordinateSystem((CoordSystem) form.getProperty(ModuleAttributes.COORD_SYSTEM),
				(CoordSystemUnit) form.getProperty(ModuleAttributes.COORD_SYSTEM_UNIT));
		return LayoutFactory.getList(elem, coords);
	}
	
	public void setSelectedTreeNode(BrowserTreeNode node) {
		log.fine("TreeSelectionChange: " + node);
		this.selected = node;
		notifyListeners(new TreeSelectionChangeEvent(node));
	}

	public BrowserTreeNode getSelectedTreeNode() {
		return this.selected;
	}
}

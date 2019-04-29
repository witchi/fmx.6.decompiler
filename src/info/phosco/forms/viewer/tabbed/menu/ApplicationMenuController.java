package info.phosco.forms.viewer.tabbed.menu;

import info.phosco.forms.translate.util.Log;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeController;
import info.phosco.forms.viewer.tabbed.browser.BrowserTreeNode;
import info.phosco.forms.viewer.tabbed.browser.TreeSelectionChangeEvent;
import info.phosco.forms.viewer.tabbed.detail.DetailAreaController;
import info.phosco.forms.viewer.tabbed.model.ApplicationModel;
import info.phosco.forms.viewer.tabbed.model.ModelChangeEvent;
import info.phosco.forms.viewer.tabbed.model.ModelChangeListener;

import java.util.logging.Logger;

public class ApplicationMenuController implements ModelChangeListener {

	private final static Logger log = Log.getLogger(ApplicationMenuController.class);

	private final ApplicationModel model;

	private final ApplicationMenuBar view;

	private final DetailAreaController detailControl;

	private final BrowserTreeController browserControl;

	public ApplicationMenuController(ApplicationModel model, ApplicationMenuBar view, BrowserTreeController browserControl,
			DetailAreaController detailControl) {
		this.view = view;
		this.model = model;
		this.detailControl = detailControl;
		this.browserControl = browserControl;

		log.fine("Constructor ApplicationMenuController");

		view.getAboutMenuItem().setOnAction(new AboutEventHandler(view));

		view.getOpenFileMenuItem().setOnAction(new OpenFileEventHandler(model, view));
		view.getCloseFileMenuItem().setOnAction(new CloseFileEventHandler(model, view));
		view.getExitMenuItem().setOnAction(new ExitEventHandler());

		model.addModelChangeListener(this);

		view.getLayoutViewerMenuItem().setOnAction(new LayoutViewerEventHandler(model, detailControl));
		view.getPropertyViewerMenuItem().setOnAction(new PropertyViewerEventHandler(model, detailControl));
		validateMenus(null);
	}

	private void validateMenus(BrowserTreeNode node) {
		if (node == null) {
			view.getLayoutViewerMenuItem().setDisable(true);
			view.getPropertyViewerMenuItem().setDisable(true);
			view.getCloseFileMenuItem().setDisable(true);
			return;
		}
		view.getLayoutViewerMenuItem().setDisable(!node.hasLayout());
		view.getPropertyViewerMenuItem().setDisable(!node.hasAttributes());
		view.getCloseFileMenuItem().setDisable(node.isRoot() && node.isFolder());
	}

	@Override
	public void onChangeEvent(ModelChangeEvent e) {
		if (e instanceof TreeSelectionChangeEvent) {
			validateMenus(((TreeSelectionChangeEvent) e).getSelectedNode());
		}
	}

}

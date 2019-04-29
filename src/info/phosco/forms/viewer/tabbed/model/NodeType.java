package info.phosco.forms.viewer.tabbed.model;

public enum NodeType {

	LAYOUT {
		public boolean hasDetails() {
			return true;
		}
	},
	ATTRIBUTES {
		public boolean hasDetails() {
			return true;
		}
	},
	SOURCECODE {
		public boolean hasDetails() {
			return true;
		}
	},
	ROOT {
		public boolean hasDetails() {
			return false;
		}
	},
	FOLDER {
		public boolean hasDetails() {
			return false;
		}
	};

	public abstract boolean hasDetails();
}

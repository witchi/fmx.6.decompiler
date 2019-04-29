package info.phosco.forms.viewer.mdi;

import java.util.HashMap;

import jfxtras.scene.control.window.Window;

public class WindowList {

	private final HashMap<String, Window> storage;
	private final HashMap<Window, String> keys;

	public WindowList() {
		this.storage = new HashMap<String, Window>();
		this.keys = new HashMap<Window, String>();
	}

	public void put(String key, Window w) {
		this.storage.put(key, w);
		this.keys.put(w, key);
	}

	public void remove(Window w) {
		this.storage.remove(this.keys.get(w));
		this.keys.remove(w);
	}

	public void remove(String key) {
		this.keys.remove(this.storage.get(key));
		this.storage.remove(key);
	}

	public Window get(String key) {
		return this.storage.get(key);
	}

	public String get(Window w) {
		return this.keys.get(w);
	}
}

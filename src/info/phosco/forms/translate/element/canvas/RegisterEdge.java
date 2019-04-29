package info.phosco.forms.translate.element.canvas;

public enum RegisterEdge {

	ABOVE(0x0), BELOW(0x2), LEFT(0x3), RIGHT(0x1), BEGIN(0x4), END(0x5);

	private final int edge;

	private RegisterEdge(int edge) {
		this.edge = edge;
	}

	public static RegisterEdge lookup(int edge) {
		for (RegisterEdge t : RegisterEdge.values()) {
			if (t.edge == edge) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown RegisterEdge " + edge);
	}

}

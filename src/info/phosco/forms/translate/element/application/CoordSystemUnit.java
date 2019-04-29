package info.phosco.forms.translate.element.application;

public enum CoordSystemUnit {

	SCALING(0xA) {
		public float convert(int coord) {
			return coord;
		}
	},
	NO_SCALING(0x1) {
		public float convert(int coord) {
			return coord;
		}
	},
	PIXEL(0x2) {
		public float convert(int coord) {
			float factor = (8192f / 1000f) / 96f;
			return Math.round(coord / factor) / 1000f;
		}
	},
	INCH(0x3) {
		public float convert(int coord) {
			float factor = (8192f / 1000f) / 1f;
			return Math.round(coord / factor) / 1000f;
		}

		@Override
		public int significantFraction() {
			return 3;
		}
	},
	CENTIMETER(0x5) {
		public float convert(int coord) {
			float factor = (8192f / 1000f) / 2.54f;
			return Math.round(coord / factor) / 1000f;
		}

		@Override
		public int significantFraction() {
			return 3;
		}
	},
	POINT(0x7) {
		public float convert(int coord) {
			float factor = (8192f / 1000f) / 72f;
			return Math.round(coord / factor) / 1000f;
		}
	},
	DECIPOINT(0xC) {
		public float convert(int coord) {
			float factor = (8192f / 1000f) / 720f;
			return Math.round(coord / factor) / 1000f;
		}
	};

	private final int unit;

	private CoordSystemUnit(int unit) {
		this.unit = unit;
	}

	public static CoordSystemUnit lookup(int unit) {
		for (CoordSystemUnit t : CoordSystemUnit.values()) {
			if (t.unit == unit) {
				return t;
			}
		}
		throw new IllegalArgumentException("Unknown CoordSystemUnit " + unit);
	}

	public abstract float convert(int coord);

	public int significantFraction() {
		return 0;
	}
}

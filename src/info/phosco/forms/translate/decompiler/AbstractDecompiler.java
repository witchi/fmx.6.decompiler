package info.phosco.forms.translate.decompiler;

import info.phosco.forms.translate.bytes.UnsignedByteBuffer;

class AbstractDecompiler {

	protected final UnsignedByteBuffer array;

	public AbstractDecompiler(UnsignedByteBuffer array) {
		this.array = array;
	}

}

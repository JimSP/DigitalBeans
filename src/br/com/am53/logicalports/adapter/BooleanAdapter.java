package br.com.am53.logicalports.adapter;

import br.com.am53.logicalports.interfaces.AdapterInOut;

public class BooleanAdapter implements AdapterInOut<Boolean, Boolean> {

	@Override
	public Boolean convertOutToIn(Boolean output) {
		return output;
	}

	@Override
	public Boolean convertInToOut(Boolean input) {
		return input;
	}

}

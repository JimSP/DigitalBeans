package br.com.am53.logicalports.implement;

import br.com.am53.logicalports.exceptions.PortLogicalException;

public class Subtract extends BasePort<Double, Double> {

	@Override
	protected Double initPperation(Double a, Double b)
			throws PortLogicalException {
		return operation(a, b);
	}

	@Override
	protected Double operation(Double a, Double b) throws PortLogicalException {
		return a - b;
	}
}

package br.com.am53.logicalports.implement;

import br.com.am53.logicalports.exceptions.PortLogicalException;
import br.com.am53.logicalports.interfaces.LogicalPort;

public class And extends BasePort<Boolean, Boolean> implements LogicalPort<Boolean, Boolean> {

	@Override
	protected Boolean operation(Boolean a, Boolean b) {
		return a && b;
	}

	@Override
	protected Boolean initPperation(Boolean a, Boolean b)
			throws PortLogicalException {
		return operation(a,b);
	}
}
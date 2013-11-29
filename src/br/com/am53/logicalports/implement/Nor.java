package br.com.am53.logicalports.implement;

import java.util.ArrayList;
import java.util.List;

import br.com.am53.logicalports.exceptions.PortLogicalException;
import br.com.am53.logicalports.interfaces.LogicalPort;

public class Nor extends BasePort<Boolean, Boolean> implements LogicalPort<Boolean, Boolean> {

	private Or or = new Or();
	private Not not = new Not();
	
	@Override
	protected Boolean operation(Boolean a, Boolean b) throws PortLogicalException {
		List<Boolean> lista = new ArrayList<Boolean>(2);
		lista.add(a);
		lista.add(b);
		List<Boolean> lista1 = new ArrayList<Boolean>();
		lista1.add(or.process(lista));
		
		return not.process(lista1);
	}

	@Override
	protected Boolean initPperation(Boolean a, Boolean b)
			throws PortLogicalException {
		return operation(a,b);
	}
}
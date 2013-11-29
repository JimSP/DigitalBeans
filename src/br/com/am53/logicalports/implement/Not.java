package br.com.am53.logicalports.implement;

import java.util.List;

import br.com.am53.logicalports.exceptions.NotLogicalPortException;
import br.com.am53.logicalports.exceptions.PortLogicalException;
import br.com.am53.logicalports.interfaces.LogicalPort;

public class Not implements LogicalPort<Boolean, Boolean> {

	public Boolean process(List<Boolean> input) throws PortLogicalException {

		if(input.size() == 1)
			return !input.get(0);
		
		throw (PortLogicalException) new NotLogicalPortException();
	}
}

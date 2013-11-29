package br.com.am53.logicalports.interfaces;

import java.util.List;

import br.com.am53.logicalports.exceptions.PortLogicalException;

public interface LogicalPort<T,K> {
	public K process(List<T> inputs) throws PortLogicalException;
}

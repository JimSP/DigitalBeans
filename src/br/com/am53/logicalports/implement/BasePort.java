package br.com.am53.logicalports.implement;

import java.util.List;

import br.com.am53.logicalports.exceptions.PortLogicalException;
import br.com.am53.logicalports.interfaces.LogicalPort;

public abstract class BasePort<T,K> implements LogicalPort<T,K> {

	public K process(List<T> inputs) throws PortLogicalException {
		K R = null;
		if(inputs != null)
			if(inputs.size() > 1){
				
				int i = 0;
				R =  initPperation(inputs.get(i++), inputs.get(i++)); 
				while(i < inputs.size()){
					R = operation(R, inputs.get(i++)); 
					i++;
				}
			}
		
		return R;
	}
	
	protected abstract K initPperation(T a, T b) throws PortLogicalException;
	protected abstract K operation(K a, T b) throws PortLogicalException;

}

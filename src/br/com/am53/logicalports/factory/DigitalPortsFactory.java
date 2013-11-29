package br.com.am53.logicalports.factory;

import java.lang.reflect.InvocationTargetException;

import br.com.am53.logicalports.interfaces.LogicalPort;

public class DigitalPortsFactory<T,K> {

	private static DigitalPortsFactory thisInstance = new DigitalPortsFactory();
	public static DigitalPortsFactory getInstance(){
		return DigitalPortsFactory.thisInstance;
	}

	private DigitalPortsFactory(){
		
	}

	public LogicalPort<T,K> getPortByName(String name) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		return (LogicalPort<T,K>) Class.forName(name).getConstructor(new Class[0]).newInstance(new Object[0]);
	}
}

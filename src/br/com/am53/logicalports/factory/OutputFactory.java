package br.com.am53.logicalports.factory;

import java.lang.reflect.InvocationTargetException;

import br.com.am53.logicalports.interfaces.IOutput;

public class OutputFactory {
	private static OutputFactory thisInstance = new OutputFactory();
	public static OutputFactory getInstance(){
		return OutputFactory.thisInstance;
	}

	private OutputFactory(){
		
	}

	public IOutput getOutput(String name) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		return (IOutput) Class.forName(name).getConstructor(new Class[0]).newInstance(new Object[0]);
	}
}

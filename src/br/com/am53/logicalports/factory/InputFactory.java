package br.com.am53.logicalports.factory;

import java.lang.reflect.InvocationTargetException;

import br.com.am53.logicalports.interfaces.IInput;

public class InputFactory<T> {
	
	private static InputFactory thisInstance = new InputFactory();
	public static InputFactory getInstance(){
		return InputFactory.thisInstance;
	}

	private InputFactory(){
		
	}

	public IInput<T> getInput(String name) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		return (IInput<T>) Class.forName(name).getConstructor(new Class[0]).newInstance(new Object[0]);
	}

}



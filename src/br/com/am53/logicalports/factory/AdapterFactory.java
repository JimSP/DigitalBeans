package br.com.am53.logicalports.factory;

import java.lang.reflect.InvocationTargetException;

import br.com.am53.logicalports.interfaces.AdapterInOut;

public class AdapterFactory<T, K> {
	
	private static AdapterFactory thisInstance = new AdapterFactory();

	public static AdapterFactory getInstance(){
		return AdapterFactory.thisInstance;
	}

	private AdapterFactory(){
		
	}
	
	public AdapterInOut<T, K> getAdapter(String name)throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException{
		return (AdapterInOut<T, K>) Class.forName(name).getConstructor(new Class[0]).newInstance(new Object[0]);
	}

}

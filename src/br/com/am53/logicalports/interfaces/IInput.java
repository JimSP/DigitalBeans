package br.com.am53.logicalports.interfaces;

public interface IInput<T> {
	public String[] getKeys();
	public T[] getValues();
	
	public void parseInterface(String circuitPath);
}

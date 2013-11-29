package br.com.am53.logicalports.interfaces;

public interface AdapterInOut<T,K> {
	T convertOutToIn(K output);
	K convertInToOut(T input);
}

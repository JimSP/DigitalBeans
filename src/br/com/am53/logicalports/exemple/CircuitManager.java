package br.com.am53.logicalports.exemple;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import br.com.am53.logicalports.DigitalCircuit;
import br.com.am53.logicalports.adapter.BooleanAdapter;
import br.com.am53.logicalports.exceptions.PortLogicalException;
import br.com.am53.logicalports.factory.InputFactory;
import br.com.am53.logicalports.factory.OutputFactory;
import br.com.am53.logicalports.interfaces.IInput;
import br.com.am53.logicalports.interfaces.IOutput;

public class CircuitManager {

	public static void call(String[] args) {
		
		int i = 0;
		String circuitPath = args[i++];
		
		try {
			IInput<Boolean> input = InputFactory.getInstance().getInput(args[i++]);
			IOutput output = OutputFactory.getInstance().getOutput(args[i++]);
			new DigitalCircuit<Boolean, Boolean>(new BooleanAdapter()).process(circuitPath, input, output);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (PortLogicalException e) {
			e.printStackTrace();
		}
	}
}

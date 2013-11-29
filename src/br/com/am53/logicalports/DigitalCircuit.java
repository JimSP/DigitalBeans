package br.com.am53.logicalports;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import br.com.am53.logicalports.exceptions.PortLogicalException;
import br.com.am53.logicalports.factory.DigitalPortsFactory;
import br.com.am53.logicalports.interfaces.AdapterInOut;
import br.com.am53.logicalports.interfaces.IInput;
import br.com.am53.logicalports.interfaces.IOutput;
import br.com.am53.logicalports.interfaces.LogicalPort;

public class DigitalCircuit<T,K> {

	private AdapterInOut<T, K> adapter = null;
	private DigitalPortsFactory<T,K> factory = DigitalPortsFactory.getInstance();

	public DigitalCircuit(AdapterInOut<T, K> adapter){
		this.adapter = adapter;
	}
	
	public void process(String circuitPath, IInput<T> input, IOutput output)
			throws IOException, IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException,
			ClassNotFoundException, PortLogicalException {

		Hashtable<String, K> memoryOutMap = new Hashtable<String, K>();
		Hashtable<String, T> memoryInMap = new Hashtable<String, T>();
		input.parseInterface(circuitPath);
		int index = 0;
		T[] inputs = input.getValues();
		for (String key : input.getKeys()) {
			memoryInMap.put(key, inputs[index++]);
		}

		FileReader reader = new FileReader(circuitPath);
		BufferedReader buffer = new BufferedReader(reader);

		String line = "";
		String pacote = "";
		String[] entradas = null;
		String porta = null;
		String saida = null;

		int nLine = 0;
		int j = 0;
		while (buffer.ready()) {
			line = buffer.readLine();
			if (line.length() > 0)
				if (!"#".equals(line.substring(0, 1))) {
					if (nLine == 0) {
						pacote = line;
					} else {
						String[] inPortOut = line.split("[>]");
						String entradasAr = inPortOut[0];
						porta = inPortOut[1];
						saida = inPortOut[2];

						entradas = entradasAr.split("[,]");

						LogicalPort<T,K> portaLogica = factory.getPortByName(pacote
								+ "." + porta);

						List<T> inputPort = new ArrayList<T>(entradas.length);

						int i = 0;
						for (String inputMemoryName : entradas) {
							if (memoryOutMap.containsKey(inputMemoryName)) {
								inputPort.add(adapter.convertOutToIn(memoryOutMap.get(inputMemoryName)));
							} else {
								
								if(memoryInMap.containsKey(inputMemoryName)){
									inputPort.add(memoryInMap.get(inputMemoryName));
								}else{
									inputPort.add(inputs[j++]);
								}
							}
						}

						K R = portaLogica.process(inputPort);
						memoryOutMap.put(saida, R);
					}
					nLine++;
				}
		}

		buffer.close();
		reader.close();

		String[] a = new String[memoryOutMap.size()];
		int index2 = 0;
		Enumeration<String> itens = memoryOutMap.keys();
		while (itens.hasMoreElements()) {
			String key = itens.nextElement();
			T value = adapter.convertOutToIn(memoryOutMap.get(key));
			a[index2++] = key + "=" + value.toString();
		}
		
		output.parseInterface(circuitPath, a);
	}
}

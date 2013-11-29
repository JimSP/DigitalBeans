package br.com.am53.logicalports.exemple;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.am53.logicalports.interfaces.IInput;


public class FileInput implements IInput<Boolean> {

	private String[] keys = null;
	private Boolean[] values = null;
	
	@Override
	public String[] getKeys() {
		return keys;
	}

	@Override
	public Boolean[] getValues() {
		return values;
	}

	@Override
	public void parseInterface(String circuitPath) {
		
		List<String> listInKey = new ArrayList<String>();
		List<Boolean> listInValue = new ArrayList<Boolean>();

		try {
			String fileNameIN = circuitPath.split("[.]")[0] + ".in";
			FileReader reader = new FileReader(fileNameIN);
			BufferedReader buffer = new BufferedReader(reader);

			while (buffer.ready()) {
				String line = buffer.readLine();
				String[] memory = line.split("[=]");
				String key = memory[0];
				Boolean value = Boolean.parseBoolean(memory[1]);
				
				listInKey.add(key);
				listInValue.add(value);
			}

			buffer.close();
			reader.close();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		String[] s = new String[listInKey.size()];
		keys = listInKey.toArray(s);

		Boolean[] b = new Boolean[listInValue.size()];
		values = listInValue.toArray(b);
	}
}

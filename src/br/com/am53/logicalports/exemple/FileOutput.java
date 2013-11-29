package br.com.am53.logicalports.exemple;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.am53.logicalports.interfaces.IOutput;

public class FileOutput implements IOutput {

	@Override
	public void parseInterface(String circuitPath, String[] R) {
		FileWriter writer = null;
		BufferedWriter buffer = null;

		try {
			writer = new FileWriter(circuitPath.split("[.]")[0] + "_"
					+ System.currentTimeMillis() + ".out");
			
			buffer = new BufferedWriter(writer);

			//System.out.println("path_circuit=" + circuitPath);
			buffer.append("path_circuit=" + circuitPath + "\n");

			//System.out.println();

			for (String r : R) {
				//System.out.println(r);
				buffer.append(r + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				buffer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

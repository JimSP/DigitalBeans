package br.com.am53.logicalports.exemple;
public class Main {

	public static void main(String[] args) {
		
		CircuitManager.call(args);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

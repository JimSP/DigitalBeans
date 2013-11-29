package br.com.am53.logicalports.exceptions;

public class NotLogicalPortException extends PortLogicalException {
	
	private static final long serialVersionUID = -8654815642336238330L;

	public NotLogicalPortException(){
		super("porta not possui apenas 1 entada!");
	}
}

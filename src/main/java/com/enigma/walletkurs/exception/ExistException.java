package com.enigma.walletkurs.exception;

public class ExistException extends BaseException {
	private static final long serialVersionUID = 1L;
	public ExistException(int i, String desc) {
		this.code=i;
		this.description=desc;
	}

	/**
	 * 
	 */
	
	
}

package com.enigma.walletkurs.exception;

public class InsufficientAmountException extends BaseException {
	public InsufficientAmountException(int i, String desc) {
		this.code=i;
		this.description=desc;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}

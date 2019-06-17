package com.enigma.walletkurs.exception;

public class NotFoundException extends BaseException {
	public NotFoundException(int i, String desc) {
		this.code=i;
		this.description=desc;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
}

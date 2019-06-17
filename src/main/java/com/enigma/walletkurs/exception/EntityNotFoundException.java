package com.enigma.walletkurs.exception;

public class EntityNotFoundException extends BaseException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public EntityNotFoundException(int i,String desc){
		this.code=i;
		this.description=desc;
	}

}

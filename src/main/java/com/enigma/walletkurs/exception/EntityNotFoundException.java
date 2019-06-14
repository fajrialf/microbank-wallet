package com.enigma.walletkurs.exception;

public class EntityNotFoundException extends Exception {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	int code;
	String description;

	public EntityNotFoundException(int i,String desc){
		this.code=i;
		this.description=desc;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

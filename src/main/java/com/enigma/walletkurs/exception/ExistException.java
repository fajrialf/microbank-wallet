package com.enigma.walletkurs.exception;

public class ExistException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int code;
	String description;
	
	public ExistException(int code,String desc){
		this.code=code;
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

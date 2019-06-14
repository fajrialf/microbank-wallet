package com.enigma.walletkurs.exception;

public class BadRequestException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String code,description;
	
	public BadRequestException(String code,String desc){
		this.code=code;
		this.description=desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

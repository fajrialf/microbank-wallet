package com.enigma.walletkurs.additional;

public class Autogenerateid {
	String code;
	String current;
	String pad;
	int length;
	public Autogenerateid(String code,String current,String pad,int length){
		this.code=code;
		this.current=current;
		this.pad=pad;
		this.length=length;
	}
	
	public String generatedid() {
		int le=current.length();
		String tid= current.substring(this.length,le);
		String newcode=this.code+String.format("%"+this.pad+""+(this.length+1)+"d", Integer.parseInt(tid) +1);
		return newcode;
	}
}
